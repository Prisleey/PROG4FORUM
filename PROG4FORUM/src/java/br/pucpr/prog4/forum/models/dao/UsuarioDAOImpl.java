package br.pucpr.prog4.forum.models.dao;

import br.pucpr.prog4.forum.interfaces.IDaoManager;
import br.pucpr.prog4.forum.interfaces.IUsuarioDAO;
import br.pucpr.prog4.forum.models.Usuario;
import java.util.List;

public class UsuarioDAOImpl implements IUsuarioDAO{

    @Override
    public boolean inserirUsuario(Usuario user) {
        IDaoManager iManager = new JdbcDaoManager();
        IUsuarioDAO iUserDAO;
        try {
            iManager.iniciar();
            iUserDAO = iManager.getUsuarioDAO();
            iUserDAO.inserirUsuario(user);
            iManager.confirmarTransação();
            return true;
        }catch (Exception e) {
            iManager.abortarTransação();
            throw e;
        } finally {
            iManager.encerrar();
        }
    }

    @Override
    public List<Usuario> getTodosUsuarios() {
        IDaoManager iManager = new JdbcDaoManager();
        IUsuarioDAO iUserDAO;
        try {
            iManager.iniciar();
            iUserDAO = iManager.getUsuarioDAO();
            List<Usuario> users = iUserDAO.getTodosUsuarios();
            iManager.confirmarTransação();
            return users;
        } catch (Exception e) {
            iManager.abortarTransação();
            throw e;
        } finally {
            iManager.encerrar();
        }
    }

    @Override
    public Usuario getUsuarioPorId(long id) {
        IDaoManager iManager = new JdbcDaoManager();
        IUsuarioDAO iUserDAO;
        try {
            iManager.iniciar();
            iUserDAO = iManager.getUsuarioDAO();
            Usuario user = iUserDAO.getUsuarioPorId(id);
            iManager.confirmarTransação();
            return user;
        } catch (Exception e) {
            iManager.abortarTransação();
            throw e;
        } finally {
            iManager.encerrar();
        }
    }

    @Override
    public Usuario getUsuarioLogin(String email, String senha) {
        IDaoManager iManager = new JdbcDaoManager();
        IUsuarioDAO iUserDAO;
        try {
            iManager.iniciar();
            iUserDAO = iManager.getUsuarioDAO();
            Usuario user = iUserDAO.getUsuarioLogin(email, senha);
            iManager.confirmarTransação();
            return user;
        } catch (Exception e) {
            iManager.abortarTransação();
            throw e;
        } finally {
            iManager.encerrar();
        }
    }   
}