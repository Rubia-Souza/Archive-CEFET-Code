package ch.rubia.address.util.abstracts;

/**
 * Esta classe se originou devido ao DateUtil, que vai contra o principio SRP
 * executando mais de uma funcionalidade.
 * 
 * Ela faz com que a forma de validar a data siga o SRP, OCP, ISP e
 * DIP.
 * 
 * @author rubia
 */
public interface IDateValidation {
   
    public boolean isDateValid(String dateString);
    
}
