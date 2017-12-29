package business;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;

public class Aluno extends Utilizador {

	private ArrayDeque<Troca> trocasPendentes;
	private Map<Integer,Integer> turnos;
        
        protected Map<Integer,Integer> getTurnos(){
            Map<Integer,Integer> resp = new HashMap<Integer,Integer>();
            for (Integer uc : this.turnos){
                resp.put(uc,this.turnos.get(uc));
            }
            return resp;
        }

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
            Troca troca = this.trocasPendentes.getLast();
            return troca;
	}

	public void recusaTroca(String motivoTroca) {
            this.trocasPendentes.removeLast();
        }

	public void aceitaTroca() {
            Troca troca = this.trocasPendentes.pollLast();
            if(troca!=null){
                int idUC = troca.getIdUC();
                int idT1 = troca.getIdTurno1();
                this.mudaTurno(idUC, idT1);
                int idAluno=troca.getIdAluno1();
                Aluno al = SysFacade.getAluno(idAluno);
                int idT2 = troca.getIdTurno2();
                al.mudaTurno(idUC, idT2);
            }
	}

	public Float percentagemPresencas(int idUC) {
            UC uc = SysFacade.getUC(idUC);
            List<Turno> turnos = uc.getTurnos();
            int pres = 0;
            int idAluno = super.getId();
                    
            for(Integer idT: this.turnos.values()){
                Turno t = uc.getTurno(idT);
                List<Aula> aulas = t.getAulas();
                for(Aula a:aulas){
                    Map<Integer,Boolean> presencas = a.getPresencas();
                    boolean b = presencas.get(idAluno);
                    if(b) pres++;
                }
            }
            
            int idTurno = this.turnos.get(idUC);
            Turno turno = uc.getTurno(idTurno);
            List<Aula> aulasT = turno.getAulas();
            int n = aulasT.size();
            float ret=pres/n;
            return ret;
        }

	protected Map<Integer, Integer> consultarUCs() {
            Map<Integer,Integer> ucs = this.getTurnos();
            return ucs;
	}

	protected boolean inscreveUC(int idUC) {
            if(SysFacade.existeUC(idUC) && !this.turnos.containsKey(idUC)){
                this.turnos.put(idUC,-1);
                return true;
            }
            return false;
	}

	protected void trocarTurnoProf(int idUC, int idTurno) {
            if(SysFacade.existeUC(idUC)){
                UC aux=SysFacade.getUC(idUC);
                TrocaInteressado tI = new TrocaInteressado(0,this.id,this.turnos.get(idUC).intValue(),idTurno);
                aux.addInteresseDeTroca(tI);
            }
	}

	protected int possibilidaTrocaTurno(int idUC, int idTurno, int idAluno) {
	}

	protected Troca trocaTurnoAluno(int idUC, int idTurno, int idAluno) {
	}

	protected List<TrocaInteressado> consultarTrocasPedidas(int idUC) {
	}

	protected Troca pedirTroca(int idUC, int idTurnoD) {
            Integer idDoaluno= getId();
            Integer idDoTurno= turnos.get(idUC);
            if (idDoTurno==null) return null;
            Troca troca= new TrocaInteressado(-1,idDoaluno,idDoTurno,idTurnoD );
            return troca;
            
            
        }

	protected boolean alunoInscritoNaUC(int idUC) {
	}

	protected boolean existeTurnos() {
            Collection<Integer> values = this.turnos.values();
            boolean turnosDisp = false;
            for (Integer t : values && !turnosDips){
                if (t!=-1) turnosDisp = true;
            }
            return turnosDisp;
	}

	protected void mudaTurno(int idUC, int idTurno) {
            this.turnos.remove(idUC);
            this.turnos.put(idUC, idTurno);
	}
}