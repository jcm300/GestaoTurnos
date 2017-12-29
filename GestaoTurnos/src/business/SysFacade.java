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
	}

	public static boolean existeUC(int idUC) {
	}

	public static void addSugestao(Troca troca) {
	}

	public static UC getUC(int idUC) {
            UC uc = null;
            uc = ucs.get(idUC);
            return uc.clone();
        }

	public static Aluno getAluno(int idAluno) {
            Utilizador u = utilizadores.get(idAluno);
            Aluno a = (Aluno)u;
            return a.clone();
        }

}