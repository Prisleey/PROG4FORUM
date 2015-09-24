package br.pucpr.prog4.forum.interfaces;

import br.pucpr.prog4.forum.models.Assunto;
import br.pucpr.prog4.forum.models.Topico;
import java.util.List;

public interface IAssuntoDAO {
    public Assunto inserirAssunto(Assunto assunto);
    public List<Assunto> buscarAssuntos();
    public List<Topico> buscarTopicosAssunto(Assunto assunto); 
    public Assunto buscarAssuntoPorId(long id); 

}