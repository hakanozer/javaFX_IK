/*
 Akın Çandır
 */
package javafx_ik.KullaniciBolumu;

import java.net.URL;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx_ik.msDB;

public class IlanAramaFXMLController extends msDB implements Initializable {

    @FXML
    TableView tblIlan;
    @FXML
    TableColumn colFirma;
    @FXML
    TableColumn colIlan;
    @FXML
    TextField txtIlan;
    @FXML
    TextField txtFirma;
    @FXML
    TextField txtBolum;
    @FXML
    Button btnGetir;
    @FXML
    Button btnBasvur;
    @FXML
    Label lblIlan;
    @FXML
    Label lblFirma;
    @FXML
    Label lblAciklama;
    @FXML
    Label lblBasTarih;
    @FXML
    Label lblBitTarih;
    @FXML
    Label lblTire;
    @FXML
    ImageView imgLogo;

    @FXML
    public void ilanGetir() {
        secimTemizle();
        ObservableList<IlanVeri> ilanListe = FXCollections.observableArrayList();
        tblIlan.getItems().clear();
        try {
            ResultSet rs = baglan().executeQuery("select * from ilanlar i left join firmalar f on f.id=i.firma_id where (unvan LIKE '%" + txtFirma.getText() + "%' or '" + txtFirma.getText() + "' is null) and (baslik LIKE '%" + txtIlan.getText() + "%' or '" + txtIlan.getText() + "' is null) and (bolumler LIKE '%" + txtBolum.getText() + "%' or '" + txtBolum.getText() + "' is null)");
            while (rs.next()) {
                ilanListe.add(new IlanVeri(rs.getInt("id"), rs.getString("unvan"), rs.getString("baslik")));
            }
        } catch (Exception e) {
            System.err.println("İlan Getirme Hatası : " + e);
        }
        colIlan.setCellValueFactory(new PropertyValueFactory<IlanVeri, String>("ilanBaslik"));
        colFirma.setCellValueFactory(new PropertyValueFactory<IlanVeri, String>("firmaAd"));
        tblIlan.setItems(ilanListe);
    }

    @FXML
    public void secimGetir() {
        final IlanVeri secim = (IlanVeri) tblIlan.getSelectionModel().getSelectedItem();
        try {
            ResultSet rs = baglan().executeQuery("select * from ilanlar i left join firmalar f on f.id=i.firma_id where i.id='" + secim.getId() + "'");
            if (rs.next()) {
                Image logo = new Image("file:" + rs.getString("logo"));
                imgLogo.setImage(logo);
                String basTarih = new SimpleDateFormat("dd.MM.yyyy").format(rs.getDate("baslangic_tarihi"));
                String bitTarih = new SimpleDateFormat("dd.MM.yyyy").format(rs.getDate("bitis_tarihi"));
                lblIlan.setText(rs.getString("baslik"));
                lblFirma.setText(rs.getString("unvan"));
                lblAciklama.setText(rs.getString("kisa_aciklama"));
                lblBasTarih.setText(basTarih);
                lblTire.setText("-");
                lblBitTarih.setText(bitTarih);
                btnBasvur.setDisable(false);
            } else {
                Alert uyari = new Alert(Alert.AlertType.INFORMATION);
                uyari.setContentText("Seçim Yapılmadı");
                uyari.show();
            }
        } catch (Exception e) {
            System.err.println("Seçim Getirme Hatası : " + e);
        }
    }

    public void secimTemizle() {
        btnBasvur.setDisable(true);
        imgLogo.setImage(null);
        lblIlan.setText("");
        lblFirma.setText("");
        lblAciklama.setText("");
        lblBasTarih.setText("");
        lblTire.setText("");
        lblBitTarih.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ilanGetir();
    }

}
