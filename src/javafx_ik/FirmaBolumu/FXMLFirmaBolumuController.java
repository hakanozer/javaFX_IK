package javafx_ik.FirmaBolumu;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcons;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx_ik.FirmaBolumu.SplitPaneDividerSlider;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx_ik.Admin.Bolumler;
import javax.swing.JButton;

public class FXMLFirmaBolumuController implements Initializable {

    @FXML
    private ToggleButton bottomToggleButton;

    @FXML
    private SplitPane centerSplitPane;

    @FXML
    private ToggleButton leftToggleButton;

    @FXML
    private SplitPane mainSplitPane;

    @FXML
    private ToggleButton rightToggleButton;

    @FXML
    private ToggleButton topToggleButton;

    @FXML
    private VBox VBox1;

    @FXML
    private AnchorPane PaneCenter;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SplitPaneDividerSlider leftSplitPaneDividerSlider = new SplitPaneDividerSlider(centerSplitPane, 0, SplitPaneDividerSlider.Direction.LEFT);
        SplitPaneDividerSlider rightSplitPaneDividerSlider = new SplitPaneDividerSlider(centerSplitPane, 1, SplitPaneDividerSlider.Direction.RIGHT);
        SplitPaneDividerSlider topSplitPaneDividerSlider = new SplitPaneDividerSlider(mainSplitPane, 0, SplitPaneDividerSlider.Direction.UP);
        SplitPaneDividerSlider bottomSplitPaneDividerSlider = new SplitPaneDividerSlider(mainSplitPane, 1, SplitPaneDividerSlider.Direction.DOWN);

