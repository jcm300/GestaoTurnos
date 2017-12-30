package business;

public abstract class Utilizador {

        private static int idC=0;
	private int id;
	private String email;
	private String password;
        private String nome;
        
        //constructor
        protected Utilizador(Utilizador us){
            this.id=us.getId();
            this.email=us.getEmail();
            this.password=us.getPassword();
            this.nome=us.getNome();
        }
        
        protected Utilizador(String email,String password,String nome){
            this.id=Utilizador.idC;
            Utilizador.idC ++;
            this.email=email;
            this.password=password;
            this.nome=nome;
        }
        
        protected Utilizador(){
            this.id=Utilizador.idC;
            Utilizador.idC ++;
            this.email="";
            this.password="";
            this.nome="";
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
        
        public int getId(){
            return this.id;
        }
        
        protected void setId(int nId){
            this.id=nId;
        }
        
        public String getNome(){
            return this.nome;
        }
}