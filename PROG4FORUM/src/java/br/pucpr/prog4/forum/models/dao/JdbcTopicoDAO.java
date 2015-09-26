package br.pucpr.prog4.forum.models.dao;

import br.pucpr.prog4.forum.interfaces.ITopicoDAO;
import br.pucpr.prog4.forum.exception.ForumException;
import br.pucpr.prog4.forum.models.Assunto;
import br.pucpr.prog4.forum.models.Topico;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
                + "assunto,"
                + "topico,"
                + "resposta) "
                + "VALUES (?, ?, ?)";

        PreparedStatement ps;
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, topico.getAssunto().getAssunto());
            ps.setString(2, topico.getTopico());
            ps.setString(3, topico.getRespostas().get(0).getResposta());
            ps.executeQuery();
            return true;

        } catch (Exception ex) {
            throw new ForumException("Ocorreu um erro ao inserir um usuario " + ex.getMessage());
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
}