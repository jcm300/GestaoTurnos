package business;

import java.util.List;
import java.util.Map;

public class SysFacade {

	private static Map<Integer,Utilizador> utilizadores;
	private static Map<Integer,UC> ucs;

	public static int getIdUC(String UC) {
	}

	public static boolean existeTurnos() {
	}

	public static int login(String email, String password) {
	}

	public static List<UC> getUCsDisponiveis() {
	}

	public static boolean existemVagas(int idUC, int idTurno) {
	}

	public static void inputDados(String ficheiro) {
	}

	public static boolean geraDistribuicao() {
	}

	public static boolean existeTurno(int idUC, int idTurno) {
            boolean res=SysFacade.existeUC(idUC);
            if(!res) return res;
            
            res=false;
            UC uc=SysFacade.getUC(idUC);
            List<Turno> turnos = uc.getTurnos();
            
            for(t:turnos)
                if(t.getId()==idTurno) return true;
            return res;
	}

	public static boolean existeUC(int idUC) {
            for(uc:SysFacade.ucs.values())
                if(uc.getId()==idUC) return true;
            return false;
	}

	public static void addSugestao(Troca troca) {
	}

	public static UC getUC(int idUC) {
            UC uc = null;
            uc = ucs.get(idUC);
            return uc;
        }

	public static Aluno getAluno(int idAluno) {
	}

}