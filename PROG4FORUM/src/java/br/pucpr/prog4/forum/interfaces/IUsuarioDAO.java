package br.pucpr.prog4.forum.interfaces;
import br.pucpr.prog4.forum.models.Usuario;
import java.util.List;

public interface IUsuarioDAO {
    public boolean inserirUsuario(Usuario pessoa);
    public List<Usuario> getTodosUsuarios(); 
    public Usuario getUsuarioPorId(long id); 
    public Usuario getUsuarioLogin(String email, String senha);

}
