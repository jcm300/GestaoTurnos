package business;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;

public class Aula {

	private Map<Integer,Boolean> presencas;
	private Date data;
        

        Aula(Map<Integer,Boolean> pres,Date d){
            presencas=new HashMap(pres);
            data=d;
        };
        
        protected Map<Integer,Boolean> getPresencas(){
            Map<Integer,Boolean> resp = new HashMap<Integer,Boolean>();
            this.presencas.keySet().stream().forEach((id) -> {
                resp.put(id,this.presencas.get(id));
            });
            return resp;
        }

}