    package business;

import business.Coordenador;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class UC {

	private List<TrocaInteressado> trocasPedidas;
	private List<TrocaInteressado> trocasInteressados;
	private List<Turno> turnos;
	private int id;
	private Coordenador coordenador;
	private int anoDeCurso;
	private String nome;

	protected void addInteresseDeTroca(TrocaInteressado troca) {
	}

	protected List<TrocaInteressado> getTrocasPedidas() {
	}

	protected void registaPresencas(int idTurno, Date data, Map<Integer, Boolean> alunos) {
            Turno t = getTurno(idTurno);
            Aula novaAula = new Aula(alunos,data);
            t.getAulas().add(novaAula); // erro DS
        }

	protected TrocaInteressado getTrocaPedida(int idTroca) {
	
        }

	protected Turno getTurno(int idTurno) {
	}

	protected List<TrocaInteressado> getTrocasInteressados() {
	}
}