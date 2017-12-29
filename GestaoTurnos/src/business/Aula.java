package business;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;

public class Aula {

	private Map<Integer,Boolean> presencas;
	private Date data;
        
        protected Date getData(){
            return this.data;
        }
        
        protected Aula(Map<Integer,Boolean> pres, Date d){
            this.presencas = new HashMap(pres);
            this.data = d;
        }
        
        public Aula clone(){
            return new Aula(this.getPresencas(),this.data);
        }
        
        protected Map<Integer,Boolean> getPresencas(){
            Map<Integer,Boolean> resp = new HashMap<Integer,Boolean>();
            this.presencas.keySet().stream().forEach((id) -> {
                resp.put(id,this.presencas.get(id));
            });
            return resp;
        }

}