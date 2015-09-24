package br.pucpr.prog4.forum.bc;

import br.pucpr.prog4.forum.exception.ForumException;
import br.pucpr.prog4.forum.models.Mensagem;
import java.util.List;

public class RespostaBC implements ITesteBC<Mensagem> {

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
    public Long insert(Mensagem object) {
        validateForDataModification(object);
        return null;
    }

    @Override
    public boolean update(Mensagem object) {
        validateForDataModification(object);
        return true;
    }

    @Override
    public boolean delete(Mensagem object) {
        return true;
    }

    @Override
    public Mensagem findById(Long id) {
        return null;
    }

    @Override
    public List<Mensagem> findByFilter(Mensagem filter) {
        return null;
    }

    @Override
    public List<Mensagem> findAll() {
        return null;
    }

    @Override
    public void validateForDataModification(Mensagem object) {
        if(object == null) {
            throw new ForumException("Resposta nula.");
        }
        if(object.getResposta().equals("")) {
            throw new ForumException("Resposta nao preenchida.");
        }
    }

    @Override
    public boolean validateForFindData(Mensagem object) {
        return true;
    }   
}