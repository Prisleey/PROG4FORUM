package br.pucpr.prog4.forum.models.dao;

public class DaoException extends RuntimeException{

    public DaoException(String mensagem) 
    {
        super(mensagem);
    }
}