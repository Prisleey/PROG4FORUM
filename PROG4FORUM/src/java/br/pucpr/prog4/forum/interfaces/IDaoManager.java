package br.pucpr.prog4.forum.interfaces;

import br.pucpr.prog4.forum.exception.ForumException;
import java.sql.Connection;

public interface IDaoManager {
    void iniciar() throws ForumException;
    void encerrar();
    void confirmarTransação();
    void abortarTransação();
    //IPessoaDAO getPessoaDAO();
    IUsuarioDAO getUsuarioDAO();
    IAssuntoDAO getAssuntoDAO();
    ITopicoDAO getTopicoDAO();
}
