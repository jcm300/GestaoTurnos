package business;

import java.util.*;

public class Docente extends Utilizador {

	private Map<Integer,List<Integer>> turnos;

	protected Map<Integer, Boolean> consultarPresencas(int idUC, int idTurno, Date data) throws UCInvalidaException,TurnoInexistenteException,AulaInexistenteException{
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