package business;

import java.util.Date;
import java.util.List;

public class Turno {

	private List<Aula> aulas;
	private int id;
	private int capacidade;
	private int capacidadeSala;
	private int diaDaSemana;
	private Date horaInicio;
	private Date horaFim;
        
        protected int getId(){
            return this.id;
        }
        
        protected int getCapacidadeSala(){
            return this.capacidadeSala;
        }
        
        protected void setCapacidade(int c){
            this.capacidade = c;
        }

	protected boolean existeAula(Date data) {
	}

	protected Aula getAula(Date data) {
	}
	protected List<Aula> getAulas() {
            return aulas;
        }
}