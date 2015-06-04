package javafx_ik.Admin;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class BolumYonetimiController extends Bolumler implements Initializable {

    @FXML
    TableView tableBolum;
    @FXML
    TableColumn c1, c2, c3;
    @FXML
    TextField txtBolum, txtUstKat;

    @FXML
    public void bolumEkleBtn() {
        setAdi(txtBolum.getText());
        setAlt_kat_id(Integer.valueOf(txtUstKat.getText()));
        bolumEkle();
        initialize(null, null);
        txtBolum.setText("");
        txtUstKat.setText("");
    }

    @FXML
    public void duzenle() throws SQLException {
        final Bolumler sinif = (Bolumler) tableBolum.getSelectionModel().getSelectedItem();
        setId(sinif.getId());
        setAdi(txtBolum.getText());
        setAlt_kat_id(Integer.valueOf(txtUstKat.getText()));
        BolumDuzenle();
        initialize(null, null);
        txtBolum.setText("");
        txtUstKat.setText("");

    }

    @FXML
    public void secimYap() {
        final Bolumler sinif = (Bolumler) tableBolum.getSelectionModel().getSelectedItem();
        setId(sinif.getId());
        bilgiGetir(getId() + "");
    }

    @FXML
    public void bilgiGetir(String id) {

        try {
            ResultSet rs = baglan().executeQuery("SELECT *FROM bolumler WHERE id = '" + id + "'");
            if (rs.next()) {

                txtBolum.setText(rs.getString("adi"));
                txtUstKat.setText(String.valueOf(rs.getInt("alt_kat_id")));

            }
        } catch (Exception e) {
            System.err.println("" + e);
        }
    }

    @FXML
    public void silButon() throws SQLException {
        final Bolumler sinif = (Bolumler) tableBolum.getSelectionModel().getSelectedItem();
        setId(sinif.getId());
        sil();
        initialize(null, null);
        txtBolum.setText("");
        txtUstKat.setText("");

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        c1.setCellValueFactory(new PropertyValueFactory<>("id"));
        c2.setCellValueFactory(new PropertyValueFactory<>("adi"));
        c3.setCellValueFactory(new PropertyValueFactory<>("alt_kat_id"));
        Bolumler b = new Bolumler();
        tableBolum.setItems(b.bilgileriGetir());

    }

}
