package br.pucpr.prog4.forum.models.dao;

import br.pucpr.prog4.forum.interfaces.IAssuntoDAO;
import br.pucpr.prog4.forum.models.Assunto;
import br.pucpr.prog4.forum.models.Topico;
import java.util.List;

public class JdbcAssuntoDAO implements IAssuntoDAO {

    @Override
    public boolean inserirAssunto(Assunto assunto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Assunto> buscarAssuntos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Topico> buscarTopicosAssunto(Assunto assunto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Assunto buscarAssuntoPorId(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
