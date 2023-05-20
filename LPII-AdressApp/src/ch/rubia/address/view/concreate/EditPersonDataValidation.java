package ch.rubia.address.view.concreate;

import ch.rubia.address.util.abstracts.IAddressValidation;
import ch.rubia.address.util.abstracts.IDateValidation;
import ch.rubia.address.util.abstracts.IFastAlert;
import ch.rubia.address.util.abstracts.INameValidation;
import ch.rubia.address.util.abstracts.INumberValidation;
import ch.rubia.address.util.concreate.AddressValidation;
import ch.rubia.address.util.concreate.BrazilDateValidation;
import ch.rubia.address.util.concreate.FastAlertWarning;
import ch.rubia.address.util.concreate.NameValidation;
import ch.rubia.address.util.concreate.NumberValidation;
import ch.rubia.address.view.PersonEditDialogController;
import ch.rubia.address.view.abstracts.IInputValidation;

/**
 * Essa classe é a implementação de IInputValidation e ela utiliza outras interfaces
 * menores para fazer a validação de uma janela com dados de entrada.
 * 
 * Ela busca atender ao: SRP, OCP, DIP
 * 
 * @author rubia
 */
public class EditPersonDataValidation implements IInputValidation{

    private PersonEditDialogController controller;
    
    public EditPersonDataValidation(PersonEditDialogController controller) {
        setController(controller);
    }
    
    @Override
    public boolean validateInputEntries() {
        
        String errorMessage = "";
        INameValidation nameValidator = new NameValidation();
        INumberValidation numberValidator = new NumberValidation();
        IAddressValidation addressValidator = new AddressValidation();
        IDateValidation brazilDateValidatior = new BrazilDateValidation();
        
        if (!nameValidator.isFisrtNameValid(controller.getFirstNameField().getText())) {
            errorMessage += "Primeiro nome inválido\n";
        }
        
        if (!nameValidator.isLastNameValid(controller.getLastNameField().getText())) {
            errorMessage += "Ultimo nome inválido\n";
        }
        
        if (!addressValidator.isStreetValid(controller.getStreetField().getText())) {
            errorMessage += "Rua inválida\n";
        }
        
        if (!addressValidator.isPostalCodeValid(controller.getPostalCodeField().getText())) {
            errorMessage += "Código postal inválido\n";
        } 
        
        else if (!numberValidator.isNumber(controller.getPostalCodeField().getText())) {
            errorMessage += "Código postal inválido (dever ser um inteiro)\n";    
        }
        
        if (!addressValidator.isCityValid(controller.getCityField().getText())) {
            errorMessage += "Cidade inválida!\n"; 
        }
        
        if (controller.getBirthdayField().getText() == null ||
                controller.getBirthdayField().getText().length() == 0) {
            
            errorMessage += "Aniversário inválido!\n";
        } 
        
        else if (!brazilDateValidatior.isDateValid(controller.getBirthdayField().getText())) {
            errorMessage += "Aniversário inválido. Use o formato dd/mm/yyyy!\n";
        }

        if (errorMessage.length() == 0){
            return true;
        }
        else {
            
            invalidInputEntrieWarning(errorMessage);
            
            return false;
            
        }
        
    }
    
    @Override
    public void invalidInputEntrieWarning(String text) {
        
            IFastAlert alert = new FastAlertWarning("Campos Inválidos",
                    "Por favor, corrija os compos inválidos", text);
            alert.openAlert();
        
    }

    private void setController(PersonEditDialogController controller) {
        this.controller = controller;
    }
    
    public PersonEditDialogController getController() {
        return controller;
    }
    
}
