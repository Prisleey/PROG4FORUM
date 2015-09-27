package br.pucpr.prog4.forum.models;

import java.util.Date;

public class Mensagem {

    private Long id;
    private Date dataMsg;
    private Topico topico;
    private String mensagem;
    private Usuario usuario;

    public Mensagem() {}

    public Date getDataMsg() {
        return dataMsg;
    }

    public void setDataMsg(Date dataMsg) {
        this.dataMsg = dataMsg;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Topico getTopico() {
        return topico;
    }

    public void setTopico(Topico topico) {
        this.topico = topico;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResposta() {
        return mensagem;
    }

    public void setResposta(String resposta) {
        this.mensagem = resposta;
    }
}
