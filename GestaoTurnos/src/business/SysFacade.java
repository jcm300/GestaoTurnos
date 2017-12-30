package business;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Observable;
import java.util.Date;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class SysFacade extends Observable{

    private static Map<Integer,Utilizador> utilizadores;
    private static Map<Integer,UC> ucs;
    
    public SysFacade(){
        this.utilizadores = new HashMap<Integer,Utilizador>();
        this.ucs = new HashMap<Integer,UC>();
    }
    
        public void testing(){
        Map<Integer,Integer> aluno_turnos = new HashMap<>();
        aluno_turnos.put(0,0);
        Map<Integer,List<Integer>> doc_turnos = new HashMap<>();
        List<Integer> l = new ArrayList();
        l.add(0);
        doc_turnos.put(0,l);
        SysFacade.utilizadores.put(0,new Aluno("aluno1","aluno1",new ArrayDeque<>(), aluno_turnos ));
        SysFacade.utilizadores.put(3,new AlunoTE("aluno2","aluno2",new ArrayDeque<>(),new HashMap<>()));
        SysFacade.utilizadores.put(2, new Docente("docente1","docente1",doc_turnos ));
        Coordenador aux=new Coordenador("coordenador1","coordenador1",new HashMap<>(),0);
        SysFacade.utilizadores.put(1, aux);
        Map<Integer,Boolean> presencas = new HashMap<Integer,Boolean>();
        presencas.put(0,true);     
        Calendar c1= GregorianCalendar.getInstance();
        c1.set(2000, Calendar.JANUARY, 30,0,0,0); //Calendar.JANUARY
        Date d= c1.getTime();
        Aula aula = new Aula(presencas,d);
        List<Aula> aulas = new ArrayList<Aula>();
        aulas.add(aula);
        Turno t= new Turno(aulas,0,10,10,1,new Date(),new Date());
        List<Turno> turnos= new ArrayList<Turno>();
        turnos.add(0,t);
        SysFacade.ucs.put(0, new UC(new ArrayList<>(),new ArrayList<>(),turnos,0,aux,3,"Base de Dados"));
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