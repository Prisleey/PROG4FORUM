package br.pucpr.prog4.forum.interfaces;
import br.pucpr.prog4.forum.models.Assunto;
import br.pucpr.prog4.forum.models.Topico;
import java.util.List;

public interface ITopicoDAO {
    public Topico inserirTopico(Topico topico);
    public List<Topico> buscarTopicos(); 
    public List<Topico> buscarTopicosPorAssunto(Assunto assunto); 
    public Topico buscarTopicoPorId(long id); 
}