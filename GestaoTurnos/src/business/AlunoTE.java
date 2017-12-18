package business;

import java.util.ArrayDeque;
import java.util.HashMap;

public class AlunoTE extends Aluno {

	protected AlunoTE(){
            super(new ArrayDeque<Troca>(),new HashMap<Integer,Integer>());
        }
        protected void trocarTurnoTE(int idUC, int idTurno) {
            this.mudaTurno(idUC,idTurno);
	}
}