package javafx_ik.Admin;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx_ik.Bolumu.IK_BolumuController;
import javafx_ik.Hata;
import javafx_ik.Kullanicilar.Kisiler;

public class Ik_ListeController extends Kisiler implements Initializable, Hata {

    static ObservableList<ik_data> ik_liste = FXCollections.observableArrayList();

    public ObservableList<ik_data> dataGelsin() {
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
    // bu metod ik bölümünün yönetim sayfasına geçiş yapacak
    public void ikYonetim() throws IOException {
        IK_BolumuController ik = new IK_BolumuController();
        Stage ns = new Stage();
        FXMLLoader ld = new FXMLLoader();
        Parent loader = ld.load(ik.getClass().getResource("IK_Bolumu.fxml").openStream());
        Scene gec = new Scene(loader);
        ns.setScene(gec);
        ns.show();
        ns.setOnCloseRequest(geriDonus);
        Stage s = (Stage) ik_tablo.getScene().getWindow();
        s.close();
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
    TextField adi;
    @FXML
    TextField soyadi;
    @FXML
    TextField telefon;
    @FXML
    TextField gsm;
    @FXML
    TextField adres;
    @FXML
    TextField mail;

    public void dataGetir(String id) {

        try {

            ResultSet rs = baglan().executeQuery("select *from ik_uzmani where id = '" + id + "'");
            if (rs.next()) {

                adi.setText(rs.getString("adi"));
                soyadi.setText(rs.getString("soyadi"));
                telefon.setText(rs.getString("telefon"));
                gsm.setText(rs.getString("gsm"));
                adres.setText(rs.getString("adres"));
                mail.setText(rs.getString("mail"));

            }

        } catch (Exception e) {
        }

    }

    @FXML
    public void guncelle() throws SQLException {

        if (!Hata.hataDenetle(adi) && !Hata.hataDenetle(soyadi) && !Hata.hataDenetle(telefon) && !Hata.hataDenetle(gsm) && !Hata.hataDenetle(adres) && !Hata.hataDenetle(mail)) {

            final ik_data secim = (ik_data) ik_tablo.getSelectionModel().getSelectedItem();
            String id = "" + secim.getId();
            int durum = baglan().executeUpdate("update ik_uzmani set adi = '" + adi.getText() + "', soyadi = '" + soyadi.getText() + "', telefon = '" + telefon.getText() + "', gsm = '" + gsm.getText() + "', adres = '" + adres.getText() + "', mail = '" + mail.getText() + "' where id = '" + id + "'");

            if (durum > 0) {

                System.out.println("Güncelleme İşlemi Başarılı");
                initialize(null, null);

            } else {
                System.out.println("Güncelleme İşlemi Hatalı");
            }

        } else {

        }
    }

    @FXML
    public void kisiSil() throws SQLException {

        final ik_data secim = (ik_data) ik_tablo.getSelectionModel().getSelectedItem();
        String id = "" + secim.getId();
        int durum = baglan().executeUpdate("delete from ik_uzmani where id = '" + id + "'");
        if (durum > 0) {
            System.out.println("Silme İşlemi Başarılı");
            initialize(null, null);
        } else {
            System.out.println("Silme İşlemi Hatalı");
        }

    }

}
