/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import smartclimat.DonneeClasse.Moins;

/**
 *
 * @author Loulouze
 */
public class Utilitaire  {

   
    public static boolean downloadFile(int annee, int mois) {

        String month, years, monthAnnee = null;
        InputStream input = null;
        FileOutputStream writeFile = null;

        month = Integer.toString(mois);
        if (mois >= 1 && mois <= 9) {
            month = "0" + month;
        }

        years = Integer.toString(annee);
        monthAnnee = years + month;

        try {
            URL url = new URL("https://donneespubliques.meteofrance.fr/donnees_libres/Txt/Synop/Archive/synop." + monthAnnee + ".csv.gz");
            URLConnection connection = url.openConnection();
            int fileLength = connection.getContentLength();
            if (fileLength == -1) {
                System.out.println("Invalide URL or file.");
            }

            input = connection.getInputStream();
            //String fileName = url.getFile().substring(url.getFile().lastIndexOf('.') - 1);
            String directory = "data/"+years+ "/"+ month;
            File file = new File(directory);
            file.mkdirs();
            writeFile = new FileOutputStream(directory+"/"+years+month+".csv.gz");
            byte[] buffer = new byte[1024];
            int read;

            while ((read = input.read(buffer)) > 0) {
                writeFile.write(buffer, 0, read);
            }
            writeFile.flush();

        } catch (MalformedURLException ex) {
            ex.getMessage();
        } catch (IOException ex) {
            Logger.getLogger(Utilitaire.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         finally
        {
            try
            {
                writeFile.close();
                input.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        return true;
    }

   
    public boolean unzipFile(File file) {
        return false;
    }

  
    public boolean createDirectory(int annee, int mois) {
        return false;
    }

}
