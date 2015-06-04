package javafx_ik.GirisVeKayitEkranlari;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx_ik.Admin.AdminPanelController;
import javafx_ik.Kullanicilar.Kisiler;

public class KayitEkraniController extends Kisiler implements Initializable {

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
    private AnchorPane kayitekrani;

    @FXML
    private void handleButtonAction(ActionEvent event) {
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choices(); // ChoiceBox dolduruluyor.

    }

}
