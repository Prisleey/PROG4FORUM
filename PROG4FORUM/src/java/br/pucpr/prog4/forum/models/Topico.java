package br.pucpr.prog4.forum.models;

import java.util.List;

public class Topico {

    private Assunto assunto;
    private String topico;
    private List<Resposta> respostas;

    public Topico() {
        
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Resposta> respostas) {
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