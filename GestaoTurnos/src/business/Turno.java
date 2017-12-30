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
        
        
        //constructor
        protected Turno(Turno oldT){
            this.aulas=oldT.getAulas();
            this.id=oldT.getId();
            this.capacidade=oldT.getCapacidade();
            this.capacidadeSala=oldT.getCapacidadeSala();
            this.diaDaSemana=oldT.getDiaDaSemana();
            this.horaInicio=oldT.getHoraInicio();
            this.horaFim=oldT.getHoraFim();
        }
        
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
        
        
        //getters & setters
        protected int getId(){
            return this.id;
        }
        
        protected int getCapacidade(){
            return this.capacidade;
        }
        
        protected int getCapacidadeSala(){
            return this.capacidadeSala;
        }
        
        protected void setCapacidade(int c){
            this.capacidade = c;
        }
        
        protected List<Aula> getAulas() {
            return aulas;
        }
        
        protected int getDiaDaSemana(){
            return this.diaDaSemana;
        }
        
        protected Date getHoraInicio(){
            return this.horaInicio;
        }
        
        protected Date getHoraFim(){
            return this.horaFim;
        }
        
        public Turno clone(){
            return new Turno(this);
        }

	protected boolean existeAula(Date data) {
            boolean eAula = false;
            Date d;
            for (Aula a : this.aulas){
                d = a.getData();
                if (data.equals(d)){
                    eAula = true;
                    break;
                }
            }
            return eAula;
	}

	protected Aula getAula(Date data) {
            boolean flag = false;
            Date d;
            Aula aula=null;
            for (Aula a : this.aulas){
                d = a.getData();
                if (data.equals(d)){
                    flag = true;
                    aula = a;
                    break;
                }
            }
            return aula;
	}
}