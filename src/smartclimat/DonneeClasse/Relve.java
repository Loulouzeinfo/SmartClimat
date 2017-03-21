package smartclimat.DonneeClasse;

public class Relve {

    int ordre;
    double temperateur;
    double humidite;
    double nubilosite;

    public int getOrdre() {
        return ordre;
    }

    public void setOrdre(int ordre) {
        this.ordre = ordre;
    }

    public double getTemperateur() {
        return temperateur;
    }

    public void setTemperateur(float temperateur) {
        this.temperateur = temperateur;
    }

    public double getHumidite() {
        return humidite;
    }

    public void setHumidite(float humidite) {
        this.humidite = humidite;
    }

    public double getNubilosite() {
        return nubilosite;
    }

    public void setNubilosite(float nubilosite) {
        this.nubilosite = nubilosite;
    }
    
    	public Relve(int ordre, double temperateur, double humidite, double nubilosite) {
		this.ordre = ordre;
		this.temperateur = temperateur;
		this.humidite = humidite;
		this.nubilosite = nubilosite;
	}

}
