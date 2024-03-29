package business;

public class Troca {

    private static int idC=0;
    private int id;
    private int idUC;
    private int idAluno1;
    private int idAluno2;
    private int idTurno1;
    private int idTurno2;

    //constructor
    protected Troca(Troca oldT){
        this.id=oldT.getId();
        this.idUC=oldT.getIdUC();
        this.idAluno1=oldT.getIdAluno1();
        this.idAluno2=oldT.getIdAluno2();
        this.idTurno1=oldT.getIdTurno1();
        this.idTurno2=oldT.getIdTurno2();
    }
    
    protected Troca(int iuc, int ialuno1, int ialuno2, int iturno1, int iturno2){
        this.id = Troca.idC;
        Troca.idC ++;
        this.idUC = iuc;
        this.idAluno1 = ialuno1;
        this.idAluno2 = ialuno2;
        this.idTurno1 = iturno1;
        this.idTurno2 = iturno2;
    }
    
    //getters & setters
    protected int getId(){
        return this.id;
    }
    
    private void setId(int nId){
        this.id=nId;
    }
    
    public int getIdUC(){
        return this.idUC;
    }

    protected int getIdTurno1(){
        return this.idTurno1;
    }

    public int getIdTurno2(){
        return this.idTurno2;
    }

    protected int getIdAluno1(){
        return this.idAluno1;
    }
    
    public int getIdAluno2(){
        return this.idAluno2;
    }

    protected Troca clone(){
        Troca aux = new Troca(this.idUC,this.idAluno1,this.idAluno2,this.idTurno1,this.idTurno2);
        aux.setId(this.id);
        return aux;
    }
}