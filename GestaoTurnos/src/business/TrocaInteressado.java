package business;

public class TrocaInteressado {

	private int id;
	private int idAluno;
	private int idTurno;
	private int idTurnoPretendido;

        protected TrocaInteressado(int id,int idAluno, int idTurno, int idTurnoPretendido){
            this.id = id;
            this.idAluno = idAluno;
            this.idTurno = idTurno;
            this.idTurnoPretendido = idTurnoPretendido;
        }
        
	public int getId() {
		return this.id;
	}
        
        protected int getIdAluno(){
            return this.idAluno;
        }
        
        protected int getTurnoPretendido(){
            return this.idTurnoPretendido;
        }
        
        protected TrocaInteressado clone(){
            return new TrocaInteressado(this.id,this.idAluno,this.idTurno,this.idTurnoPretendido);
        }
}