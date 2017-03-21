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
   ObservableList<PieChart.Data> pich;
        @FXML
    private JFXButton bt;

    @FXML
    private PieChart ia;

    @FXML
    void cli(ActionEvent event) {
        
           
            pich = FXCollections.observableArrayList(
        new PieChart.Data("janvier", 1),
        new PieChart.Data("février", 2),
        new PieChart.Data("mars", 3),
        new PieChart.Data("avril", 18)
        );
         ia.getData().addAll(pich);
        

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

 
    
}
