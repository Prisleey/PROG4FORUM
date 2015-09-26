package br.pucpr.prog4.forum.models.dao;

import br.pucpr.prog4.forum.exception.ForumException;
import br.pucpr.prog4.forum.interfaces.IAssuntoDAO;
import br.pucpr.prog4.forum.interfaces.IDaoManager;
import br.pucpr.prog4.forum.interfaces.ITopicoDAO;
import br.pucpr.prog4.forum.interfaces.IUsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;

public class JdbcDaoManager implements IDaoManager {

    private Connection conexao;
    private JdbcAssuntoDAO assuntoDAO;
    private JdbcUsuarioDAO usuarioDAO;
    private JdbcTopicoDAO topicoDAO;

    public JdbcDaoManager() {
        
    }

    @Override
    public void iniciar() {
        if(conexao == null) {
            conexao = Conexao.getInstance().getConnection();
        }
        this.topicoDAO = new JdbcTopicoDAO();
        this.usuarioDAO = new JdbcUsuarioDAO(conexao);
        this.assuntoDAO = new JdbcAssuntoDAO();
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