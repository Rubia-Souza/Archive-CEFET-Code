package ch.rubia.persistence.JDBC.DAO;

import ch.rubia.address.model.concreate.PersonAddressNMRelationship;
import ch.rubia.persistence.DAO.abstracts.IPersonAddressNMRelationshipDAO;
import java.util.List;

/**
 *
 * @author rubia
 */
public class PersonAddressNMRelationshipJDBCDAO implements IPersonAddressNMRelationshipDAO {

    @Override
    public PersonAddressNMRelationship getRelationship(int postalCode, int personId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Integer> getAllPersonsInAddress(int postalcode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Integer> getAllAddressOfPerson(int personId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonAddressNMRelationship update(int postalCode, int personId, PersonAddressNMRelationship newRelationshipData) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isRegistered(int postalCode, int personId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAddressType(PersonAddressNMRelationship relationship) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PersonAddressNMRelationship> listAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(PersonAddressNMRelationship data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonAddressNMRelationship remove(PersonAddressNMRelationship data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(PersonAddressNMRelationship oldData, PersonAddressNMRelationship newData) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isRegistered(PersonAddressNMRelationship data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
