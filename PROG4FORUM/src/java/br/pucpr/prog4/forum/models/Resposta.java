package br.pucpr.prog4.forum.models;

public class Resposta {

    private Long id;
    private String resposta;

    public Resposta() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
}
