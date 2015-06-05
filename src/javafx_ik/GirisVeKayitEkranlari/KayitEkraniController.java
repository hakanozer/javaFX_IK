package javafx_ik.GirisVeKayitEkranlari;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx_ik.Hata;
import javafx_ik.Kullanicilar.Kisiler;

public class KayitEkraniController extends Kisiler implements Initializable, Hata {

    public void choices() {

        seviyeSec.getItems().addAll("Admin", "İK Uzmanı", "Firma", "Personel");
    }

    @FXML
    private TextField kadi;
    @FXML
    private PasswordField parola;
    @FXML
    private Button btnKaydet;
    @FXML
    private Label label;
    @FXML
    private ChoiceBox seviyeSec;

    @FXML
    private void handleButtonAction(ActionEvent event) {

        if (!Hata.hataDenetle(kadi) && !Hata.hataDenetle(parola) && !seviyeSec.getSelectionModel().isEmpty()) {
            String pass = parola.getText();
            String user = kadi.getText();
            int seviye = 0;
            if (seviyeSec.getSelectionModel().getSelectedIndex() == 0) {
                seviye = 0;
            } else if (seviyeSec.getSelectionModel().getSelectedIndex() == 1) {
                seviye = 1;
            } else if (seviyeSec.getSelectionModel().getSelectedIndex() == 2) {
                seviye = 2;
            } else if (seviyeSec.getSelectionModel().getSelectedIndex() == 3) {
                seviye = 3;
            }

            if (user.equals("") || pass.equals("")) {
                label.setText("Boş Alan Bırakmayın!");
            } else {

                if (kayitOl(user, md5Olustur(pass), seviye)) {
                    // kayıt başarılı ise
                    // kaydı yapan kişinin kendi sayfası devam edecek
                }

            }
        }
        if (seviyeSec.getSelectionModel().isEmpty()) {
            Alert uyari = new Alert(Alert.AlertType.ERROR);
            uyari.setTitle("Uyarı");
            uyari.setHeaderText("Hata");
            uyari.setContentText("Seviye seçiniz!");
            uyari.show();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choices(); // ChoiceBox dolduruluyor.
        kadi.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.ENTER) {
                handleButtonAction(null);
            }
        });
        parola.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.ENTER) {
                handleButtonAction(null);
            }
        });
    }

}
