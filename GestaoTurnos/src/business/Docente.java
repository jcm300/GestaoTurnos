package business;

import java.util.*;
import java.util.stream.Collectors;

public class Docente extends Utilizador {

	private Map<Integer,List<Integer>> turnos;

        //constructors
	protected Docente(Docente oldD){
            super(oldD);
            this.turnos=oldD.getTurnos();
        }
        
        public Docente(String email,String password,Map<Integer,List<Integer>> turnos){
            super(email,password);
            this.turnos=turnos.entrySet().stream().collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));
        }
        
        protected Docente(){
            super();
            this.turnos=new HashMap<Integer,List<Integer>>();
        }
        
        
        //getters & setters
        protected Map<Integer,List<Integer>> getTurnos(){
            return this.turnos.entrySet().stream().collect(Collectors.toMap(e->e.getKey(),e->e.getValue()));
        }
        
        protected void setTurnos(Map<Integer,List<Integer>> nTurnos){
            this.turnos=nTurnos.entrySet().stream().collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));
        }
        
        protected Docente clone(){
            return new Docente(this);
        }
        
        public Map<Integer, Boolean> consultarPresencas(int idUC, int idTurno, Date data) throws UCInvalidaException,TurnoInexistenteException,AulaInexistenteException{
            boolean ucValida = SysFacade.existeUC(idUC);
            if (ucValida == false)
                throw new UCInvalidaException("A UC inserida é inválida");
            boolean turnoExiste = SysFacade.existeTurno(idUC,idTurno);
            if (turnoExiste == false)
                throw new TurnoInexistenteException("O turno inserido não existe");
            UC uc = SysFacade.getUC(idUC);
            Turno turno = uc.getTurno(idTurno);
            boolean eAula = turno.existeAula(data);
            if (eAula == false)
                throw new AulaInexistenteException("Não ocorreu aula na data especificada");
            Aula aula = turno.getAula(data);
            return aula.getPresencas();
        }
}