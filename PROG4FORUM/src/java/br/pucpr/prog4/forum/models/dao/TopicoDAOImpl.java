package br.pucpr.prog4.forum.models.dao;

import br.pucpr.prog4.forum.interfaces.IDaoManager;
import br.pucpr.prog4.forum.interfaces.ITopicoDAO;
import br.pucpr.prog4.forum.models.Assunto;
import br.pucpr.prog4.forum.models.Topico;
import java.util.List;

public class TopicoDAOImpl implements ITopicoDAO {

    @Override
    public boolean inserirTopico(Topico topico) {
        IDaoManager iManager = new JdbcDaoManager();
        ITopicoDAO iTopicoDAO = iManager.getTopicoDAO();
        try {
            iManager.iniciar();
            iTopicoDAO = iManager.getTopicoDAO();
            iTopicoDAO.inserirTopico(topico);
            iManager.confirmarTransação();
            return true;
        }catch(Exception e){
            iManager.abortarTransação();
            throw e;
        }finally{
            iManager.encerrar();
        }
        
    }

    @Override
    public List<Topico> buscarTopicos() {
        IDaoManager iManager = new JdbcDaoManager();
        ITopicoDAO iTopicoDAO;
        List<Topico> topicos;
        try {
            iManager.iniciar();
            iTopicoDAO = iManager.getTopicoDAO();
            topicos = iTopicoDAO.buscarTopicos();
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
    public List<Topico> buscarTopicosPorAssunto(Assunto assunto) {
        IDaoManager iManager = new JdbcDaoManager();
        ITopicoDAO iTopicoDAO;
        List<Topico> topicos;
        try {
            iManager.iniciar();
            iTopicoDAO = iManager.getTopicoDAO();
            topicos = iTopicoDAO.buscarTopicosPorAssunto(assunto);
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
    public Topico buscarTopicoPorId(long id) {
        IDaoManager iManager = new JdbcDaoManager();
        ITopicoDAO iTopicoDAO;
        Topico topico;
        try {
            iManager.iniciar();
            iTopicoDAO = iManager.getTopicoDAO();
            topico = iTopicoDAO.buscarTopicoPorId(id);
            iManager.confirmarTransação();
            return topico;
        } catch (Exception e) {
            iManager.abortarTransação();
            throw e;
        } finally {
            iManager.encerrar();
        }
    }   
}