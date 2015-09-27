package br.pucpr.prog4.forum.models;
import java.util.Date;
import java.util.List;

public class Assunto {

    private Long id;
    private Date dataAssunto;
    private List<Topico> topicos;
    private Usuario autor;
    private String assunto;

    public Assunto(String assunto, Usuario autor, Date data) {
        this.assunto = assunto;
        this.autor = autor;
        this.dataAssunto = data;
    }

    public Date getDataAssunto() {
        return dataAssunto;
    }

    public void setDataAssunto(Date dataAssunto) {
        this.dataAssunto = dataAssunto;
    }

    public Usuario getCriador() {
        return autor;
    }

    public void setCriador(Usuario autor) {
        this.autor = autor;
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