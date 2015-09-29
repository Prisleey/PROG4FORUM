package br.pucpr.prog4.forum.interfaces;
import br.pucpr.prog4.forum.models.Mensagem;
import br.pucpr.prog4.forum.models.Topico;
import java.util.List;

/**
 *
 * @author prisl
 */
public interface IMensagemDAO {
    public boolean inserirMensagem(Mensagem mensagem);
    public List<Mensagem> buscarMensagens();
    public Mensagem buscarMensagemPorId(long id); 
    public List<Mensagem> buscarMensagensPorTopico(Topico topico);
}
