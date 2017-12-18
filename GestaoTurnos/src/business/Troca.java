package business;

public class Troca {

    private static int idC=0;
    private int id;
    private int idUC;
    private int idAluno1;
    private int idAluno2;
    private int idTurno1;
    private int idTurno2;

    protected Troca(int iuc, int ialuno1, int ialuno2, int iturno1, int iturno2){
        this.id = Troca.idC;
        Troca.idC ++;
        this.idUC = iuc;
        this.idAluno1 = ialuno1;
        this.idAluno2 = ialuno2;
        this.idTurno1 = iturno1;
        this.idTurno2 = iturno2;
    }
    
    private void setId(int nId){
        this.id=nId;
    }

    protected Troca clone(){
        Troca aux = new Troca(this.idUC,this.idAluno1,this.idAluno2,this.idTurno1,this.idTurno2);
        aux.setId(this.id);
        return aux;
    }
    
    protected int getIdUC(){
        return this.idUC;
    }

    protected int getIdTurno1(){
        return this.idTurno1;
    }

    protected int getIdTurno2(){
        return this.idTurno2;
    }

    protected int getIdAluno1(){
        return this.idAluno1;
    }
}