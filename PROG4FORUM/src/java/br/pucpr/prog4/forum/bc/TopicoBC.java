package br.pucpr.prog4.forum.bc;

import br.pucpr.prog4.forum.exception.ForumException;
import br.pucpr.prog4.forum.models.Topico;
import java.util.List;

public class TopicoBC implements ITesteBC<Topico> {

    private static TopicoBC instance = new TopicoBC();

    public TopicoBC() {
        
    }

    public static TopicoBC getInstance() {
        if(instance == null) {
            instance = new TopicoBC();
        }
        return instance;
    }

    @Override
    public Long insert(Topico object) {
        validateForDataModification(object);
        return null;
    }

    @Override
    public boolean update(Topico object) {
        validateForDataModification(object);
        return true;
    }

    @Override
    public boolean delete(Topico object) {
        return true;
    }

    @Override
    public Topico findById(Long id) {
        return null;
    }

    @Override
    public List<Topico> findByFilter(Topico filter) {
        return null;
    }

    @Override
    public List<Topico> findAll() {
        return null;
    }

    @Override
    public void validateForDataModification(Topico object) {
        if(object == null) {
            throw new ForumException("Topico nulo.");
        }
        if(object.getTopico().equals("")) {
            throw new ForumException("Topico nao preenchido");
        }
    }

    @Override
    public boolean validateForFindData(Topico object) {
        return true;
    }   
}