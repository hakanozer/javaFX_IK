package javafx_ik.Admin;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class BolumYonetimiController extends Bolumler implements Initializable {

    @FXML
    TableView tableBolum;
    @FXML
    TableColumn c1, c2, c3;
    @FXML
    TextField txtBolumyeni, yeniUstKat;
    @FXML
    ChoiceBox katbox;

    private void choices() {
        katbox.getItems().clear();
        try {
            ResultSet rs = baglan().executeQuery("SELECT *FROM bolumler WHERE alt_kat_id=0");
            while (rs.next()) {
                katbox.getItems().addAll(rs.getString("adi"));
            }
        } catch (Exception e) {
        }

    }

    @FXML
    private void yeniUstKatEkle() {
        try {
            int durum = baglan().executeUpdate("INSERT INTO bolumler VALUES ('" + yeniUstKat.getText() + "', '0')");
        } catch (Exception e) {
        }
        yeniUstKat.setText("");
        initialize(null, null);
    }

    @FXML
    private void yeniKategoriEkle() {
        String yeniBolum = (String) katbox.getSelectionModel().getSelectedItem();

        try {
            int durum = baglan().executeUpdate("INSERT INTO bolumler VALUES ('" + txtBolumyeni.getText() + "',(SELECT id from bolumler WHERE adi= '" + yeniBolum + "'))");
        } catch (Exception e) {
            System.err.println("Bölüm eklenemedi : " + e);
        }
        txtBolumyeni.setText("");
        initialize(null, null);
    }

    /* @FXML
     private void duzenle() throws SQLException {
     final Bolumler sinif = (Bolumler) tableBolum.getSelectionModel().getSelectedItem();
     setId(sinif.getId());
     setAdi(txtBolum.getText());
     setAlt_kat_id(Integer.valueOf(txtUstKat.getText()));
     BolumDuzenle();
     initialize(null, null);
     txtBolum.setText("");
     txtUstKat.setText("");

     }*/
    @FXML
    private void secimYap() {
        final Bolumler sinif = (Bolumler) tableBolum.getSelectionModel().getSelectedItem();
        setId(sinif.getId());
    }

    @FXML
    private void silButon() throws SQLException {
        Bolumler sinif = (Bolumler) tableBolum.getSelectionModel().getSelectedItem();
        if (sinif != null) {
            setId(sinif.getId());
            sil();
            sinif = null;
            initialize(null, null);
        } else {
            Alert uyari= new Alert(Alert.AlertType.ERROR);
           uyari.setContentText("Kategori seçiniz...");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        choices();
        c1.setCellValueFactory(new PropertyValueFactory<>("id"));
        c2.setCellValueFactory(new PropertyValueFactory<>("adi"));
        c3.setCellValueFactory(new PropertyValueFactory<>("alt_kat_id"));
        Bolumler b = new Bolumler();
        tableBolum.setItems(b.bilgileriGetir());
    }

}
