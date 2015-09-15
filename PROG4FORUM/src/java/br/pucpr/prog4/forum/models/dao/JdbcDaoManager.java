package br.pucpr.prog4.forum.models.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcDaoManager implements IDaoManager 
{
    private Connection conexao;
    private JdbcPessoaDAO pessoaDAO;
    
    public JdbcDaoManager()
    {
        this.pessoaDAO = new JdbcPessoaDAO();
    }
    
    @Override
    public void iniciar() throws DaoException
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url;
            url = "jdbc:mysql://localhost:3306/lojaprisley";
            conexao = DriverManager.getConnection(url, "root", "root");
            
            conexao.setAutoCommit(false);
            pessoaDAO.setConexão(conexao);
        }
        catch( Exception ex )
        {
            throw new DaoException("Ocorreu um erro ao conectar ao banco de dados:" + 
                    ex.getMessage());
        }
    }

    @Override
    public void encerrar() 
    {
        try {
            if(!conexao.isClosed())
                conexao.close();
        } catch (SQLException ex) {
            
        }
    }

    @Override
    public void confirmarTransação() {
        try {
            conexao.commit();
        } catch (SQLException ex) {
            throw new DaoException("Ocorreu um erro ao confirmar a transação" + ex.getMessage());
        }
    }

    @Override
    public void abortarTransação() {
        try {
            conexao.rollback();
        } catch (SQLException ex) {
            throw new DaoException("Ocorreu um erro ao confirmar a transação" + ex.getMessage());
        }
    }

    @Override
    public IPessoaDAO getPessoaDAO() {
        return pessoaDAO;
    }    
}