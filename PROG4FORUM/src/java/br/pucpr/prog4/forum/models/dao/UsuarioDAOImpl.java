package br.pucpr.prog4.forum.models.dao;

import br.pucpr.prog4.forum.interfaces.IDaoManager;
import br.pucpr.prog4.forum.interfaces.IUsuarioDAO;
import br.pucpr.prog4.forum.models.Usuario;
import java.util.List;

public class UsuarioDAOImpl implements IUsuarioDAO{

    @Override
    public Usuario inserirUsuario(Usuario pessoa) {
        IDaoManager iManager = new JdbcDaoManager();
        IUsuarioDAO iUserDAO;
        try {
            iManager.iniciar();
            iUserDAO = iManager.getUsuarioDAO();
            Usuario usuario = iUserDAO.inserirUsuario(pessoa);
            iManager.confirmarTransação();
            iManager.encerrar();
            return usuario;
        }catch (Exception e) {
            throw e;
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
            iManager.encerrar();
            return users;
        } catch (Exception e) {
            throw e;
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
            iManager.encerrar();
            return user;
        } catch (Exception e) {
            throw e;
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
            iManager.encerrar();
            return user;
        } catch (Exception e) {
            throw e;
        }
    }   
}