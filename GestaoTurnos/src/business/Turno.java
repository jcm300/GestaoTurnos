package business;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Turno {

	private List<Aula> aulas;
	private int id;
	private int capacidade;
	private int capacidadeSala;
	private int diaDaSemana;
	private Date horaInicio;
	private Date horaFim;
        
        protected Turno(List<Aula> aulas, int id, int capacidade, int capacidadeSala, int diaDaSemana, Date HoraInicio, Date horaFim){
            this.aulas = new ArrayList<Aula>();
            for (Aula a : aulas){
                this.aulas.add(a.clone());
            }
            this.id = id;
            this.capacidade = capacidade;
            this.capacidadeSala = capacidadeSala;
            this.diaDaSemana = diaDaSemana;
            this.horaInicio = horaInicio;
            this.horaFim = horaFim;
        }
        
        public Turno clone(){
            return new Turno(this.aulas,this.id,this.capacidade,this.capacidadeSala,this.diaDaSemana,this.horaInicio,this.horaFim);
        }
        
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