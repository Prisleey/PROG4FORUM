package br.pucpr.prog4.forum.bc;

import br.pucpr.prog4.forum.exception.ForumException;
import br.pucpr.prog4.forum.models.Usuario;
import java.util.List;

public class UsuarioBC implements ITesteBC<Usuario> {

    private static UsuarioBC instance = new UsuarioBC();

    public UsuarioBC() {
        
    }

    public static UsuarioBC getInstance() {
        if(instance == null) {
            instance = new UsuarioBC();
        }
        return instance;
    }

    @Override
    public Long insert(Usuario object) {
        validateForDataModification(object);
        return null;
    }

    @Override
    public boolean update(Usuario object) {
        validateForDataModification(object);
        return true;
    }

    @Override
    public boolean delete(Usuario object) {
        return true;
    }

    @Override
    public Usuario findById(Long id) {
        return null;
    }

    @Override
    public List<Usuario> findByFilter(Usuario filter) {
        return null;
    }

    @Override
    public List<Usuario> findAll() {
        return null;
    }

    @Override
    public void validateForDataModification(Usuario object) {
        if(object == null) {
            throw new ForumException("Usuario nulo.");
        }
        if(object.getNomeUser().equals("")) {
            throw new ForumException("Nome de usuario invalido.");
        }
        if(!object.getEmail().matches("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$")) {
            throw new ForumException("Email incorreto.");
        }
        if(object.getSenha().equals("")) {
            throw new ForumException("Senha nao foi digitada.");
        }
    }

    @Override
    public boolean validateForFindData(Usuario object) {
        return true;
    }   
}