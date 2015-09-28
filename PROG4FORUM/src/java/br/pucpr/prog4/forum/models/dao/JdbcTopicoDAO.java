package br.pucpr.prog4.forum.models.dao;

import br.pucpr.prog4.forum.interfaces.ITopicoDAO;
import br.pucpr.prog4.forum.exception.ForumException;
import br.pucpr.prog4.forum.models.Assunto;
import br.pucpr.prog4.forum.models.Topico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcTopicoDAO implements ITopicoDAO {

    private Connection conexao;

    public JdbcTopicoDAO() {
        
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public boolean inserirTopico(Topico topico) {
        String sql;
        sql = "INSERT INTO topico("
                + "id_assunto, "
                + "id_usuario, "
                + "topico, "
                + "dataCriacao) "
                + "VALUES (?, ?, ?, ?)";

        PreparedStatement ps;
        try {
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, topico.getAssunto().getId());
            ps.setLong(2, topico.getAutor().getId());
            ps.setString(3, topico.getTopico());
            java.sql.Date dataSQL = new java.sql.Date(topico.getDataCriacao().getTime());
            ps.setDate(4, dataSQL);
            ps.executeUpdate();
            return true;

        } catch (Exception ex) {
            throw new ForumException("Ocorreu um erro ao inserir um topico " + ex.getMessage());
        }
    }

    @Override
    public List<Topico> buscarTopicos() {
        return null;
    }

    @Override
    public List<Topico> buscarTopicosPorAssunto(Assunto assunto) {
        return null;
    }

    @Override
    public Topico buscarTopicoPorId(long id) {
        return null;
    }

    private Topico populateObject(ResultSet rs) throws SQLException {
        /*Topico topi = new Topico(rs.getString("nomeLogin"), rs.getString("email"));
        topi.setId(rs.getLong("id"));
        topi.setTopico(rs.getString("topico"));
        //topi.setAssunto();
        topi.setRespostas(rs.);
        */
        return null;
        
    }
}