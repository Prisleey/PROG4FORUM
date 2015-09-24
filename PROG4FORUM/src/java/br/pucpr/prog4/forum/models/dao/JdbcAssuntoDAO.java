package br.pucpr.prog4.forum.models.dao;

import br.pucpr.prog4.forum.interfaces.IAssuntoDAO;
import br.pucpr.prog4.forum.models.Assunto;
import br.pucpr.prog4.forum.models.Topico;
import java.util.List;

public class JdbcAssuntoDAO implements IAssuntoDAO {

    @Override
    public boolean inserirAssunto(Assunto assunto) {
        return true;
    }

    @Override
    public List<Assunto> buscarAssuntos() {
        return null;
    }

    @Override
    public List<Topico> buscarTopicosAssunto(Assunto assunto) {
        return null;
    }

    @Override
    public Assunto buscarAssuntoPorId(long id) {
        return null;
    }
    
}
