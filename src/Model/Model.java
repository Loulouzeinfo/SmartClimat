/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import smartclimat.DonneeClasse.Annee;
import smartclimat.DonneeClasse.Station;

public class Model {
    
    private Map<Integer,Station> stationList;

    public Model() {
        this.stationList = new HashMap();
        getNomStation();
    }
    
    
    public void getNomStation() {

        FileReader reader = null;
        try {
            reader = new FileReader(new File("data/Stations/Station.csv"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }

        BufferedReader buff = new BufferedReader(reader);

        try {
            String p = buff.readLine();
            p = buff.readLine();
            while (p != null) {

                String tab[] = p.split(";");
                int id = Integer.parseInt(tab[0]);
                Station s = new Station(id, tab[1]);
                stationList.put(id, s);
                p = buff.readLine();
            }

            buff.close();

        } catch (IOException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean getDonneeAnnee(int annee, int mois) throws FileNotFoundException, IOException {

        String month, years, chemin = null;
        month = Integer.toString(mois);
        if (mois >= 1 && mois <= 9) {
            month = "0" + Integer.toString(mois);
        }
        years = Integer.toString(annee);
        chemin = "data/" + years + "/" + month + "/";
        File f = new File(chemin + years + month + ".csv");
        FileReader read=new FileReader(f);
        BufferedReader buff= new BufferedReader(read);
        
        String p= buff.readLine();
        p=buff.readLine();
        while (p != null) {
            
            String tab []= p.split(";");
            int idStation = Integer.parseInt(tab[0]);
            int annee1 = Integer.parseInt(tab[1].substring(0,4));
            int mois1 =  Integer.parseInt(tab[1].substring(4,6));
            int jour1 =  Integer.parseInt(tab[1].substring(6,8));
            int ordre1=  Integer.parseInt(tab[1].substring(8,10))/3;
            float temperateur= Float.parseFloat(tab[7]);
            float nebulosite= Float.parseFloat(tab[14]);
            float humidite= Float.parseFloat(tab[9]);
            
            stationList.
                    get(idStation).
                    getCreateAnne(annee1).
                    getCreateMois(mois1).
                    getCreateJour(jour1).
                    getSingleReleve(ordre1).
            
        }
        
        

        return true;

    }

}
