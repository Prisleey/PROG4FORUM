package br.pucpr.prog4.forum.models.dao;

import br.pucpr.prog4.forum.exception.ForumException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcDaoManager// implements IDaoManager 
{
    private Connection conexao;
    private JdbcUsuarioDAO pessoaDAO;
    
    public JdbcDaoManager()
    {
        this.pessoaDAO = new JdbcUsuarioDAO();
    }
    
    //@Override
    public void iniciar() throws ForumException
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
            throw new ForumException("Ocorreu um erro ao conectar ao banco de dados:" + 
                    ex.getMessage());
        }
    }

    //@Override
    public void encerrar() 
    {
        try {
            if(!conexao.isClosed())
                conexao.close();
        } catch (SQLException ex) {
            
        }
    }

    //@Override
    public void confirmarTransação() {
        try {
            conexao.commit();
        } catch (SQLException ex) {
            throw new ForumException("Ocorreu um erro ao confirmar a transação" + ex.getMessage());
        }
    }

    //@Override
    public void abortarTransação() {
        try {
            conexao.rollback();
        } catch (SQLException ex) {
            throw new ForumException("Ocorreu um erro ao confirmar a transação" + ex.getMessage());
        }
    }

    //@Override
    /*public IPessoaDAO getPessoaDAO() {
        return pessoaDAO;
    } */   
}