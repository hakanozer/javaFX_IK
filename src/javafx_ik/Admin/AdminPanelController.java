package javafx_ik.Admin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx_ik.Bolumu.IK_BolumuController;

//import javafx_ik.Bolumu.FirmaYonetimi;
import javafx_ik.GirisVeKayitEkranlari.KayitEkraniController;
import javafx_ik.Kullanicilar.Kisiler;

public class AdminPanelController extends Kisiler implements Initializable {

    @FXML
    Button btn1;

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
        Stage s = (Stage) btn1.getScene().getWindow();
        s.close();
    }

    @FXML
    public void IKekrani() throws IOException {
        Ik_ListeController kay = new Ik_ListeController();
        Stage ns = new Stage();
        FXMLLoader ld = new FXMLLoader();
        Parent loader = ld.load(kay.getClass().getResource("ik_Liste.fxml").openStream());
        Scene gec = new Scene(loader);
        ns.setScene(gec);
        ns.show();
        ns.setOnCloseRequest(geriDonus);
        Stage s = (Stage) btn1.getScene().getWindow();
        s.close();
    }

    @FXML
    public void kayitEkrani() throws IOException {
        KayitEkraniController kay = new KayitEkraniController();
        Stage ns = new Stage();
        FXMLLoader ld = new FXMLLoader();
        Parent loader = ld.load(kay.getClass().getResource("KayitEkrani.fxml").openStream());
        Scene gec = new Scene(loader);
        ns.setScene(gec);
        ns.show();
        ns.setOnCloseRequest(geriDonus);
        Stage s = (Stage) btn1.getScene().getWindow();
        s.close();

    }

    @FXML

    public void bolumYonet() throws IOException {
        BolumYonetimiController bol = new BolumYonetimiController();
        Stage ns = new Stage();
        FXMLLoader ld = new FXMLLoader();

        Parent loader = ld.load(bol.getClass().getResource("BolumYonetimi.fxml").openStream());
        Scene gec = new Scene(loader);
        ns.setScene(gec);
        ns.setOnCloseRequest(geriDonus);
        ns.show();
        Stage s = (Stage) btn1.getScene().getWindow();
        s.close();
    }
    /*   @FXML
     public void firmaEkrani() throws IOException {
     FirmaYonetimi fy = new FirmaYonetimi();
     Stage ns = new Stage();
     FXMLLoader ld = new FXMLLoader();
     Parent loader = ld.load(fy.getClass().getResource("firmaYonetimi.fxml").openStream());
     Scene gec = new Scene(loader);
     ns.setScene(gec);
     ns.show();
     }*/

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
