package business;

public abstract class Utilizador {

        private static int idC=0;
	private int id;
	private String email;
	private String password;
        
        //constructor
        protected Utilizador(Utilizador us){
            this.id=us.getId();
            this.email=us.getEmail();
            this.password=us.getPassword();
        }
        
        protected Utilizador(String email,String password){
            this.id=Utilizador.idC;
            Utilizador.idC ++;
            this.email=email;
            this.password=password;
        }
        
        protected Utilizador(){
            this.id=Utilizador.idC;
            Utilizador.idC ++;
            this.email="";
            this.password="";
        }
        
        
        //getters & setters
        protected String getEmail(){
            return this.email;
        }
        
        protected void setEmail(String nEmail){
            this.email=nEmail;
        }
        
        protected String getPassword(){
            return this.password;
        }
        
        protected void setPassword(String nPassword){
            this.password=nPassword;
        }
        
        protected int getId(){
            return this.id;
        }
        
        protected void setId(int nId){
            this.id=nId;
        }
}