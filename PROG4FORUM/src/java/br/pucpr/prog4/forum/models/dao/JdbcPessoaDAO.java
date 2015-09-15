/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucpr.prog4.forum.models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author prisley.costa
 */
public class JdbcPessoaDAO implements IPessoaDAO{

    private Connection conexao;
    
    public void setConexão(Connection conexao) {
        this.conexao = conexao;
    }
    
    @Override
    public Cliente inserir(Cliente cliente) {
        String sql;
        sql = "INSERT INTO pessoa("
                + "nome,"
                + "cpf,"
                + "sexo,"
                + "tipoPessoa"
                + " VALUES (?, ?, ?, ?)";

        PreparedStatement ps;
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setString(3, cliente.getSexo());
            ps.setString(4, cliente.getTipoPessoa());
            ps.executeQuery();
            return cliente;
            
        } catch (Exception ex) {
            throw new DaoException("Ocorreu um erro ao inserir um cliente " + ex.getMessage());
        }

    }
    
}
