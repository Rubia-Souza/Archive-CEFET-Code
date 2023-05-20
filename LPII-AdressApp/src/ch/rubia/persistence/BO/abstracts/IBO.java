package ch.rubia.persistence.BO.abstracts;

import ch.rubia.persistence.exceptions.InvalidDataInserted;
import java.util.List;

/**
 *
 * @author Aluno
 */
public interface IBO<T> {
    
    public List<T> listAll();
    public boolean add(T data) throws InvalidDataInserted;
    public T remove(T data);
    public boolean update(T oldData, T newData) throws InvalidDataInserted;
    public boolean isRegistered(T data);
    
}
