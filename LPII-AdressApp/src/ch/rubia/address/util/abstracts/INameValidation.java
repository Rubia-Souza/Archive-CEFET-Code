package ch.rubia.address.util.abstracts;

/**
 * Esta interface originou-se devido ao método de validação dos inputs de 
 * PersonEditDialogController. Ela foi separada para que ela estabeleça um 
 * contrato em relação a forma de validação de nomes.
 * 
 * Ela atende aos princípios: SRP, OCP, ISP, DIP
 * 
 * @author rubia
 */
public interface INameValidation {
    
    public boolean isFisrtNameValid(String firstName);
    public boolean isLastNameValid(String lastName);
    
}