        leftToggleButton.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) -> {
            leftSplitPaneDividerSlider.setAimContentVisible(t1);
        });
        rightToggleButton.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) -> {
            rightSplitPaneDividerSlider.setAimContentVisible(t1);
        });
        topToggleButton.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) -> {
            topSplitPaneDividerSlider.setAimContentVisible(t1);
        });
        bottomToggleButton.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) -> {
            bottomSplitPaneDividerSlider.setAimContentVisible(t1);
        });

        GlyphsDude.setIcon(leftToggleButton, FontAwesomeIcons.TOGGLE_LEFT, "2em");
        GlyphsDude.setIcon(rightToggleButton, FontAwesomeIcons.TOGGLE_RIGHT, "2em");
        GlyphsDude.setIcon(topToggleButton, FontAwesomeIcons.TOGGLE_UP, "2em");
        GlyphsDude.setIcon(bottomToggleButton, FontAwesomeIcons.TOGGLE_DOWN, "2em");

        leftToggleButton.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) -> {
            if (t1) {
                GlyphsDude.setIcon(leftToggleButton, FontAwesomeIcons.TOGGLE_LEFT, "2em");
            } else {
                GlyphsDude.setIcon(leftToggleButton, FontAwesomeIcons.TOGGLE_RIGHT, "2.5em");
            }
        });

        rightToggleButton.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) -> {
            if (t1) {
                GlyphsDude.setIcon(rightToggleButton, FontAwesomeIcons.TOGGLE_RIGHT, "2em");
            } else {
                GlyphsDude.setIcon(rightToggleButton, FontAwesomeIcons.TOGGLE_LEFT, "2.5em");
            }
        });

        topToggleButton.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) -> {
            if (t1) {
                GlyphsDude.setIcon(topToggleButton, FontAwesomeIcons.TOGGLE_UP, "2em");
            } else {
                GlyphsDude.setIcon(topToggleButton, FontAwesomeIcons.TOGGLE_DOWN, "2.5em");
            }
        });

        bottomToggleButton.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) -> {
            if (t1) {
                GlyphsDude.setIcon(bottomToggleButton, FontAwesomeIcons.TOGGLE_DOWN, "2em");
            } else {
                GlyphsDude.setIcon(bottomToggleButton, FontAwesomeIcons.TOGGLE_UP, "2.5em");
            }
        });
    }

    @FXML
    private void ilanEkle() {

        PaneCenter.getChildren().clear();
        GridPane page = new GridPane();
        page.setPrefSize(335, 375);
        page.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        page.setHgap(10);
        page.setVgap(10);

  

        TextField bolumler = new TextField();
        TextField baslik = new TextField();
        TextField kisaAciklama = new TextField();
        TextField kosullar = new TextField();
        TextField personelSayisi = new TextField();
        TextArea detay = new TextArea();
        DatePicker baslangicTarihi = new DatePicker();
        DatePicker bitisTarihi = new DatePicker();
        DatePicker eklenmeTarihi = new DatePicker();
        Button btnkaydet = new Button();
        Button btniptal = new Button();
        
        btnkaydet.setOnAction(new EventHandler<javafx.event.ActionEvent>() {

            @Override
            public void handle(javafx.event.ActionEvent event) {
                FirmaYonetimi kaydet = new FirmaYonetimi();
                //kaydet.ilanEkle(bolumler.getText(), baslik.getText(), kisaAciklama.getText(), detay.getText(), kosullar.getText(), personelSayisi.getText(), baslangicTarihi.get, bitisTarihi.);
            }
        });
       

        eklenmeTarihi.setPromptText("İlanın eklenme Tarihi");
        bolumler.setPromptText("Bölüm");
        baslik.setPromptText("Başlık");
        kisaAciklama.setPromptText("Kısa Açıklama");
        kosullar.setPromptText("Koşullar");
        personelSayisi.setPromptText("Personel Sayisi");
        detay.setPromptText("Detaylar");
        baslangicTarihi.setPromptText("Başlangıç Tarihi");
        bitisTarihi.setPromptText("Bitiş Tarihi");

        page.add(eklenmeTarihi, 1, 0);
        page.add(bolumler, 0, 1);
        page.add(baslik, 1, 1);
        page.add(kisaAciklama, 0, 2);
        page.add(kosullar, 1, 2);
        page.add(personelSayisi, 0, 3);
        page.add(baslangicTarihi, 0, 4);
        page.add(bitisTarihi, 1, 4);
        page.add(detay, 0, 5);
        page.add(btnkaydet, 1, 6);
        page.add(btniptal, 0, 6);

        ColumnConstraints col1Constraints = new ColumnConstraints();
        col1Constraints.setPercentWidth(100);

        ColumnConstraints col2Constraints = new ColumnConstraints();
        col2Constraints.setPercentWidth(100);

        page.getColumnConstraints().addAll(col1Constraints, col2Constraints);

        PaneCenter.getChildren().addAll(page);
    }

    @FXML
    private void ilanSil() {
        PaneCenter.getChildren().clear();
    }

    private void ilanGöster() {
        FirmaYonetimi ilanGetir = new FirmaYonetimi();
        ArrayList<Object> ilanlar;

        ilanlar = ilanGetir.ilanlarıGetir();
        
        int butonSayisi = ilanlar.size();
        Button[] buttons = new Button[butonSayisi];

        int i = 0;
        for (Object ilanlar1 : ilanlar) {
            HashMap<String,String> ilanlarMap =(HashMap<String,String>) ilanlar1;
            HBox ilanHBox = new HBox(5);
            ilanHBox.setPrefSize(170, 40);
            ilanHBox.setAlignment(Pos.CENTER_LEFT);

            buttons[i] = new Button("*");
            buttons[i].setPrefSize(30, 30);
            buttons[i].setMinSize(30, 30);
            
            buttons[i].setOnAction(new EventHandler<javafx.event.ActionEvent>() {
                @Override
                public void handle(javafx.event.ActionEvent event) {
                    ilanGöstermeSayfasi(ilanlarMap);
                }
            });

            Label ilanBaslik = new Label();
            ilanBaslik.setText(ilanlarMap.get("baslik"));
            ilanBaslik.setPrefSize(140, 40);

            ilanHBox.getChildren().addAll(buttons[i], ilanBaslik);
            VBox1.getChildren().add(ilanHBox);
        }

        HBox ilanHBox = new HBox(5);
        ilanHBox.setPrefSize(170, 40);
        ilanHBox.setAlignment(Pos.CENTER_LEFT);

        Button ilanButton = new Button();
        ilanButton.setPrefSize(30, 30);
        ilanButton.setMinSize(30, 30);

        Label ilanLabel = new Label();
        ilanLabel.setText("gjhbkjkghyufytftrdtlllllllllllllllllll");
        ilanLabel.setPrefSize(140, 40);

        ilanHBox.getChildren().addAll(ilanButton, ilanLabel);
        VBox1.getChildren().add(ilanHBox);

    }
    
    private void ilanGöstermeSayfasi(HashMap bilgi){
        PaneCenter.getChildren().clear();
        GridPane page = new GridPane();
        page.setPrefSize(335, 375);
        page.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        page.setHgap(10);
        page.setVgap(10);

        TextField bolumler = new TextField();
        TextField baslik = new TextField();
        TextField kisaAciklama = new TextField();
        TextField kosullar = new TextField();
        TextField personelSayisi = new TextField();
        TextArea detay = new TextArea();
        DatePicker baslangicTarihi = new DatePicker();
        DatePicker bitisTarihi = new DatePicker();
        DatePicker eklenmeTarihi = new DatePicker();

        //eklenmeTarihi.set
        bolumler.setText((String) bilgi.get("bolumler"));
        baslik.setText((String) bilgi.get("baslik"));
        kisaAciklama.setText((String) bilgi.get("kisa_aciklama"));
        kosullar.setText((String) bilgi.get("kosullar"));
        personelSayisi.setText((String) bilgi.get("personel_sayisi"));
        detay.setText((String) bilgi.get("detay"));
        //baslangicTarihi.setPromptText("Başlangıç Tarihi");
        //bitisTarihi.setPromptText("Bitiş Tarihi");

        page.add(eklenmeTarihi, 1, 0);
        page.add(bolumler, 0, 1);
        page.add(baslik, 1, 1);
        page.add(kisaAciklama, 0, 2);
        page.add(kosullar, 1, 2);
        page.add(personelSayisi, 0, 3);
        page.add(baslangicTarihi, 0, 4);
        page.add(bitisTarihi, 1, 4);
        page.add(detay, 0, 5);

        ColumnConstraints col1Constraints = new ColumnConstraints();
        col1Constraints.setPercentWidth(100);

        ColumnConstraints col2Constraints = new ColumnConstraints();
        col2Constraints.setPercentWidth(100);

        page.getColumnConstraints().addAll(col1Constraints, col2Constraints);

        PaneCenter.getChildren().addAll(page);
    }
    
            
}
