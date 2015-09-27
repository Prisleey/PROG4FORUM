package br.pucpr.prog4.forum.models.dao;

import br.pucpr.prog4.forum.exception.ForumException;
import br.pucpr.prog4.forum.interfaces.IAssuntoDAO;
import br.pucpr.prog4.forum.models.Assunto;
import br.pucpr.prog4.forum.models.Topico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
                + "id_user, "
                + "assunto, "
                + "autor, "
                + "dataCriacao) "
                + "VALUES (?, ?, ?, ?)";

        PreparedStatement ps;
        try {
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, assunto.getCriador().getId());
            ps.setString(2, assunto.getAssunto());
            ps.setString(3, assunto.getCriador().getNomeLogin());
            java.sql.Date dataSQL = new java.sql.Date(assunto.getDataAssunto().getTime());
            ps.setDate(4, dataSQL);
            ps.executeUpdate();

        } catch (Exception ex) {
            throw new ForumException("Ocorreu um erro ao inserir um usuario " + ex.getMessage());
        }
        return true;
    }

    @Override
    public List<Assunto> buscarAssuntos() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Assunto> assuntos = new ArrayList<Assunto>();

        try {
            String sql;
            sql = "SELECT * FROM assunto";
            ps = conexao.prepareStatement(sql);

            rs = ps.executeQuery();
            while(rs.next()){
                assuntos.add(populateObject(rs));
            }
        }catch(SQLException e){
            throw new ForumException("Problemas no sistema, por favor tente mais tarde");
        }
        return assuntos;
    }

    @Override
    public List<Topico> buscarTopicosAssunto(Assunto assunto) {
        return null;
    }

    @Override
    public Assunto buscarAssuntoPorId(long id) {
        return null;
    }

    private Assunto populateObject(ResultSet rs) throws SQLException {
        Assunto assunto;
        assunto = new Assunto(rs.getString("assunto"), JdbcDaoManager.getInstance().getUsuarioDAO().getUsuarioPorId(rs.getLong("id")), rs.getDate("dataCriacao"));
        /*assunto.setId(rs.getLong("id"));
        return assunto;*/
    
        /*assunto = new Assunto(rs.getString("nome"), 
                rs.getDate("dataCriacao"),  
                JdbcDaoManager.getInstance().getUsuarioDAO().getUsuarioPorId(rs.getLong("id"))); */
        assunto.setId(rs.getLong("id")); 
        /*assunto.setUltimaPostagem(rs.getDate("ultimaPostagem")); 
        assunto.setUltimoPost(JdbcDaoManager.getInstance().getUsuarioDAO().getUsuarioPorId(rs.getLong("ultimoPost"))); 
         */
        return assunto; 

    }
    
}
