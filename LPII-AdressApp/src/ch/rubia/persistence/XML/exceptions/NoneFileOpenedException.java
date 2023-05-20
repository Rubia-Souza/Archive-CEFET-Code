package ch.rubia.persistence.XML.exceptions;

/**
 *
 * @author rubia
 */
public class NoneFileOpenedException extends Exception {
    
    public NoneFileOpenedException() {
        
        System.out.println("Attempt to acess a file that was not opened yet\n");
        
    }
    
}
