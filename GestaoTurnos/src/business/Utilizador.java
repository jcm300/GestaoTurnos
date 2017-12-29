package business;

public abstract class Utilizador {

	private int id;
	private String email;
	private String password;
        
        protected String getEmail(){
            return this.email;
        }
        
        protected String getPassword(){
            return this.password;
        }
}