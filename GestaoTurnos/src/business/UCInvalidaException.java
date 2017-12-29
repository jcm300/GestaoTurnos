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
public class UCInvalidaException extends Exception {
    
    public UCInvalidaException(){
        super();
    }
    
    public UCInvalidaException(String message){
        super(message);
    }
    
}
