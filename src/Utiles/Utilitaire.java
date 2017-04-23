package Utiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;
import smartclimat.DonneeClasse.Moins;

public class Utilitaire {

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
            String directory = "data/" + years + "/" + month;
            File file = new File(directory);
            file.mkdirs();
            writeFile = new FileOutputStream(directory + "/" + monthAnnee + ".csv.gz");
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
        } finally {
            try {

                writeFile.close();
                input.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        unzipFile(annee, mois);

        return true;
    }

    public static boolean unzipFile(int annee, int mois) {
        String month, years, monthAnnee = null;
        month = Integer.toString(mois);
        if (mois >= 1 && mois <= 9) {
            month = "0" + month;
        }
        years = Integer.toString(annee);
        monthAnnee = years + month;
        String directory = "data/" + years + "/" + month;

        byte[] buffer = new byte[1024];

        try {

            GZIPInputStream gzis
                    = new GZIPInputStream(new FileInputStream(directory + "/" + monthAnnee + ".csv.gz"));

            FileOutputStream out
                    = new FileOutputStream(directory + "/" + monthAnnee + ".csv");

            int len;
            while ((len = gzis.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }

            gzis.close();
            out.close();

            System.out.println("Done");
            new File(directory + "/" + monthAnnee + ".csv.gz").delete();
            System.out.println("le fichier est bien ete supprime");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return true;
    }
    
    public static boolean  verfiConnect(){
             try {
        final URL url = new URL("http://www.google.fr");
        final URLConnection conn = url.openConnection();
        conn.connect();
        return true;
    } catch (MalformedURLException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        return false;
    }

       
    
        
        
    }

}
