package br.pucpr.prog4.forum.models.dao;

import br.pucpr.prog4.forum.interfaces.IAssuntoDAO;
import br.pucpr.prog4.forum.interfaces.IDaoManager;
import br.pucpr.prog4.forum.models.Assunto;
import br.pucpr.prog4.forum.models.Topico;
import java.util.List;

public class AssuntoDAOImpl implements IAssuntoDAO {

    @Override
    public boolean inserirAssunto(Assunto assunto) {
        IDaoManager iManager = new JdbcDaoManager();
        IAssuntoDAO iAssuntoDAO;
        try {
            iManager.iniciar();
            iAssuntoDAO = iManager.getAssuntoDAO();
            iAssuntoDAO.inserirAssunto(assunto);
            iManager.confirmarTransação();
            return true;
        }catch (Exception e) {
            iManager.abortarTransação();
            throw e;
        } finally {
            iManager.encerrar();
        }
    }

    @Override
    public List<Assunto> buscarAssuntos() {
        IDaoManager iManager = new JdbcDaoManager();
        IAssuntoDAO iAssuntoDAO;
        try {
            iManager.iniciar();
            iAssuntoDAO = iManager.getAssuntoDAO();
            List<Assunto> assuntos = iAssuntoDAO.buscarAssuntos();
            iManager.confirmarTransação();
            return assuntos;
        } catch (Exception e) {
            iManager.abortarTransação();
            throw e;
        } finally {
            iManager.encerrar();
        }
    }

    @Override
    public List<Topico> buscarTopicosAssunto(Assunto assunto) {
        IDaoManager iManager = new JdbcDaoManager();
        IAssuntoDAO iAssuntoDAO;
        List<Topico> topicos;
        try {
            iManager.iniciar();
            iAssuntoDAO = iManager.getAssuntoDAO();
            topicos = iAssuntoDAO.buscarTopicosAssunto(assunto);
            iManager.confirmarTransação();
            return topicos;
        } catch (Exception e) {
            iManager.abortarTransação();
            throw e;
        } finally {
            iManager.encerrar();
        }
    }

    @Override
    public Assunto buscarAssuntoPorId(long id) {
        IDaoManager iManager = new JdbcDaoManager();
        IAssuntoDAO iAssuntoDAO;
        try {
            iManager.iniciar();
            iAssuntoDAO = iManager.getAssuntoDAO();
            Assunto assunto = iAssuntoDAO.buscarAssuntoPorId(id);
            iManager.confirmarTransação();
            return assunto;
        } catch (Exception e) {
            iManager.abortarTransação();
            throw e;
        } finally {
            iManager.encerrar();
        }
    }   
}