package br.pucpr.prog4.forum.models;

public class Mensagem {

    private Long id;
    private String mensagem;
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Mensagem() {}


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
