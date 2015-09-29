package br.pucpr.prog4.forum.models.dao;

import br.pucpr.prog4.forum.interfaces.IDaoManager;
import br.pucpr.prog4.forum.interfaces.IMensagemDAO;
import br.pucpr.prog4.forum.models.Mensagem;
import br.pucpr.prog4.forum.models.Topico;
import java.util.List;

/**
 *
 * @author prisley.costa
 */
public class MensagemDAOImpl implements IMensagemDAO {
    
    @Override
    public boolean inserirMensagem(Mensagem mensagem) {
        IDaoManager iManager = new JdbcDaoManager();
        IMensagemDAO iMensagemDAO;
        try {
            iManager.iniciar();
            iMensagemDAO = iManager.getMensagemDAO();
            iMensagemDAO.inserirMensagem(mensagem);
            iManager.confirmarTransação();
            iManager.encerrar();            
            return true;
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public List<Mensagem> buscarMensagens() {
        IDaoManager iManager = new JdbcDaoManager();
        IMensagemDAO iMensagemDAO;
        List<Mensagem> mensagens;
        try {
            iManager.iniciar();
            iMensagemDAO = iManager.getMensagemDAO();
            mensagens = iMensagemDAO.buscarMensagens();
            
            iManager.encerrar();            
            return mensagens;
        }catch(Exception e){
            throw e;
        }
    }
    
    @Override
    public Mensagem buscarMensagemPorId(long id) {
        return null;
    }

    @Override
    public List<Mensagem> buscarMensagensPorTopico(Topico topico) {
        IDaoManager iManager = new JdbcDaoManager();
        IMensagemDAO iMensagemDAO;
        List<Mensagem> mensagens;
        try {
            iManager.iniciar();
            iMensagemDAO = iManager.getMensagemDAO();
            mensagens = iMensagemDAO.buscarMensagensPorTopico(topico);
            iManager.confirmarTransação();
            iManager.encerrar();            
            return mensagens;
        }catch(Exception e){
            throw e;
        }
    }
}