/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucpr.prog4.forum.models.dao;

import br.pucpr.prog4.forum.exception.ForumException;
import br.pucpr.prog4.forum.models.Topico;
import java.sql.Connection;
import java.sql.PreparedStatement;

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
    public Topico inserir(Topico topico) {
        String sql;
        sql = "INSERT INTO topico("
                + "assunto,"
                + "topico,"
                + "resposta"
                + " VALUES (?, ?, ?)";
    /*private Assunto assunto;
    private String topico;
    private List<Resposta> respostas;*/
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
}