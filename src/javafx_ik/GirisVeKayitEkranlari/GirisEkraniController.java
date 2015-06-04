package javafx_ik.GirisVeKayitEkranlari;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx_ik.Kullanicilar.Kisiler;

public class GirisEkraniController extends Kisiler implements Initializable {
    
    Metodlar m = new Metodlar();
    @FXML
    TextField txtKuladi;
    @FXML
    PasswordField txtParola;
    
    @FXML
    public void girisYapEkran() {
        String dizi[] = girisYap(txtKuladi.getText(), m.md5Olustur(txtParola.getText()));
        // aşağıdaki koşul gövdelerinde dizinin ikinci elemanına göre 
        // ilgili profil idsinin bilgilerine ulaşılacak
        if (dizi[0] == "0") {
            // admin ekranı
        } else if (dizi[0] == "1") {
            // İK uzman ekranı
        } else if (dizi[0] == "2") {

            // firma ekranı
        } else if (dizi[0] == "3") {
            // personel ekranı
        }
        // metottan dönen dizi değerlerine göre ekrana yönelecek
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
}
