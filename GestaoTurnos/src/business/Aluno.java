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
            if(SysFacade.existeUC(idUC) && !this.turnos.containsKey(idUC)){
                this.turnos.put(idUC,-1);
                return true;
            }
            return false;
	}

	protected void trocarTurnoProf(int idUC, int idTurno) {
            if(SysFacade.existeUC(idUC)){
                UC aux=SysFacade.getUC(idUC);
                TrocaInteressado tI = new TrocaInteressado(0,this.id,this.turnos.get(idUC).intValue(),idTurno);
                aux.addInteresseDeTroca(tI);
            }
	}

	protected int possibilidaTrocaTurno(int idUC, int idTurno, int idAluno) {
	}

	protected Troca trocaTurnoAluno(int idUC, int idTurno, int idAluno) {
	}

	protected List<TrocaInteressado> consultarTrocasPedidas(int idUC) {
	}

	protected Troca pedirTroca(int idUC, int idTurno) {
	}

	protected boolean alunoInscritoNaUC(int idUC) {
	}

	protected boolean existeTurnos() {
	}

	protected void mudaTurno(int idUC, int idTurno) {
	}
}