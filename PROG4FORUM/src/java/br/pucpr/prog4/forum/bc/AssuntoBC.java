package br.pucpr.prog4.forum.bc;
import br.pucpr.prog4.forum.exception.ForumException;
import br.pucpr.prog4.forum.models.Assunto;
import java.util.List;

public class AssuntoBC implements ITesteBC<Assunto> {

    private static AssuntoBC instance = new AssuntoBC();

    public AssuntoBC() {
        
    }

    public static AssuntoBC getInstance() {
        if(instance == null) {
            instance = new AssuntoBC();
        }
        return instance;
    }

    @Override
    public Long insert(Assunto object) {
        validateForDataModification(object);
        return null;
    }

    @Override
    public boolean update(Assunto object) {
        validateForDataModification(object);
        return true;
    }

    @Override
    public boolean delete(Assunto object) {
        return true;
    }

    @Override
    public Assunto findById(Long id) {
        return null;
    }

    @Override
    public List<Assunto> findByFilter(Assunto filter) {
        return null;
    }

    @Override
    public List<Assunto> findAll() {
        return null;
    }

    @Override
    public void validateForDataModification(Assunto object) {
        if(object == null) {
            throw new ForumException("Assunto nulo.");
        }
        if(object.getAssunto().equals("")) {
            throw new ForumException("Assunto nao preenchido");
        }
    }

    @Override
    public boolean validateForFindData(Assunto object) {
        return true;
    }   
}