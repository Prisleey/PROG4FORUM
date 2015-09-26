package br.pucpr.prog4.forum.models.dao;

import br.pucpr.prog4.forum.exception.ForumException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class Conexao {

    private Connection conexao;
    public static Conexao instance;

    public static Conexao getInstance(){ 
        if(instance == null){ 
            instance = new Conexao(); 
        } 
        return instance; 
    }

    public Conexao() throws ForumException {
        iniciar(); 
    }

    public void iniciar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url;
            url = "jdbc:mysql://localhost:3306/forum";
            conexao = DriverManager.getConnection(url, "root", "root");

            conexao.setAutoCommit(false);
        } catch (ClassNotFoundException e) {
            throw new ForumException("Erro conector JDBC");
        } catch(SQLException e) {
            throw new ForumException("Ocorreu um erro ao conectar ao banco de dados: " + 
                    e.getMessage());
        }
    }

    public Connection getConnection() {
        if(conexao != null) {
            return conexao;
        } else {
            iniciar();
            getConnection();
            throw new ForumException("Conexão não iniciada");
        }
    }
}