package business;

public class TrocaInteressado {

    private static int idC=0;
    private int id;
    private int idAluno;
    private int idTurno;
    private int idTurnoPretendido;

    protected TrocaInteressado(TrocaInteressado oldTI){
        this.id=oldTI.getId();
        this.idAluno=oldTI.getIdAluno();
        this.idTurno=oldTI.getIdTurno();
        this.idTurnoPretendido=oldTI.getTurnoPretendido();
    }
    protected TrocaInteressado(int idAluno, int idTurno, int idTurnoPretendido){
        this.id = TrocaInteressado.idC;
        TrocaInteressado.idC ++;
        this.idAluno = idAluno;
        this.idTurno = idTurno;
        this.idTurnoPretendido = idTurnoPretendido;
    }

    //getters & setters
    protected void setId(int nId){
        this.id=nId;
    }

    public int getId() {
            return this.id;
    }

    public int getIdAluno(){
        return this.idAluno;
    }
    
    public int getIdTurno(){
        return this.idTurno;
    }

    public int getTurnoPretendido(){
        return this.idTurnoPretendido;
    }

    protected TrocaInteressado clone(){
        return new TrocaInteressado(this);
    }
}