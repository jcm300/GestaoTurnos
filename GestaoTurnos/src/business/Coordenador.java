package business;

import java.util.List;
import java.util.ArrayList;

public class Coordenador extends Docente {

	private int ucRegente;
        
        protected int getUCRegente(){
            return this.ucRegente;
        }

	public List<TrocaInteressado> consultarTrocasPend() {
            int idUCReg = getUCRegente();
            UC uc = SysFacade.getUC(idUCReg);
            ArrayList<TrocaInteressado> trocas = null;
            if(uc!=null) uc.getTrocasPedidas();
            return trocas;
        }

	public void aprovarTroca(int idTroca) {
	}

	public void reprovarTroca(int idTroca) {
            int idUCReg = this.getUCRegente();
            UC uc = SysFacade.getUC(idUCReg);
            uc.getTrocaPedida(idTroca);
	}

	protected List<Integer> getTurnosUC() {
            int idUC = this.getUCRegente();
            UC uc = SysFacade.getUC(idUC);
            List<Turno> listaTurnos = uc.getTurnos();
            List<Integer> turnos = new ArrayList<Integer>();
            int id;
            for (Turno t : listaTurnos){
                id = t.getId();
                turnos.add(id);
            }
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