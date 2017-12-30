package business;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
        
        
        protected UC(UC oldUC){
            this.trocasPedidas=oldUC.getTrocasPedidas();
            this.trocasInteressados=oldUC.getTrocasInteressados();
            this.turnos=oldUC.getTurnos();
            this.id=oldUC.getId();
            this.coordenador=oldUC.getCoordenador();
            this.anoDeCurso=oldUC.getAnoDeCurso();
            this.nome=oldUC.getNome();
        }
        
        public UC(List<TrocaInteressado> trocasPedidas,List<TrocaInteressado> trocasInteressados,List<Turno> turnos,int id,Coordenador coordenador,int anoDeCurso,String nome){
            this.trocasPedidas=trocasPedidas.stream().map(TrocaInteressado::clone).collect(Collectors.toList());
            this.trocasInteressados=trocasInteressados.stream().map(TrocaInteressado::clone).collect(Collectors.toList());
            this.turnos=turnos.stream().map(Turno::clone).collect(Collectors.toList());
            this.id=id;
            this.coordenador=coordenador.clone();
            this.nome=nome;
        }
        
        //getters & setters
        public int getId(){
            return this.id;
        }
        
        protected void setId(int id){
            this.id=id;
        }
        
        public String getNome(){
            return this.nome;
        }
        
        protected List<TrocaInteressado> getTrocasInteressados() {
            return this.trocasInteressados.stream().map(TrocaInteressado::clone).collect(Collectors.toList());
	}
        
        protected void setTrocasInteressados(List<TrocaInteressado> nL){
            this.trocasInteressados=nL.stream().map(TrocaInteressado::clone).collect(Collectors.toList());
        }
        
        protected List<Turno> getTurnos(){
            return this.turnos.stream().map(Turno::clone).collect(Collectors.toList());
        }

	protected void addInteresseDeTroca(TrocaInteressado troca) { //erro ds
            trocasInteressados.add(troca);
        }
        
        protected List<TrocaInteressado> getTrocasPedidas() {
            ArrayList<TrocaInteressado> ret = new ArrayList<TrocaInteressado>();
            
            for(TrocaInteressado troca:this.trocasPedidas){
                ret.add(troca.clone());
            }
            return ret;
        }
        
        protected Coordenador getCoordenador(){
            return this.coordenador.clone();
        }
        
        public int getAnoDeCurso(){
            return this.anoDeCurso;
        }
        
        public UC clone(){
            return new UC(this);
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
            Turno turno=null;
            boolean flag = false;
            int id;
            for (Turno t : this.turnos){
                id=t.getId();
                if(idTurno == id){
                    flag = true;
                    turno = t;
                    break;
                }
            }
            return turno;
	}
}