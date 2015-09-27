package br.pucpr.prog4.forum.interfaces;
import br.pucpr.prog4.forum.models.Mensagem;
import java.util.List;

/**
 *
 * @author prisl
 */
public interface IMensagemDAO {
    public boolean inserirMensagem(Mensagem mensagem);
    public List<Mensagem> buscarMensagens(); 
    public List<Mensagem> buscarMensagemPorTopico(Mensagem mensagem); 
    public Mensagem buscarMensagemPorId(long id); 
}
