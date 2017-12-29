    package business;

import business.Coordenador;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Iterator;

public class UC {

	private List<TrocaInteressado> trocasPedidas;
	private List<TrocaInteressado> trocasInteressados;
	private List<Turno> turnos;
	private int id;
	private Coordenador coordenador;
	private int anoDeCurso;
	private String nome;
        
        public UC(List<TrocaInteressado> trocasPedidas,List<TrocaInteressado> trocasInteressados,List<Turno> turnos,int id,Coordenador coordenador,int anoDeCurso,tring nome){
               //TODO
        }
        
        public UC clone(){
            return new UC(this.trocasPedidas,this.trocasInteressados,this.turnos,this.id,this.coordenador,this.anoDeCurso,this.nome);
        }
        
        protected List<Turno> getTurnos(){
            List<Turno> resp = new ArrayList<Turno>();
            for (Turno t : this.turnos)
                resp.add(t.clone());
            return resp;
        }

	protected void addInteresseDeTroca(TrocaInteressado troca) {
            Integer idTroca= trocasInteressados.size();
            troca.SetId(idTroca);
            trocasInteressados.add(troca);
        }

	protected List<TrocaInteressado> getTrocasPedidas() {
            ArrayList<TrocaInteressado> ret = new ArrayList<TrocaInteressado>();
            
            for(TrocaInteressado troca:this.trocasPedidas){
                ret.add(troca.clone());
            }
            return ret;
        }

	protected void registaPresencas(int idTurno, Date data, Map<Integer, Boolean> alunos) {
            Turno t = getTurno(idTurno);
            Aula novaAula = new Aula(alunos,data);
            t.getAulas().add(novaAula); // erro DS
        }

	protected TrocaInteressado getTrocaPedida(int idTroca) {
            boolean flag = false;
            TrocaInteressado aux,ret = null;
            Iterator<TrocaInteressado> it = this.trocasPedidas.iterator();
            int idT;
            
            while(it.hasNext() && !flag){
                aux = it.next();
                idT = aux.getId();
                flag = idT==idTroca;
                if(flag){
                    ret = aux.clone();
                    it.remove();
                }
            }
            
            return ret;
        }

	protected Turno getTurno(int idTurno) {
	}

	protected List<TrocaInteressado> getTrocasInteressados() {
	}
}