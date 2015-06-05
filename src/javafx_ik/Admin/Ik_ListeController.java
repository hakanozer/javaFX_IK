
package javafx_ik.Admin;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx_ik.msDB;


public class Ik_ListeController extends msDB implements Initializable {
    
    static ObservableList<ik_data> ik_liste = FXCollections.observableArrayList();
    
    public ObservableList <ik_data> dataGelsin() {
        try {
            ResultSet rs = baglan().executeQuery("select *from ik_uzmani");

            while (rs.next()) {
                ik_liste.add(new ik_data(rs.getInt("id"), rs.getString("adi"), rs.getString("soyadi"), rs.getString("telefon"), rs.getString("gsm"), rs.getString("adres"), rs.getString("mail"), rs.getDate("tarih")));
            }
            baglan().close();

        } catch (Exception e) {
            System.err.println("Data Getirme Hatası : " + e);
        }

        return ik_liste;
    }
    
    @FXML
    TableView ik_tablo;
    @FXML
    TableColumn s1;
    @FXML
    TableColumn s2;
    @FXML
    TableColumn s3;
    @FXML
    TableColumn s4;
    @FXML
    TableColumn s5;
    @FXML
    TableColumn s6;
    @FXML
    TableColumn s7;
    @FXML
    TableColumn s8;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ik_tablo.getItems().clear();
        s1.setCellValueFactory(new PropertyValueFactory<>("id"));
        s2.setCellValueFactory(new PropertyValueFactory<>("adi"));
        s3.setCellValueFactory(new PropertyValueFactory<>("soyadi"));
        s4.setCellValueFactory(new PropertyValueFactory<>("telefon"));
        s5.setCellValueFactory(new PropertyValueFactory<>("gsm"));
        s6.setCellValueFactory(new PropertyValueFactory<>("adres"));
        s7.setCellValueFactory(new PropertyValueFactory<>("mail"));
        s8.setCellValueFactory(new PropertyValueFactory<>("tarih"));
        
        Ik_ListeController ik = new Ik_ListeController();
        ik_tablo.setItems(ik.dataGelsin());
    }

    @FXML
    public void kisiSec() {
        

        final ik_data secim = (ik_data) ik_tablo.getSelectionModel().getSelectedItem();
        
        dataGetir("" + secim.getId());
        
    }

    @FXML
    TextField txtAdi;
    @FXML
    TextField txtSoyadi;
    @FXML
    TextField txtTelefon;
    @FXML
    TextField txtGsm;
    @FXML
    TextField txtAdres;
    @FXML
    TextField txtMail;

    public void dataGetir(String id) {

        try {

            ResultSet rs = baglan().executeQuery("select *from ik_uzmani where id = '" + id + "'");
            if (rs.next()) {

                txtAdi.setText(rs.getString("adi"));
                txtSoyadi.setText(rs.getString("soyadi"));
                txtTelefon.setText(rs.getString("telefon"));
                txtGsm.setText(rs.getString("gsm"));
                txtAdres.setText(rs.getString("adres"));
                txtMail.setText(rs.getString("mail"));

            } 

        } catch (Exception e) {
        }

    }
    
    @FXML
    public void guncelle() throws SQLException {

    final ik_data secim = (ik_data) ik_tablo.getSelectionModel().getSelectedItem();
    String id = ""+secim.getId();
    int durum = baglan().executeUpdate("update ik_uzmani set adi = '"+txtAdi.getText()+"', soyadi = '"+txtSoyadi.getText()+"', telefon = '"+txtTelefon.getText()+"', gsm = '"+txtGsm.getText()+"', adres = '"+txtAdres.getText()+"', mail = '"+txtMail.getText()+"' where id = '"+id+"'");
    if(durum > 0) {
        System.out.println("Güncelleme İşlemi Başarılı");
        initialize(null, null);
    }else {
        System.out.println("Güncelleme İşlemi Hatalı");
    }
   
    }
    
    @FXML
    public void kisiSil() throws SQLException {

    final ik_data secim = (ik_data) ik_tablo.getSelectionModel().getSelectedItem();
    String id = ""+secim.getId();
    int durum = baglan().executeUpdate("delete from ik_uzmani where id = '"+id+"'");
    if(durum > 0) {
        System.out.println("Silme İşlemi Başarılı");
        initialize(null, null);
    }else {
        System.out.println("Silme İşlemi Hatalı");
    }
   
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
      
    
    
    
}
