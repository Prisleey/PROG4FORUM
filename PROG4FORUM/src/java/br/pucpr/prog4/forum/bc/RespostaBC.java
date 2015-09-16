package br.pucpr.prog4.forum.bc;

import br.pucpr.prog4.forum.exception.ForumException;
import br.pucpr.prog4.forum.models.Resposta;
import java.util.List;

public class RespostaBC implements ITesteBC<Resposta> {

    private static RespostaBC instance = new RespostaBC();

    public RespostaBC() {
        
    }

    public static RespostaBC getInstance() {
        if(instance == null) {
            instance = new RespostaBC();
        }
        return instance;
    }

    @Override
    public Long insert(Resposta object) {
        validateForDataModification(object);
        return null;
    }

    @Override
    public boolean update(Resposta object) {
        validateForDataModification(object);
        return true;
    }

    @Override
    public boolean delete(Resposta object) {
        return true;
    }

    @Override
    public Resposta findById(Long id) {
        return null;
    }

    @Override
    public List<Resposta> findByFilter(Resposta filter) {
        return null;
    }

    @Override
    public List<Resposta> findAll() {
        return null;
    }

    @Override
    public void validateForDataModification(Resposta object) {
        if(object == null) {
            throw new ForumException("Resposta nula.");
        }
        if(object.getResposta().equals("")) {
            throw new ForumException("Resposta nao preenchida.");
        }
    }

    @Override
    public boolean validateForFindData(Resposta object) {
        return true;
    }   
}