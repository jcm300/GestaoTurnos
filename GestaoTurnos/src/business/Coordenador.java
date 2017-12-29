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
	}

	protected boolean verificaSeCapExcedeSala(int idTurno, int capacidade) {
	}

	protected void defineCapacidade(int idTurno, int capacidade) {
	}

}