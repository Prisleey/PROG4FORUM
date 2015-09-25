package br.pucpr.prog4.forum.models;

import java.util.List;

public class Usuario {

    private Long id;
    private String nomeUser;
    private String nomeLogin;
    private String email;
    private String senha;
    private List<Topico> topicos;
    private List<Mensagem> mensagens;

    public Usuario(String nomeLogin, String email) {
        this.nomeLogin = nomeLogin;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Topico> getTopicos() {
        return topicos;
    }

    public void setTopicos(List<Topico> topicos) {
        this.topicos = topicos;
    }

    public String getNomeUser() {
        return nomeUser;
    }

    public void setNomeUser(String nomeUser) {
        this.nomeUser = nomeUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getNomeLogin() {
        return nomeLogin;
    }

    public void setNomeLogin(String login) {
        this.nomeLogin = login;
    }

    public List<Mensagem> getMensagens() {
        return mensagens;
    }

    public void setMensagens(List<Mensagem> mensagens) {
        this.mensagens = mensagens;
    }
}