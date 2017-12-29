package gestaoturnos;

public class Aluno extends Utilizador {

	private List<Troca> TrocasPendentes;
	private Map<Integer,Integer> turnos;

	public Troca getTrocaPend() {
	}

	public void recusaTroca(String motivoTroca) {
	}

	public void aceitaTroca() {
	}

	public Float percentagemPresencas(int idUC) {
	}

	public Map<Integer, Integer> consultarUCs() {
	}

	public boolean inscreveUC(int idUC) {
	}

	public void trocarTurnoProf(int idUC, int idTurno) {
	}

	public int possibilidaTrocaTurno(int idUC, int idTurno, int idAluno) {
	}

	public Troca trocaTurnoAluno(int idUC, int idTurno, int idAluno) {
	}

	public List<TrocaInteressado> consultarTrocasPedidas(int idUC) {
	}

	public Troca pedirTroca(int idUC, int idTurno) {
	}

	public boolean alunoInscritoNaUC(int idUC) {
	}

	public boolean existeTurnos() {
	}

	public void mudaTurno(int idUC, int idTurno) {
	}
}