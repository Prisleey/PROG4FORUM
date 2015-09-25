package br.pucpr.prog4.forum.models.dao;

import br.pucpr.prog4.forum.interfaces.IUsuarioDAO;
import br.pucpr.prog4.forum.exception.ForumException;
import br.pucpr.prog4.forum.models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                + "senha)"
                + " VALUES (?, ?, ?)";

        PreparedStatement ps;
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, user.getNomeUser());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getSenha());
            ps.executeUpdate();
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
        PreparedStatement ps = null;
        ResultSet rs = null;
        Usuario usuario = null;
        try {
            String select = "SELECT id, nomeUser, email, senha, nomeLogin from usuario WHERE email = ? and senha = ?";
            ps = conexao.prepareStatement(select);
            ps.setString(1,email);
            ps.setString(2,senha);
            
            rs = ps.executeQuery();
            if(rs.next()) {
                usuario = populateObject(rs);
            }
            return usuario;
        }catch(SQLException e){
            throw new ForumException("Erro com o banco de dados, tente novamente mais tarde" + e.getMessage());
        }
    }

    private Usuario populateObject(ResultSet rs) throws SQLException {
        Usuario user = new Usuario(rs.getString("nomeLogin"), rs.getString("email"));
        user.setId(rs.getLong("id"));
        user.setSenha(rs.getString("senha"));
        user.setNomeUser("nome");
        
        /*
        Usuario usuario = new Usuario(rs.getString("nome"),rs.getString("email"));
        usuario.setCpf(rs.getLong("cpf"));
        usuario.setId(rs.getLong("id"));
        usuario.setIdade(rs.getInt("idade"));
        usuario.setSenha(rs.getString("senha"));
        */
        return user;
    }
}