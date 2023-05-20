package ch.rubia.persistence.BO.abstracts;

import ch.rubia.address.model.concreate.Person;
import ch.rubia.persistence.exceptions.InvalidDataInserted;
import java.time.LocalDate;

/**
 *
 * @author Aluno
 */
public interface IPersonBO extends IBO<Person> {

    public Person getPerson(int personId);
    
    public Person remove(int personId);
    public Person update(int personId, Person newPersonData) throws InvalidDataInserted;
    public boolean isRegistered(int personId);
    
    public String getPersonFirstName(int personId);
    public String getPersonLastName(int personId);
    public LocalDate getPersonBirthdate(int personId);
    
}
