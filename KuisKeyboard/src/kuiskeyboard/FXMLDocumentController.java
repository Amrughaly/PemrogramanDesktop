/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kuiskeyboard;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 *
 * @author Thinkpad
 */
public class FXMLDocumentController implements Initializable {
    
   
    @FXML
    private Button bt_simpan;

    @FXML
    private ComboBox<?> cb_jenis;

    @FXML
    private Label date;

    @FXML
    private DatePicker dp_tanggal;

    @FXML
    private Label harga;

    @FXML
    private Label jenis;

    @FXML
    private Label judul;

    @FXML
    private Label merek;

    @FXML
    private TextField tf_harga;

    @FXML
    private TextField tf_merek;

    @FXML
    private TextField tf_warna;

    @FXML
    private Label warna;

     
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        System.out.println(tf_merek.getText());
        System.out.println(tf_harga.getText());
        System.out.println(tf_warna.getText());
        System.out.println(dp_tanggal.getValue().toString());
        System.out.println(cb_jenis.getValue().toString());
        }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ArrayList <String> list = new ArrayList<String>();
        list.add("Keyboard QWERTY");
        list.add("Keyboard Dvorak");
        list.add("Keyboard Numeric");
        list.add("Keyboard Mechanical");
        ObservableList items = FXCollections.observableArrayList(list);
        cb_jenis.setItems(items);
    }       
    
}
