package business;

import java.util.List;
import java.util.Map;

public class SysFacade {

	private static Map<Integer,Utilizador> utilizadores;
	private static Map<Integer,UC> ucs;

	public static int getIdUC(String UC) {
	}

	public static int login(String email, String password) {
            int resp = 0;
            String e;
            String pass;
            boolean flag = false;
            for (Utilizador u : this.utilizadores && !flag){
                e = u.getEmail();
                if (e.equals(email)){
                    pass = u.getPassword();
                    flag = true;
                    if (pass.equals(password))
                        resp = 1;
                    else
                        resp = 2;
                }
            }
            return resp;
	}

        protected List<UC> getUcs(){
            List <UC> resp = new ArrayList<UC>();
            for (UC uc : ucs.values()){
                resp.add(uc);
            }
        }
        
	public static List<UC> getUCsDisponiveis() {
            List<UC> ucs;
            ucs = this.getUcs();
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