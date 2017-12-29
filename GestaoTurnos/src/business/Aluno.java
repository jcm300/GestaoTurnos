package business;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;

public class Aluno extends Utilizador {

	private ArrayDeque<Troca> TrocasPendentes;
	private Map<Integer,Integer> turnos;
        
        protected Map<Integer,Integer> getTurnos(){
            Map<Integer,Integer> resp = new HashMap<Integer,Integer>();
            for (Integer uc : this.turnos){
                resp.put(uc,this.turnos.get(uc));
            }
            return resp;
        }

	protected Troca getTrocaPend() {
	}

	 void recusaTroca(String motivoTroca) {
	}

	protected void aceitaTroca() {
	}

	protected Float percentagemPresencas(int idUC) {
	}

	protected Map<Integer, Integer> consultarUCs() {
            Map<Integer,Integer> ucs = this.getTurnos();
            return ucs;
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

	protected Troca pedirTroca(int idUC, int idTurno) {
	}

	protected boolean alunoInscritoNaUC(int idUC) {
	}

	protected boolean existeTurnos() {
            Collection<Integer> values = this.turnos.values();
            boolean turnosDisp = false;
            for (Integet t : values && !turnosDips){
                if (t!=-1) turnosDisp = true;
            }
            return turnosDisp;
	}

	protected void mudaTurno(int idUC, int idTurno) {
	}
}