package business;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Observable;

public class SysFacade extends Observable{

    private static Map<Integer,Utilizador> utilizadores;
    private static Map<Integer,UC> ucs;
    
    public SysFacade(){
        this.utilizadores = new HashMap<Integer,Utilizador>();
        this.ucs = new HashMap<Integer,UC>();
    }
    
    public static void testing(){
        SysFacade.utilizadores.put(0,new Aluno("aluno1@universidade.pt","aluno1",new ArrayDeque<>(),new HashMap<>()));
        SysFacade.ucs.put(0, new UC(new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),0,new Coordenador(0),3,"Base de Dados"));
    }

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
        SysFacade.getAluno(troca.getIdAluno1()).getTrocasPendentes().addFirst(troca);            
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
    
    public static Utilizador getUtilizador(String email){
        Utilizador ret = null;
        for(Utilizador u : SysFacade.utilizadores.values())
            if (email.equals(u.getEmail())) ret = u; 
        return ret;
    }
}