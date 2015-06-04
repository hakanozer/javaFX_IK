package javafx_ik.GirisVeKayitEkranlari;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx_ik.Admin.AdminPanelController;
import javafx_ik.Kullanicilar.Kisiler;
import javafx_ik.FirmaBolumu.*;

public class GirisEkraniController extends Kisiler implements Initializable {

    Metodlar m = new Metodlar();
    @FXML
    TextField txtKuladi;
    @FXML
    PasswordField txtParola;

    @FXML
    public void girisYapEkran() throws IOException {
        String dizi[] = girisYap(txtKuladi.getText(), m.md5Olustur(txtParola.getText()));
        // aşağıdaki koşul gövdelerinde dizinin ikinci elemanına göre 
        // ilgili profil idsinin bilgilerine ulaşılacak
        String x = dizi[0];
        if ("0".equals(x)) {
            // admin ekranı
              AdminPanelController f = new AdminPanelController();
            Stage ns = new Stage();
            FXMLLoader ld = new FXMLLoader();
            Parent loader = ld.load(f.getClass().getResource("AdminPanel.fxml").openStream());
            Scene gec = new Scene(loader);
            ns.setScene(gec);
            ns.show();
        } else if ("1".equals(x)) {
            // İK uzman ekranı

        } else if ("2".equals(x)) {
            // ilgili birim penceresi açılıyor
            String profilID = dizi[1]; // giriş yapan firma
            FXMLFirmaBolumuController f = new FXMLFirmaBolumuController();
            Stage ns = new Stage();
            FXMLLoader ld = new FXMLLoader();
            Parent loader = ld.load(f.getClass().getResource("FXMLFirmaBolumu.fxml").openStream());
            Scene gec = new Scene(loader);
            ns.setScene(gec);
            ns.show();

            // firma ekranı
        } else if ("3".equals(x)) {
            // personel ekranı
        }
        // metottan dönen dizi değerlerine göre ekrana yönelecek
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
