package br.pucpr.prog4.forum.models.dao;

import br.pucpr.prog4.forum.interfaces.IAssuntoDAO;
import br.pucpr.prog4.forum.interfaces.IDaoManager;
import br.pucpr.prog4.forum.models.Assunto;
import br.pucpr.prog4.forum.models.Topico;
import java.util.List;

public class AssuntoDAOImpl implements IAssuntoDAO {

    @Override
    public Assunto inserirAssunto(Assunto assunto) {
        IDaoManager iManager = new JdbcDaoManager();
        IAssuntoDAO iAssuntoDAO;
        try {
            iManager.iniciar();
            iAssuntoDAO = iManager.getAssuntoDAO();
            Assunto subject = iAssuntoDAO.inserirAssunto(assunto);
            iManager.confirmarTransação();
            iManager.encerrar();
            return assunto;
        }catch (Exception e) {
            throw e;
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
            iManager.encerrar();
            return assuntos;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Topico> buscarTopicosAssunto(Assunto assunto) {
        IDaoManager iManager = new JdbcDaoManager();
        IAssuntoDAO iAssuntoDAO;
        try {
            iManager.iniciar();
            iAssuntoDAO = iManager.getAssuntoDAO();
            List<Topico> topicos = null;
            //topicos = iAssuntoDAO.buscarTopicosAssunto();
            iManager.confirmarTransação();
            iManager.encerrar();
            return topicos;
        } catch (Exception e) {
            throw e;
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
            iManager.encerrar();
            return assunto;
        } catch (Exception e) {
            throw e;
        }
    }   
}