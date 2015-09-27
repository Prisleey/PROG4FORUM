package br.pucpr.prog4.forum.models.dao;

import br.pucpr.prog4.forum.interfaces.IUsuarioDAO;
import br.pucpr.prog4.forum.exception.ForumException;
import br.pucpr.prog4.forum.models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcUsuarioDAO implements IUsuarioDAO {

    private Connection conexao;

    public JdbcUsuarioDAO() {
        
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }
    
    @Override
    public boolean inserirUsuario(Usuario user) {
        if (getNomeUser(user) == false) {
            return false;
        }
        String sql;
        sql = "INSERT INTO usuario("
                + "nome,"
                + "email,"
                + "senha,"
                + "nomeLogin)"
                + " VALUES (?, ?, ?, ?)";

        PreparedStatement ps;
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, user.getNomeUser());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getSenha());
            ps.setString(4, user.getNomeLogin());
            ps.executeUpdate();

        } catch (Exception ex) {
            throw new ForumException("Ocorreu um erro ao inserir um usuario " + ex.getMessage());
        }
        return true;
    }

    @Override
    public boolean getNomeUser(Usuario user) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Usuario usu = null;
        try {
            String sql;
            sql = "SELECT "
                    + "id, "
                    + "nome, "
                    + "email, "
                    + "senha, "
                    + "nomeLogin "
                    + "FROM usuario "
                    + "WHERE nomeLogin = ? "
                    + "OR email = ? ";
            ps = conexao.prepareStatement(sql);
            ps.setString(1, user.getNomeLogin());
            ps.setString(2, user.getEmail());
            rs = ps.executeQuery();
            if(rs.next()) {
                usu = populateObject(rs);
            }

        } catch (SQLException e) {
            throw new ForumException("Erro com o banco de dados, tente novamente mais tarde " + e.getMessage());
        }
        if (usu == null) {
            return true;
        }
        return false;
    }
    
    @Override
    public List<Usuario> getTodosUsuarios() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Usuario> users = new ArrayList<Usuario>();

        try {
            String sql;
            sql = "SELECT * FROM usuario";
            ps = conexao.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                users.add(populateObject(rs));
            }
        }catch(SQLException e){
            throw new ForumException("Problemas no sistema, por favor tente mais tarde");
        }
        return users;
    }

    @Override
    public Usuario getUsuarioPorId(long id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Usuario user = null;
        try {
            String sql;
            sql = "SELECT "
                    + "id, "
                    + "nome, "
                    + "email, "
                    + "senha, "
                    + "nomeLogin, "
                    + "FROM usuario "
                    + "WHERE id = ?";
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if(rs.next()) {
                user = populateObject(rs);
            }

        } catch (SQLException e) {
            throw new ForumException("Erro com o banco de dados, tente novamente mais tarde " + e.getMessage());
        }
        return user;
    }

    @Override
    public Usuario getUsuarioLogin(String email, String senha) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Usuario user = null;
        try {
            String sql;
            sql = "SELECT "
                    + "id, "
                    + "nome, "
                    + "email, "
                    + "senha, "
                    + "nomeLogin "
                    + "FROM usuario "
                    + "WHERE email = ? and senha = ?";
            ps = conexao.prepareStatement(sql);
            ps.setString(1,email);
            ps.setString(2,senha);

            rs = ps.executeQuery();
            if(rs.next()) {
                user = populateObject(rs);
            }
        } catch(SQLException e) {
            throw new ForumException("Erro com o banco de dados, tente novamente mais tarde" + e.getMessage());
        }
        return user;
    }

    private Usuario populateObject(ResultSet rs) throws SQLException {
        Usuario user = new Usuario(rs.getString("nomeLogin"), rs.getString("email"));
        user.setId(rs.getLong("id"));
        user.setSenha(rs.getString("senha"));
        user.setNomeUser(rs.getString("nome"));
        return user;
    }
}