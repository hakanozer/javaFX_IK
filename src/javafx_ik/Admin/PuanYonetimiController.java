/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_ik.Admin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx_ik.Kullanicilar.Kisiler;

/**
 * FXML Controller class
 *
 * @author Java1
 */
public class PuanYonetimiController extends Kisiler implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    TextField puann;

    @FXML
    public void puanGuncelle() {
        try {
            int durum = baglan().executeUpdate("update puanlama SET puan_degeri ='" + puann.getText() + "' WHERE id=1 ");
            kapat();
        } catch (Exception e) {
            System.err.println("Puanlama hatası : " + e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
