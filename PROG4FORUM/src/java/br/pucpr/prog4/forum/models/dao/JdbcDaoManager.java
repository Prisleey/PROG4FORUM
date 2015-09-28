package br.pucpr.prog4.forum.models.dao;

import br.pucpr.prog4.forum.exception.ForumException;
import br.pucpr.prog4.forum.interfaces.IAssuntoDAO;
import br.pucpr.prog4.forum.interfaces.IDaoManager;
import br.pucpr.prog4.forum.interfaces.ITopicoDAO;
import br.pucpr.prog4.forum.interfaces.IUsuarioDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcDaoManager implements IDaoManager {

    private Connection conexao;
    private JdbcAssuntoDAO assuntoDAO;
    private JdbcUsuarioDAO usuarioDAO;
    private JdbcTopicoDAO topicoDAO;
    public static JdbcDaoManager instance;

    public JdbcDaoManager() {
        this.assuntoDAO = new JdbcAssuntoDAO();
        this.usuarioDAO = new JdbcUsuarioDAO();
        this.topicoDAO = new JdbcTopicoDAO();
    }

    public static JdbcDaoManager getInstance() { 
        if(instance == null){ 
            instance = new JdbcDaoManager();    
        } 
        return instance; 
    } 

    @Override
    public void iniciar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url;
            url = "jdbc:mysql://localhost:3306/Forum";
            conexao = DriverManager.getConnection(url, "root", "root");

            conexao.setAutoCommit(false);
            assuntoDAO.setConexao(conexao);
            usuarioDAO.setConexao(conexao);
            topicoDAO.setConexao(conexao);
        } catch (ClassNotFoundException e) {
            throw new ForumException("Erro conector JDBC " + e.getMessage());
        } catch(SQLException e) {
            throw new ForumException("Ocorreu um erro ao conectar ao banco de dados: " + 
                    e.getMessage());
        }
    }

    @Override
    public void encerrar() {
        try {
            if(!conexao.isClosed()) {
                conexao.close();
                conexao = null;
            }
        } catch (SQLException e) {
            throw new ForumException("Erro " + e.getMessage());
        }
    }

    @Override
    public void confirmarTransação() {
        try {
            conexao.commit();
        } catch (SQLException ex) {
            throw new ForumException("Ocorreu um erro ao confirmar a transação" + ex.getMessage());
        }
    }

    @Override
    public void abortarTransação() {
        try {
            conexao.rollback();
        } catch (SQLException ex) {
            throw new ForumException("Ocorreu um erro ao confirmar a transação" + ex.getMessage());
        }
    }

    @Override
    public IAssuntoDAO getAssuntoDAO() {
        return assuntoDAO;
    }

    @Override
    public ITopicoDAO getTopicoDAO() {
        return topicoDAO;
    }

    @Override
    public IUsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }
}