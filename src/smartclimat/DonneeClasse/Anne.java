
package smartclimat.DonneeClasse;

import java.util.List;

public class Anne {
      int annee;
    List<Moins> moins;
    
    public Anne(int annee, List<Moins> moins){
        this.annee=annee;
        this.moins=moins;
       
    }
    
      public int getAnnee() {
        return annee;
    }

    public List<Moins> getMoins() {
        return moins;
    }

    public void setMoins(List<Moins> moins) {
        this.moins = moins;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }
    
     public Anne creatAnnee(int annee, List<Moins> moins) {

        if (moins.size() <12){
            return new Anne(annee, moins);
        }
        return null;

    }
    
    
    
}
