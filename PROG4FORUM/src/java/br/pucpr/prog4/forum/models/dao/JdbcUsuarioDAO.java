package br.pucpr.prog4.forum.models.dao;

import br.pucpr.prog4.forum.interfaces.IUsuarioDAO;
import br.pucpr.prog4.forum.exception.ForumException;
import br.pucpr.prog4.forum.models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class JdbcUsuarioDAO implements IUsuarioDAO {

    private Connection conexao;

    public JdbcUsuarioDAO(Connection conexao) {
        this.conexao = conexao;
    }
    
    @Override
    public boolean inserirUsuario(Usuario user) {
        String sql;
        sql = "INSERT INTO usuario("
                + "nome,"
                + "email,"
                + "senha"
                + " VALUES (?, ?, ?)";

        PreparedStatement ps;
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, user.getNomeUser());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getSenha());
            ps.executeQuery();
            return true;

        } catch (Exception ex) {
            throw new ForumException("Ocorreu um erro ao inserir um usuario " + ex.getMessage());
        }
    }

    @Override
    public List<Usuario> getTodosUsuarios() {
        return null;
    }

    @Override
    public Usuario getUsuarioPorId(long id) {
        return null;
    }

    @Override
    public Usuario getUsuarioLogin(String email, String senha) {
        return null;
    }
}