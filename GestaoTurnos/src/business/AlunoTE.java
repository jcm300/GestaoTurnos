package business;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class AlunoTE extends Aluno {

	protected AlunoTE(){
            super(new ArrayDeque<Troca>(),new HashMap<Integer,Integer>());
        }
        
        protected AlunoTE(String email,String password,ArrayDeque<Troca> tp, Map<Integer,Integer> t){
            super(email,password,tp,t);
        }
        
        public void trocarTurnoTE(int idUC, int idTurno) {
            this.mudaTurno(idUC,idTurno);
	}
}