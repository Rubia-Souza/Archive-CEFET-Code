package ch.rubia.persistence.DAO.abstracts;

import ch.rubia.address.model.concreate.PersonAddressNMRelationship;
import java.util.List;

/**
 *
 * @author Aluno
 */
public interface IPersonAddressNMRelationshipDAO extends IDAO<PersonAddressNMRelationship> {
    
    public PersonAddressNMRelationship getRelationship(int postalCode, int personId);
    public List<Integer> getAllPersonsInAddress(int postalcode);
    public List<Integer> getAllAddressOfPerson(int personId);
    public PersonAddressNMRelationship update(int postalCode, int personId, PersonAddressNMRelationship newRelationshipData);
    public boolean isRegistered(int postalCode, int personId);
    
    public String getAddressType(PersonAddressNMRelationship relationship);
    
}
