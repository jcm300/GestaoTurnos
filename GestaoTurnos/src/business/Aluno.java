package business;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Aluno extends Utilizador {

	private ArrayDeque<Troca> trocasPendentes;
	private Map<Integer,Integer> turnos;

        protected Aluno(ArrayDeque<Troca> tp, Map<Integer,Integer> t){
            this.trocasPendentes = new ArrayDeque<Troca>();
            this.turnos = new HashMap<Integer,Integer>();
            for(Troca tr:tp){
                this.trocasPendentes.addFirst(tr.clone());
            }
            t.putAll(this.turnos);
        }
        
        protected Aluno clone(){
            return new Aluno(this.trocasPendentes,this.turnos);
        }
        
	public Troca getTrocaPend() {
	}

	public void recusaTroca(String motivoTroca) {
	}

	public void aceitaTroca() {
	}

	public Float percentagemPresencas(int idUC) {
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

	protected Troca pedirTroca(int idUC, int idTurno) {
	}

	protected boolean alunoInscritoNaUC(int idUC) {
	}

	protected boolean existeTurnos() {
	}

	protected void mudaTurno(int idUC, int idTurno) {
            this.turnos.remove(idUC);
            this.turnos.put(idUC, idTurno);
	}
}