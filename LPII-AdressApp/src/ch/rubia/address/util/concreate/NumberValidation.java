package ch.rubia.address.util.concreate;

import ch.rubia.address.util.abstracts.INumberValidation;

/**
 * Esta classe é a implementação da interface INumberValidation de acordo com a
 * antiga forma feita pelo PersonEditDialogController (DIP)
 * 
 * @author rubia
 */
public class NumberValidation implements INumberValidation {

    @Override
    public boolean isNumber(String number) {
        
        try {
           Integer.parseInt(number);
        } 
        catch (NumberFormatException e) {
            return false;
        }
        
        return true;
    }
    
}
