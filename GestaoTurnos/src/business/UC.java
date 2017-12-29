    package business;

import business.Coordenador;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class UC {

	private List<TrocaInteressado> trocasPedidas;
	private List<TrocaInteressado> trocasInteressados;
	private List<Turno> turnos;
	private int id;
	private Coordenador coordenador;
	private int anoDeCurso;
	private String nome;
        
        protected List<Turno> getTurnos(){
            List<Turno> resp = new ArrayList<Turno>();
            for (Turno t : this.turnos)
                resp.add(t.clone());
            return resp;
        }

	protected void addInteresseDeTroca(TrocaInteressado troca) {
	}

	protected List<TrocaInteressado> getTrocasPedidas() {
	}

	protected void registaPresencas(int idTurno, Date data, Map<Integer, Boolean> alunos) {
	}

	protected TrocaInteressado getTrocaPedida(int idTroca) {
	}

	protected Turno getTurno(int idTurno) {
	}

	protected List<TrocaInteressado> getTrocasInteressados() {
	}
}