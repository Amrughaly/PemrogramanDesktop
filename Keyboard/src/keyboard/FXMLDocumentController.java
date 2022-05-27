package keyboard;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import p_keyboard.p_keyboard;




public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private TextField tfId;
    @FXML
    private TextField tfMerek;
    @FXML
    private ComboBox<?> tfjenis;
    @FXML
    private DatePicker tfTanggal;
    @FXML
    private TextField tfHarga;
    @FXML
    private TableView<p_keyboard> tvBooks;
    @FXML
    private TableColumn<p_keyboard, Integer> colId;
    @FXML
    private TableColumn<p_keyboard, String> colMerek;
    @FXML
    private TableColumn<p_keyboard, String> colJenis;
    @FXML
    private TableColumn<p_keyboard, String> colTanggal;
    @FXML
    private TableColumn<p_keyboard, String> colHarga;
    @FXML
    private Button btnInsert;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    private Object tfJenis;
 
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getSource() == btnInsert){
            insertRecord();
        }else if (event.getSource() == btnUpdate){
            updateRecord();
        }else if(event.getSource() == btnDelete){
            deleteButton();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         showBooks();
        ArrayList <String> list = new ArrayList<String>();
        list.add("QWERTY");
        list.add("DVORAK");
        list.add("Mekanikal");
        list.add("Numeric");
        ObservableList items = FXCollections.observableArrayList(list);
        tfJenis(items);
    }    
    
    public Connection getConnection(){
        Connection conn;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lampu", "root","");
            return conn;
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }
    
    public ObservableList<p_keyboard> getBooksList(){
        ObservableList<p_keyboard> bookList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM lampu";
        Statement st;
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            p_keyboard kursi;
            while(rs.next()){
                kursi = new p_keyboard(rs.getInt("id"), rs.getString("merek"), rs.getEnum("jenis"), rs.getString("tanggal"),rs.getInt("harga"));
                bookList.add(kursi);
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return bookList;
    }
    
    public void showBooks(){
        ObservableList<p_keyboard> list = getBooksList();
        
        colId.setCellValueFactory(new PropertyValueFactory<p_keyboard, Integer>("id"));
        colMerek.setCellValueFactory(new PropertyValueFactory<p_keyboard, String>("merek"));
        colJenis.setCellValueFactory(new PropertyValueFactory<p_keyboard, String>("jenis"));
        colTanggal.setCellValueFactory(new PropertyValueFactory<p_keyboard, String>("tanggal"));
        colHarga.setCellValueFactory(new PropertyValueFactory<p_keyboard, String>("harga"));
        
        tvBooks.setItems(list);
    }
    
    private void insertRecord(){
        String query = "INSERT INTO keyboard VALUES (" + tfId.getText() + ",'" + tfMerek.getText() + "','" + tfJenis.getValue().toString() + "',"
                + tfTanggal.getValue().toString() + "," + tfHarga.getText() + ")";
        executeQuery(query);
        showBooks();
    }
    
    private void updateRecord(){
        String query = "UPDATE  keyboard SET merek  = '" + tfMerek.getText() + "', daya = '" + tfJenis.getValue().toString() + "', tanggal = " +
                tfTanggal.getValue().toString() + ", berat = " + tfHarga.getText() + " WHERE id = " + tfId.getText() + "";
        executeQuery(query);
        showBooks();
    }
    
    private void deleteButton(){
        String query = "DELETE FROM keyboard WHERE id =" + tfId.getText() + "";
        executeQuery(query);
        showBooks();
    }
    
    private void executeQuery(String query) {
        Connection conn = getConnection();
        Statement st;
        try{
            st = conn.createStatement();
            st.executeUpdate(query);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    private void tfJenis(ObservableList items) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
