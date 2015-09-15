package br.pucpr.prog4.forum.models;

public class Topico {

    private Assunto assunto;
    private String topico;

    public Topico() {
        
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