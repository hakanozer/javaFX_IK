package javafx_ik.Admin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx_ik.Bolumu.DynamicTable;
import javafx_ik.Bolumu.FirmaYonetimi;
import javafx_ik.GirisVeKayitEkranlari.KayitEkraniController;

public class AdminPanelController implements Initializable {

    @FXML
    public void kayitEkrani() throws IOException {
        KayitEkraniController kay = new KayitEkraniController();
        Stage ns = new Stage();
        FXMLLoader ld = new FXMLLoader();
        Parent loader = ld.load(kay.getClass().getResource("KayitEkrani.fxml").openStream());
        Scene gec = new Scene(loader);
        ns.setScene(gec);
        ns.show();

    }

    @FXML
    public void firmaEkrani() throws IOException {
        FirmaYonetimi fy = new FirmaYonetimi();
        Stage ns = new Stage();
        FXMLLoader ld = new FXMLLoader();
        Parent loader = ld.load(fy.getClass().getResource("firmaYonetimi.fxml").openStream());
        Scene gec = new Scene(loader);
        ns.setScene(gec);
        ns.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
