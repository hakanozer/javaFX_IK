package javafx_ik.KullaniciBolumu;

import static java.awt.Color.red;
import java.io.File;
import java.net.URL;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx_ik.msDB;

public class IkBasvuruFXMLController extends msDB implements Initializable {

    @FXML
    TextField firmaAdi, ilanBaslik, bolum, ilanKisaAciklama, personelSayisi, ilanNo,
            ilanEklenmeTar, ilanBaslamaTar, ilanBitisTar, ilanDurum, izlenme;

    @FXML
    TextArea ilanDetay, ilanKosul;

    @FXML
    Button btnBasvur;

    @FXML
    ImageView resim;

    @FXML
    Label lblIlanBasvuruDurum;

//    Labele resim ekleme için gerekebilir
//    @FXML
//    Label resimLabel;
    String secimId = "";
    String basvuruDurum = "";

    @FXML
    public void bilgiler() {
        ResultSet rs;
        String sorgu = "SELECT f.unvan, i.baslik, i.bolumler, i.kisa_aciklama, \n"
                + "i.detay, i.kosullar, i.personel_sayisi, i.id, i.eklenme_tarihi, i.baslangic_tarihi, \n"
                + "i.bitis_tarihi, i.durum, i.izlenme, f.logo\n"
                + "FROM ilanlar i LEFT JOIN firmalar f ON i.firma_id = f.id where i.id = '" + IlanAramaFXMLController.ilanID + "'";
        try {
            rs = baglan().executeQuery(sorgu);
            rs.next();
            firmaAdi.setText(rs.getString("unvan"));
            ilanBaslik.setText(rs.getString("baslik"));
            bolum.setText(rs.getString("bolumler"));
            ilanKisaAciklama.setText(rs.getString("kisa_aciklama"));
            ilanDetay.setText(rs.getString("detay"));
            ilanKosul.setText(rs.getString("kosullar"));
            izlenme.setText(String.valueOf(rs.getInt("izlenme")));
            personelSayisi.setText(String.valueOf(rs.getInt("personel_sayisi")));
            ilanNo.setText(String.valueOf(rs.getInt("id")));
            ilanEklenmeTar.setText(String.valueOf(new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("eklenme_tarihi"))));
            ilanBaslamaTar.setText(String.valueOf(new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("baslangic_tarihi"))));
            ilanBitisTar.setText(String.valueOf(new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("bitis_tarihi"))));
            secimId = String.valueOf(rs.getInt("id"));
            basvuruDurum = String.valueOf(rs.getInt("durum"));
            if (rs.getInt("durum") == 0) {
                ilanDurum.setStyle("-fx-text-inner-color: red;");
                lblIlanBasvuruDurum.setTextFill(Color.RED);
                ilanDurum.setText("İlan Başvuruya Kapatılmıştır");
            } else {
                ilanDurum.setStyle(null);
                lblIlanBasvuruDurum.setTextFill(Color.BLACK);
                ilanDurum.setText("Başvurulabilir");
            }
            izlenme.setText(String.valueOf(rs.getInt("izlenme")));

            String resimAdi = rs.getString("logo");
            Image image = new Image("file:" + resimAdi);
            resim.setImage(image);
//            labele resim ekleme için
//            resimLabel.setGraphic(new ImageView(image));
        } catch (Exception e) {
            System.err.println("Bilgi getirme hatası : " + e);
        }
    }

    @FXML
    public void basvuruTamamla() {

        if (basvuruDurum.equals("1")) {
            String sql = "INSERT INTO basvurular VALUES (1, 1, 2, '" + secimId + "', GETDATE())";
            try {
                int durum = baglan().executeUpdate(sql);
                if (durum > 0) {
                    Alert uyari = new Alert(Alert.AlertType.INFORMATION);
                    uyari.setTitle("Başvuru Bildiri Uyarı");
                    uyari.setHeaderText("Başvuru Tamamlanma");
                    uyari.setContentText(secimId + " Nolu İlana Başvurunuz Başarılı Bir Şekilde Tamamlanmıştır.");
                    uyari.show();
                } else {
                    System.out.println("SQL Yazma hatası (başvurular tablosuna)");
                }
            } catch (Exception e) {
                System.err.println("SQL Yazma Hatası : " + e);
            }
        } else {
            Alert uyari = new Alert(Alert.AlertType.WARNING);
            uyari.setTitle("Başvuru Bildiri Uyarı");
            uyari.setHeaderText("UYARI!");
            uyari.setContentText(secimId + " Nolu İlan Başvuruya Kapatılmıştır.");
            uyari.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bilgiler();

    }

}
