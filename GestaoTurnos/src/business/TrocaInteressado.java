package business;

public class TrocaInteressado {

        private static int idC=0;
	private int id;
	private int idAluno;
	private int idTurno;
	private int idTurnoPretendido;

        protected TrocaInteressado(int idAluno, int idTurno, int idTurnoPretendido){
            this.id = TrocaInteressado.idC;
            TrocaInteressado.idC ++;
            this.idAluno = idAluno;
            this.idTurno = idTurno;
            this.idTurnoPretendido = idTurnoPretendido;
        }
        
        private void setId(int nId){
            this.id=nId;
        }
        
	public int getId() {
		return this.id;
	}
        
        protected TrocaInteressado clone(){
            TrocaInteressado aux = new TrocaInteressado(this.idAluno,this.idTurno,this.idTurnoPretendido);
            aux.setId(this.id);
            return aux;
        }
}