package javafx_ik.Admin;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx_ik.Kullanicilar.Firmalar;
import javafx_ik.Kullanicilar.Kisiler;
import javafx_ik.msDB;

public class OdemeBelirlemeController extends Kisiler implements Initializable {

    ArrayList<String> alist = new ArrayList<>();

    static ObservableList<Firmalar> firmaListe = FXCollections.observableArrayList();

    public ObservableList<Firmalar> firmabilgileriGetir() {
        try {
            ResultSet rs = baglan().executeQuery("select * from firmalar");

            while (rs.next()) {
                // System.out.println("fgdfgdf");
                firmaListe.add(new Firmalar(rs.getInt("id"), rs.getInt("bolum_id"), rs.getString("unvan"), rs.getString("yetkili_adi"), rs.getString("yetkili_soyadi"), rs.getString("telefon"), rs.getString("gsm"), rs.getString("logo"), rs.getInt("puan"), rs.getString("aciklama"), rs.getString("web_adresi"), rs.getString("mail"), rs.getString("tarih")));
            }
            baglan().close();

        } catch (Exception e) {
            System.err.println("Data Getirme Hatası : " + e);
        }

        return firmaListe;
    }

    @FXML
    Label lblBedel;

    @FXML
    ComboBox cmbAd;

    @FXML
    TextField txtFirmaPuan;

    @FXML
    TextField txtİlanPuan;

    @FXML
    public void puanYonetimi() throws IOException {
        PuanYonetimiController kay = new PuanYonetimiController();
        Stage ns = new Stage();
        FXMLLoader ld = new FXMLLoader();
        Parent loader = ld.load(kay.getClass().getResource("PuanYonetimi.fxml").openStream());
        Scene gec = new Scene(loader);
        ns.setScene(gec);
        ns.show();
        ns.setOnCloseRequest(geriDonus);
        Stage s = (Stage) lblBedel.getScene().getWindow();
        s.close();
    }

    @FXML
    public void fpuanGetir(ActionEvent evt) {
        String adi = (String) cmbAd.getSelectionModel().getSelectedItem();

        try {
            ResultSet rs = baglan().executeQuery("select puan from firmalar where unvan= '" + adi + "' ");
            while (rs.next()) {
                int comboID = cmbAd.getSelectionModel().getSelectedIndex();

                int i = 0;
                for (String alist1 : alist) {
                    if (i == comboID) {

                        txtFirmaPuan.setText(rs.getString("puan"));
                        ipuanGetir(null);
                        break;
                    }
                    i++;

                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(OdemeBelirlemeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    public void ipuanGetir(ActionEvent evt) {

        int comboID = cmbAd.getSelectionModel().getSelectedIndex();

        for (Firmalar alist1 : firmaListe) {
            // System.out.println("sdfsdfsd sdfsdf s" + alist1.toString());
        }
        Firmalar gelen = firmaListe.get(comboID);
        int id = gelen.getId();
             // System.out.println("asdasdasdasd"+id);

        try {
            ResultSet rs = baglan().executeQuery("select puan_degeri from puanlama where id =  '" + id + "' ");
            while (rs.next()) {

                txtİlanPuan.setText(rs.getString("puan_degeri"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(OdemeBelirlemeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void getir() {

        try {
            ResultSet rs = baglan().executeQuery("select unvan,puan from firmalar");
            while (rs.next()) {
                cmbAd.getItems().add(rs.getString("unvan"));
                alist.add(rs.getString("puan"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(OdemeBelirlemeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    public void hesapla(ActionEvent evt) {

        String a = txtFirmaPuan.getText();
        String b = txtİlanPuan.getText();

        lblBedel.setText((Double.valueOf(a) * Double.valueOf(b)) + "");

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        firmabilgileriGetir();
        getir();
    }

}
