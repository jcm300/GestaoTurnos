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
        
}