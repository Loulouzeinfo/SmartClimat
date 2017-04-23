/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartclimat;

import Model.DataBean;
import com.jfoenix.controls.JFXButton;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import smartclimat.DonneeClasse.*;
import Model.Model;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTreeView;
import com.sun.deploy.config.JREInfo;
import static com.sun.deploy.config.JREInfo.initialize;
import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Iterator;
import javafx.event.EventHandler;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Loulouze
 */
public class FXMLDocumentController implements Initializable {

    String s = null;
    ObservableList<DataBean> listeTab;
    //List<DataBean> listeTab;
    private Model m;
    @FXML
    private JFXComboBox<String> comville;

    @FXML
    private JFXButton visualiser, comparer;

    @FXML
    private JFXDatePicker date, date2;

    @FXML
    private Label labb;
    @FXML
    private TableColumn<DataBean, String> idstation, nomstation, temperateur, neboli, humidi, datec;

    @FXML
    private LineChart<DataBean, String> humm, tempe, nubb;
    @FXML
    private TableView<DataBean> tablis;

    @FXML
    private ToggleGroup temps;

    @FXML
    private JFXRadioButton btnannee, btnjour, btnmoins;

    @FXML
    private TreeView<String> jtreee;

    @FXML
    void remplirGraphe(ActionEvent event) {
        if (comville.getSelectionModel().getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Séléctionner une Ville", null, JOptionPane.WARNING_MESSAGE);
        }
        m = new Model();
        String po = Integer.toString(m.getIdStationForName(comville.getSelectionModel().getSelectedItem()));
        String dat = date.getValue().toString();
        try {
            m.getDonneeAnnee(po, dat);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        remplirDateGrapheeAndTab();
    }

    private ObservableList<String> obs;
    private List<String> p = new ArrayList<>();

    private List<Float> rem = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        remplirCom();
        m= new Model();
         try {
             m.getDonneeAnnee("07037", "2017-02-02");
         } catch (IOException ex) {
             Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
         }
        m.displayReleve("07037", "02/02/2017");

        //*****************************   Interface *******************//   
        btnjour.setToggleGroup(temps);
        btnjour.setSelected(true);

        date2.setDisable(true);
        visualiser.setDisable(true);
        comparer.setDisable(true);
        date.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                visualiser.setDisable(false);
                date2.setDisable(false);
                comparer.setDisable(true);
            }
        });
        date2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                comparer.setDisable(false);
                visualiser.setDisable(true);
            }
        });
        //***************************************************************************// 

    }

    public void remplirCom() {

        Model m = new Model();
        for (Station mo : m.getListeStation().values()) {
            p.add(mo.getNom());
        }
        obs = FXCollections.observableArrayList(p);
        comville.setItems(obs);

    }

    public void remplirDateGrapheeAndTab() {


            tempe.setTitle("Température " + date.getValue().toString());
            humm.setTitle("Humidité " + date.getValue().toString());
            nubb.setTitle("Nébulosité " + date.getValue().toString());

            XYChart.Series series = new XYChart.Series();
            XYChart.Series seriesn = new XYChart.Series();
            XYChart.Series seriesh = new XYChart.Series();

            listeTab = FXCollections.observableArrayList();

            tempe.getData().addAll(series);
            humm.getData().addAll(seriesh);
            nubb.getData().addAll(seriesn);

            datec.setCellValueFactory(new PropertyValueFactory<DataBean, String>("date"));
            idstation.setCellValueFactory(new PropertyValueFactory<DataBean, String>("idStation"));
            humidi.setCellValueFactory(new PropertyValueFactory<DataBean, String>("humi"));
            neboli.setCellValueFactory(new PropertyValueFactory<DataBean, String>("nubi"));
            temperateur.setCellValueFactory(new PropertyValueFactory<DataBean, String>("temp"));
            nomstation.setCellValueFactory(new PropertyValueFactory<DataBean, String>("nomStation"));

            m.GrapheTemp(comville.getSelectionModel().getSelectedItem(), date.getValue().toString(), series,
                    seriesh, seriesn, listeTab);

            tablis.getItems().addAll(listeTab);

        
    }

}
