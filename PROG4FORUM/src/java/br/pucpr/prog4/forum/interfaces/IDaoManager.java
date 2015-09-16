package br.pucpr.prog4.forum.interfaces;

import br.pucpr.prog4.forum.exception.ForumException;

public interface IDaoManager {
    void iniciar() throws ForumException;
    void encerrar();
    void confirmarTransação();
    void abortarTransação();
    //IPessoaDAO getPessoaDAO();
}
