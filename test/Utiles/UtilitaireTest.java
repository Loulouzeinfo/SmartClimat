/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Loulouze
 */
public class UtilitaireTest {
    
    public UtilitaireTest() {
    }
    
 
    @Test
    public void testDownloadFile() {
        System.out.println("downloadFile");
        int annee = 2017;
        int mois = 04;
        boolean expResult = true;
        boolean result = Utilitaire.downloadFile(annee, mois);
        assertEquals(expResult, result);
       
    }


    
    /**
     * Test of verfiConnect method, of class Utilitaire.
     */
    @Test
    public void testVerfiConnect() {
        System.out.println("verfiConnect");
        boolean expResult = true;
        boolean result = Utilitaire.verfiConnect();
        assertEquals(expResult, result);
       
    }
    
}
