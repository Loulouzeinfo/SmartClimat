
package smartclimat.DonneeClasse;

import java.util.HashMap;
import java.util.Map;

public class Jour {
    
    private int jour;
    private Map<Integer, Releve> releve;

    public int getJour() {
        return jour;
    }

    public void setJour(int jour) {
        this.jour = jour;
    }

    public Map<Integer, Releve> getReleve() {
        return releve;
    }

    public void setReleve(Map<Integer, Releve> releve) {
        this.releve = releve;
    }
     
    public Releve getSingleReleve(int ordre){
        
        return this.releve.get(ordre);
    }
    
     public Releve getCreateReleve(int order){
        
        if(getSingleReleve(order)!=null){
            return getSingleReleve(order);
        }else {
            
            return this.releve.put(order, new Releve());
        }
  }

    public Jour(int jour) {
        this.jour = jour;
        this.releve = new HashMap<Integer, Releve>();
    }
    
    
    
}
