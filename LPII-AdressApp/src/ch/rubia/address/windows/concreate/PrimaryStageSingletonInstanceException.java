package ch.rubia.address.windows.concreate;

/**
 *
 * Esta classe representa um possível erro que pode ocorrer ao atribuir um stageInstance
 * ao PrimaryStageSingleton sem o Singleton em si possua uma instância
 * 
 * @author rubia
 */
public class PrimaryStageSingletonInstanceException extends Exception {

    public PrimaryStageSingletonInstanceException() {
        
        System.out.println("O primary stage foi definido, mas não atribuido a um singleton");
        
    }
    
}
