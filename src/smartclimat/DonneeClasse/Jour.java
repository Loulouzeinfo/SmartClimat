package smartclimat.DonneeClasse;

import java.util.List;

public class Jour {

    int jour;
    List<Relve> releve;

    public Jour(int jour, List<Relve> releve) {
        this.jour = jour;
        this.releve = releve;
    }

    public int getJour() {
        return jour;
    }

    public List<Relve> getRelves() {
        return releve;
    }
    
    public Relve getRelve(int order) {
        for(int i = 0; i < releve.size(); i++)
            if(releve.get(i).getOrdre() == order)
                return releve.get(i);
        return null;
    }
    

    public void setReleve(List<Relve> releve) {
        this.releve = releve;
    }

    public void setJour(int jour) {
        this.jour = jour;
    }

    public static Jour creatJour(int jour, List<Relve> releve) {

        if (releve.size() == 8) {
            return new Jour(jour, releve);
        }
        return null;

    }

    public void addRelveJour(Relve r) {
        releve.add(r);
    }
    

    public void removeRelveJour(int ordre) {

        for (int i = 0; i < releve.size(); i++) {
            if (releve.get(i).getOrdre() == ordre) {
                 releve.remove(i);
            }

        }

    }
}
