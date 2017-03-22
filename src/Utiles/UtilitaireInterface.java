/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles;

import java.io.File;

/**
 *
 * @author Loulouze
 */
public interface UtilitaireInterface {
    public boolean downloadFile(int annee,int mois);
    public boolean unzipFile(File file);
    public boolean createDirectory(int annee,int mois);
    
}
