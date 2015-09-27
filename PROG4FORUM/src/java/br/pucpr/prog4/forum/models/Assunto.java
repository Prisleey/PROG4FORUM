package br.pucpr.prog4.forum.models;
import java.util.Date;
import java.util.List;

public class Assunto {

    private Long id;
    private Date dataAssunto;
    private List<Topico> topicos;
    private Usuario criador;
    private String assunto;

    public Assunto(String assunto, Usuario criador, Date data) {
        this.assunto = assunto;
        this.criador = criador;
        this.dataAssunto = data;
    }

    public Assunto(List<Topico> topicos, String assunto) {
        
    }

    public Date getDataAssunto() {
        return dataAssunto;
    }

    public void setDataAssunto(Date dataAssunto) {
        this.dataAssunto = dataAssunto;
    }

    public Usuario getCriador() {
        return criador;
    }

    public void setCriador(Usuario criador) {
        this.criador = criador;
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