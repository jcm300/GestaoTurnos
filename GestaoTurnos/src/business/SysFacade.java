package business;

import java.util.ArrayList;
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
        for(Utilizador u : SysFacade.utilizadores.values()){
            e = u.getEmail();
            if (e.equals(email)){
                pass = u.getPassword();
                flag = true;
                if (pass.equals(password)){
                    resp = 1;
                    if(u instanceof Aluno) ((Aluno)u).verificarPresencas(); //verificar se as faltas do aluno nao excedem 25%
                }
                else
                    resp = 2;
                break;
            }
        }
        return resp;
    }

    public static List<UC> getUCsDisponiveis() {
        List <UC> resp = new ArrayList<UC>();
        for (UC uc : SysFacade.ucs.values()){
            resp.add(uc);
        }
        return resp;
    }

    public static boolean existemVagas(int idUC, int idTurno){
        if(existeTurno(idUC,idTurno)){
            int oc=(int)utilizadores.values().stream().filter(u->u instanceof Aluno)
                                    .map(uA->(Aluno)uA).filter(u->u.alunoInscritoNaUC(idUC))
                                    .filter(u->u.getTurnos().get(idUC)==idTurno).count();

            return ucs.get(idUC).getTurno(idTurno).getCapacidade() > oc;
        }else return false;
    }

    public static void inputDados(String ficheiro){

    }

    public static boolean geraDistribuicao(){
        return true;
    }

    public static boolean existeTurno(int idUC, int idTurno) {
        if(SysFacade.existeUC(idUC)){
            UC uc=SysFacade.getUC(idUC);
            List<Turno> turnos = uc.getTurnos();

            for(Turno t:turnos)
                if(t.getId()==idTurno) return true;
        }
        return false;
    }

    public static boolean existeUC(int idUC) {
        for(UC uc: SysFacade.ucs.values())
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