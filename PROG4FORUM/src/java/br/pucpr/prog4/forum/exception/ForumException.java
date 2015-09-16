package br.pucpr.prog4.forum.exception;

public class ForumException extends RuntimeException {
    public ForumException(String mensagem) {
        super(mensagem);
    }
}