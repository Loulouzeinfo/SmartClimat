/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartclimat;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;

/**
 *
 * @author Loulouze
 */
public class FXMLDocumentController implements Initializable {
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Utiles.Utilitaire.downloadFile(2017, 03);
        
        
    }    

 
    
}
