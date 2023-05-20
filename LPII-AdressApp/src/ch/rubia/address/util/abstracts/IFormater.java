package ch.rubia.address.util.abstracts;

/**
 * IFormater é uma interface para padronizar a assinatura da forma de formatar
 * alguma coisa em String. [Criada devido ao antigo DateUtil]
 * 
 * Segue os princípios SRP, OCP, DIP
 * 
 * @author rubia
 * @param <T> Tipo do objeto que deverá ser formatado em uma string
 */
public interface IFormater<T> {
    
    public String format(T object);
    
}
