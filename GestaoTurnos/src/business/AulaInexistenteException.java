/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author jonasv
 */
public class AulaInexistenteException extends Exception {
    
    public AulaInexistenteException() {
        super();
    } 
    public AulaInexistenteException(String message) {
        super(message);
    } 
}
