package business;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Coordenador extends Docente {

	private int ucRegente;
        
        

        //constructor
        protected Coordenador(Coordenador cOld){
            super(cOld);
            this.ucRegente=cOld.getUCRegente();
        }
        
        protected Coordenador(String email,String password,String nome,Map<Integer,List<Integer>> turnos, int cadeira){
            super(email,password,nome,turnos);
        }
        
        protected Coordenador(int cadeira){
            super();
            this.ucRegente=cadeira;
        }
        
        //getters & setters
        protected int getUCRegente(){
            return this.ucRegente;
        }
        
        protected Coordenador clone(){
            return new Coordenador(this);
        }

	public List<TrocaInteressado> consultarTrocasPend() {
            int idUCReg = this.getUCRegente();
            UC uc = SysFacade.getUC(idUCReg);
            List<TrocaInteressado> trocas = new ArrayList<>();
            if(uc!=null) trocas=uc.getTrocasPedidas();
            return trocas;
        }

	public void aprovarTroca(int idTroca) {
            int idUCReg = this.getUCRegente();
            UC uc = SysFacade.getUC(idUCReg);
            TrocaInteressado troca = uc.getTrocaPedida(idTroca);
            int idAluno = troca.getIdAluno();
            int idT = troca.getTurnoPretendido();
            Aluno al = SysFacade.getAluno(idAluno);
            al.mudaTurno(idUCReg,idT);
	}

	public void reprovarTroca(int idTroca) {
            int idUCReg = this.getUCRegente();
            UC uc = SysFacade.getUC(idUCReg);
            uc.getTrocaPedida(idTroca);
	}

	protected List<Integer> getTurnosUC() {
            int idUC = this.ucRegente;
            UC uc = SysFacade.getUC(idUC);
            List<Turno> listaTurnos = uc.getTurnos();
            List<Integer> turnos = new ArrayList<Integer>();
            int id;
            
            for (Turno t : listaTurnos){
                id = t.getId();
                turnos.add(id);
            }
            return turnos;
	}

	protected boolean verificaSeCapExcedeSala(int idTurno, int capacidade) {
            boolean capMaxima;
            int idUC = this.getUCRegente();
            UC uc = SysFacade.getUC(idUC);
            Turno turno = uc.getTurno(idTurno);
            int capacidadeSala = turno.getCapacidadeSala();
            if (capacidadeSala > capacidade)
                capMaxima = false;
            else
                capMaxima = true;
            return capMaxima;
            
	}

	protected void defineCapacidadeTurno(int idTurno, int capacidade) {
            int idUC = this.getUCRegente();
            UC uc = SysFacade.getUC(idUC);
            Turno turno = uc.getTurno(idTurno);
            turno.setCapacidade(capacidade);
	}

}