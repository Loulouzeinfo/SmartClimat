package smartclimat.DonneeClasse;

import java.util.List;


public class Moins {
    
    int moins;
    List<Jour> jour;
    
    public Moins(int moins, List<Jour> jour){
        this.jour=jour;
        this.moins=moins;
       
    }
    
      public int getMoins() {
        return moins;
    }

    public List<Jour> getJour() {
        return jour;
    }

    public void setJour(List<Jour> jour) {
        this.jour = jour;
    }

    public void setMoins(int moins) {
        this.moins = moins;
    }
    
     public Moins creatMoins(int moins, List<Jour> jour) {

        if (jour.size() > 27){
            return new Moins(moins, jour);
        }
        return null;

    }
     
     
     
     
    
    
}
