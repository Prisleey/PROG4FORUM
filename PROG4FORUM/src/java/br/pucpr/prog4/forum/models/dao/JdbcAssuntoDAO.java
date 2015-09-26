package br.pucpr.prog4.forum.models.dao;

import br.pucpr.prog4.forum.interfaces.IAssuntoDAO;
import br.pucpr.prog4.forum.models.Assunto;
import br.pucpr.prog4.forum.models.Topico;
import java.sql.Connection;
import java.util.List;

public class JdbcAssuntoDAO implements IAssuntoDAO {

    private Connection conexao;

    public JdbcAssuntoDAO() {
        
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }
    
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
