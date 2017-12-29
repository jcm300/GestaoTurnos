package business;

import java.util.List;
import java.util.Map;
import java.util.Iterator;

public class SysFacade {

	private static Map<Integer,Utilizador> utilizadores;
	private static Map<Integer,UC> ucs;

	public static int getIdUC(String UC) {
            List<UC> ucs = SysFacade.getUCsDisponiveis();
            boolean flag = false;
            String nome;
            int ret=-1;
            
            if(ucs.size()!=0){
                Iterator<UC> it = ucs.iterator();
                while(it.hasNext() && !flag){
                    UC u = it.next();
                    nome = u.getNome();
                    flag = nome.equals(UC);
                    if(flag){
                        ret=u.getId();
                    }
                }
            }
            
            return ret;
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
            return uc.clone();
        }

	public static Aluno getAluno(int idAluno) {
            Utilizador u = utilizadores.get(idAluno);
            Aluno a = (Aluno)u;
            return a.clone();
        }

}