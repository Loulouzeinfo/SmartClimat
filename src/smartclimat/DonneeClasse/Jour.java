
package smartclimat.DonneeClasse;

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
    
    
    
}
