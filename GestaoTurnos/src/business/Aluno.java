package business;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Map;

public class Aluno extends Utilizador {

	private ArrayDeque<Troca> TrocasPendentes;
	private Map<Integer,Integer> turnos;

	protected Troca getTrocaPend() {
	}

	 void recusaTroca(String motivoTroca) {
	}

	protected void aceitaTroca() {
	}

	protected Float percentagemPresencas(int idUC) {
	}

	protected Map<Integer, Integer> consultarUCs() {
	}

	protected boolean inscreveUC(int idUC) {
	}

	protected void trocarTurnoProf(int idUC, int idTurno) {
	}

	protected int possibilidaTrocaTurno(int idUC, int idTurno, int idAluno) {
	}

	protected Troca trocaTurnoAluno(int idUC, int idTurno, int idAluno) {
	}

	protected List<TrocaInteressado> consultarTrocasPedidas(int idUC) {
	}

	protected Troca pedirTroca(int idUC, int idTurnoD) {
            Integer idDoaluno= getId();
            Integer idDoTurno= turnos.get(idUC);
            if (idDoTurno==null) return null;
            Troca troca= new TrocaInteressado(-1,idDoaluno,idDoTurno,idTurnoD );
            return troca;
            
            
        }

	protected boolean alunoInscritoNaUC(int idUC) {
	}

	protected boolean existeTurnos() {
	}

	protected void mudaTurno(int idUC, int idTurno) {
	}
}