package business;

public class TurnoInexistenteException extends Exception {
    
    public TurnoInexistenteException(){
        super();
    }
    
    public TurnoInexistenteException(String message){
        super(message);
    }
    
}