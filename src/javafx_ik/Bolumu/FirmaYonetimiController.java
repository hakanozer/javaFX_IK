package javafx_ik.Bolumu;

import java.net.URL;
import java.sql.ResultSet;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx_ik.msDB;

public class FirmaYonetimiController extends msDB implements Initializable {

    @FXML
    TableView tableFirma;

    public ObservableList<Firma> bilgileriGetir() {
        ObservableList<Firma> asciListe = FXCollections.observableArrayList();
        try {
            ResultSet rs = baglan().executeQuery("select * from firmalar");
            while (rs.next()) {
                asciListe.add(new Firma(rs.getInt("id"), rs.getString("bolum_id"), rs.getString("unvan"), rs.getString("yetkili_adi"), rs.getString("yetkili_soyadi"), rs.getString("telefon"), rs.getString("gsm"), rs.getString("logo"), rs.getByte("puan"), rs.getString("aciklama"), rs.getString("web_adresi"), rs.getString("mail"), rs.getDate("tarih")
                ));
            }
            baglan().close();

        } catch (Exception e) {
            System.err.println("Data getirme hatası " + e);
        }
        return asciListe;
    }

    public void bilgiGetir(String s) {
        try {
            ResultSet rs = baglan().executeQuery("select * from firmalar where id=" + s);
            if (rs.next()) {

            } else {
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("aşçı yok");
                a.show();
            }
        } catch (Exception e) {
        }
    }
    @FXML
    TableColumn c1, c2, c3, c4, c5, c6, c7, c8, c9, c10;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        c1.setCellValueFactory(new PropertyValueFactory<>("id"));
        c2.setCellValueFactory(new PropertyValueFactory<>("bolum_id"));
        c3.setCellValueFactory(new PropertyValueFactory<>("adi"));
        c4.setCellValueFactory(new PropertyValueFactory<>("soyadi"));
        c5.setCellValueFactory(new PropertyValueFactory<>("telefon"));
        c6.setCellValueFactory(new PropertyValueFactory<>("adres"));
        c7.setCellValueFactory(new PropertyValueFactory<>("kul_adi"));
        c8.setCellValueFactory(new PropertyValueFactory<>("sifre"));
        c9.setCellValueFactory(new PropertyValueFactory<>("tarih"));
        c10.setCellValueFactory(new PropertyValueFactory<>("seviye"));

        FirmaYonetimiController ns = new FirmaYonetimiController();
        tableFirma.setItems(ns.bilgileriGetir());
    }

}
