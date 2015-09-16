package br.pucpr.prog4.forum.models;
import java.util.List;

public class Assunto {

    private Long id;
    private List<Topico> topicos;
    private String assunto;

    public Assunto() {
        
    }

    public Assunto(List<Topico> topicos, String assunto) {
        
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

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }
}