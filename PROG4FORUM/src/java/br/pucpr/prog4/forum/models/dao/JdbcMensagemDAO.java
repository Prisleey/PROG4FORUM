package br.pucpr.prog4.forum.models.dao;

import br.pucpr.prog4.forum.exception.ForumException;
import br.pucpr.prog4.forum.interfaces.IMensagemDAO;
import br.pucpr.prog4.forum.models.Mensagem;
import br.pucpr.prog4.forum.models.Topico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author prisl
 */
public class JdbcMensagemDAO implements IMensagemDAO {

    private Connection conexao;

    public JdbcMensagemDAO() {
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public boolean inserirMensagem(Mensagem mensagem) {
        String sql;
        sql = "INSERT INTO mensagem("
                + "mensagem, "
                + "topico,"
                + "assunto, "
                + "dataMensagem) "
                + "VALUES (?, ?, ?, ?)";

        PreparedStatement ps;
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, mensagem.getMensagem());
            ps.setString(2, mensagem.getTopico().getTopico());
            ps.setString(3, mensagem.getTopico().getAssunto().getAssunto());
            java.sql.Date dataSQL = new java.sql.Date(mensagem.getDataMsg().getTime());
            ps.setDate(4, dataSQL);
            ps.executeUpdate();

        } catch (Exception ex) {
            throw new ForumException("Ocorreu um erro ao inserir um usuario " + ex.getMessage());
        }
        return true;
    }

    @Override
    public List<Mensagem> buscarMensagens() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Mensagem buscarMensagemPorId(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Mensagem> buscarMensagensPorTopico(Topico topico) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
