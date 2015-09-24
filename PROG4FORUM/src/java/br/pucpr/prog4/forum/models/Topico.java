package br.pucpr.prog4.forum.models;

import java.util.List;

public class Topico {

    private Long id;
    private Assunto assunto;
    private String topico;
    private List<Mensagem> respostas;

    public Topico() {
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Mensagem> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Mensagem> respostas) {
        this.respostas = respostas;
    }

    public Assunto getAssunto() {
        return assunto;
    }

    public void setAssunto(Assunto assunto) {
        this.assunto = assunto;
    }

    public String getTopico() {
        return topico;
    }

    public void setTopico(String topico) {
        this.topico = topico;
    }
}