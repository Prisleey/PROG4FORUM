/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucpr.prog4.forum.models.dao;

import br.pucpr.prog4.forum.interfaces.ITopicoDAO;
import br.pucpr.prog4.forum.exception.ForumException;
import br.pucpr.prog4.forum.models.Assunto;
import br.pucpr.prog4.forum.models.Topico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author prisl
 */
public class JdbcTopicoDAO implements ITopicoDAO{
    private Connection conexao;
    
    public void setConexão(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public Topico inserirTopico(Topico topico) {
        String sql;
        sql = "INSERT INTO topico("
                + "assunto,"
                + "topico,"
                + "resposta"
                + " VALUES (?, ?, ?)";

        PreparedStatement ps;
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, topico.getAssunto().getAssunto());
            ps.setString(2, topico.getTopico());
            ps.setString(3, topico.getRespostas().get(0).getResposta());
            ps.executeQuery();
            return topico;

        } catch (Exception ex) {
            throw new ForumException("Ocorreu um erro ao inserir um usuario " + ex.getMessage());
        }
    }

    @Override
    public List<Topico> buscarTopicos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Topico> buscarTopicosPorAssunto(Assunto assunto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Topico buscarTopicoPorId(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}