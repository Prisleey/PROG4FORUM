package br.pucpr.prog4.forum.models.dao;

import br.pucpr.prog4.forum.exception.ForumException;
import br.pucpr.prog4.forum.interfaces.IAssuntoDAO;
import br.pucpr.prog4.forum.models.Assunto;
import br.pucpr.prog4.forum.models.Topico;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

public class JdbcAssuntoDAO implements IAssuntoDAO {

    private Connection conexao;

    public JdbcAssuntoDAO() {
        
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }
    
    @Override
    public boolean inserirAssunto(Assunto assunto) {
        String sql;
        sql = "INSERT INTO assunto("
                + "assunto, "
                + "autor, "
                + "dataCriacao) "
                + "VALUES (?, ?, ?)";

        PreparedStatement ps;
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, assunto.getAssunto());
            ps.setString(2, assunto.getCriador().getNomeLogin());
            java.sql.Date dataSQL = new java.sql.Date(assunto.getDataAssunto().getTime());
            ps.setDate(3, dataSQL);
            ps.executeUpdate();

        } catch (Exception ex) {
            throw new ForumException("Ocorreu um erro ao inserir um usuario " + ex.getMessage());
        }
        return true;
    }

    @Override
    public List<Assunto> buscarAssuntos() {
        return null;
    }

    @Override
    public List<Topico> buscarTopicosAssunto(Assunto assunto) {
        return null;
    }

    @Override
    public Assunto buscarAssuntoPorId(long id) {
        return null;
    }
    
}
