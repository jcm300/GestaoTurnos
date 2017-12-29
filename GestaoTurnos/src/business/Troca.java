package business;

public class Troca {

	private int id;
	private int idUC;
	private int idAluno1;
	private int idAluno2;
	private int idTurno1;
	private int idTurno2;
        
        protected Troca(int i, int iuc, int ialuno1, int ialuno2, int iturno1, int iturno2){
            this.id = i;
            this.idUC = iuc;
            this.idAluno1 = ialuno1;
            this.idAluno2 = ialuno2;
            this.idTurno1 = iturno1;
            this.idTurno2 = iturno2;
        }
        
        protected Troca clone(){
            return new Troca(this.id,this.idUC,this.idAluno1,this.idAluno2,this.idTurno1,this.idTurno2);
        }
}