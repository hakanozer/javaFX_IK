package javafx_ik.FirmaBolumu;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcons;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
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
    private VBox VBox2;
    
    @FXML
    private HBox HBox1;
    
    @FXML
    private HBox HBox2;

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
        
        ilanGöster();
    }

    @FXML
    private void ilanEkle() {

        PaneCenter.getChildren().clear();
        GridPane page = new GridPane();
        page.setPrefSize(335, 375);
        page.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        page.setHgap(10);
        page.setVgap(10);

  
        Label lblBaslik = new Label();
        TextField bolumler = new TextField();
        TextField baslik = new TextField();
        TextField kisaAciklama = new TextField();
        TextField kosullar = new TextField();
        TextField personelSayisi = new TextField();
        TextArea detay = new TextArea();
        DatePicker baslangicTarihi = new DatePicker();
        DatePicker bitisTarihi = new DatePicker();

        Button btnkaydet = new Button();
        btnkaydet.setText("Kaydet");
        Button btniptal = new Button();
        btniptal.setText("İptal");
        
        btnkaydet.setOnAction(new EventHandler<javafx.event.ActionEvent>() {

            @Override
            public void handle(javafx.event.ActionEvent event) {
                FirmaYonetimi kaydet = new FirmaYonetimi();
                kaydet.ilanEkle(bolumler.getText(), baslik.getText(), kisaAciklama.getText(), detay.getText(), kosullar.getText(), personelSayisi.getText(), baslangicTarihi.getValue(), bitisTarihi.getValue());
            }
        });
        
        btniptal.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                ilanSil();
            }
        });
       

        lblBaslik.setText("İlan Ekleme Bölümü");
        bolumler.setPromptText("Bölüm");
        baslik.setPromptText("Başlık");
        kisaAciklama.setPromptText("Kısa Açıklama");
        kosullar.setPromptText("Koşullar");
        personelSayisi.setPromptText("Personel Sayisi");
        detay.setPromptText("Detaylar");
        baslangicTarihi.setPromptText("Başlangıç Tarihi");
        bitisTarihi.setPromptText("Bitiş Tarihi");

        page.add(lblBaslik, 0, 0);
        page.add(bolumler, 0, 1);
        page.add(baslik, 1, 1);
        page.add(kisaAciklama, 0, 2);
        page.add(kosullar, 1, 2);
        page.add(personelSayisi, 0, 3);
        page.add(baslangicTarihi, 0, 4);
        page.add(bitisTarihi, 1, 4);
        page.add(detay, 0, 5);
        page.add(btnkaydet, 0, 6);
        page.add(btniptal, 1, 6);

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
        
        Label anaBaslik = new Label();
        anaBaslik.setText("Başlık");
        anaBaslik.setPrefSize(85, 40);
        
        Label anaizlenme = new Label();
        anaizlenme.setText("İzlenme");
        anaizlenme.setPrefSize(70, 40);

        HBox1.getChildren().addAll(anaBaslik,anaizlenme);
        
        Label anaBolum = new Label();
        anaBolum.setText("Bölüm");
        anaBolum.setPrefSize(70, 40);
        
        Label anaPerSay = new Label();
        anaPerSay.setText("Personel S.");
        anaPerSay.setPrefSize(50, 40);
        
        Label anaBasTar = new Label();
        anaBasTar.setText("Başlangıç Tarih");
        anaBasTar.setPrefSize(100, 40);
        
        Label anaBitTar = new Label();
        anaBitTar.setText("Bitiş Tarihi");
        anaBitTar.setPrefSize(100, 40);
        
        HBox2.getChildren().addAll(anaBolum, anaPerSay, anaBasTar, anaBitTar);
        
        
        FirmaYonetimi ilanGetir = new FirmaYonetimi();
        ArrayList<Object> ilanlar;

        ilanlar = ilanGetir.ilanlarıGetir();
        
        int butonSayisi = ilanlar.size();
        Button[] buttons = new Button[butonSayisi];

        int i = 0;
        for (Object ilanlar1 : ilanlar) {
            HashMap<String,String> ilanlarMap =(HashMap<String,String>) ilanlar1;
            

            buttons[i] = new Button("*");
            buttons[i].setPrefSize(30, 30);
            buttons[i].setMinSize(30, 30);
            
            buttons[i].setOnAction(new EventHandler<javafx.event.ActionEvent>() {
                @Override
                public void handle(javafx.event.ActionEvent event) {
                    ilanGuncelleme(ilanlarMap);
                }
            });
            
            HBox ilanHBox = new HBox(5);
            ilanHBox.setPrefSize(170, 40);
            ilanHBox.setAlignment(Pos.CENTER_LEFT);

            Label ilanBaslik = new Label();
            ilanBaslik.setText(ilanlarMap.get("baslik"));
            ilanBaslik.setPrefSize(120, 40);
            
            Label ilanizlenme = new Label();
            ilanizlenme.setText(ilanlarMap.get("izlenme"));
            ilanizlenme.setPrefSize(20, 40);

            ilanHBox.getChildren().addAll(buttons[i], ilanBaslik, ilanizlenme);
            VBox1.getChildren().add(ilanHBox);
            
            HBox ilanHBox2 = new HBox(5);
            ilanHBox.setPrefSize(400, 40);
            ilanHBox.setAlignment(Pos.CENTER_LEFT);
            
            Label ilanBolum = new Label();
            ilanBolum.setText(ilanlarMap.get("bolumler"));
            ilanBolum.setPrefSize(100, 40);
            
            Label ilanPersonelSayisi = new Label();
            ilanPersonelSayisi.setText(ilanlarMap.get("personel_sayisi"));
            ilanPersonelSayisi.setPrefSize(20, 40);
            
            Label ilanBasTar = new Label();
            ilanBasTar.setText(ilanlarMap.get("baslangic_tarihi"));
            ilanBasTar.setPrefSize(100, 40);
            
            Label ilanBitTar = new Label();
            ilanBitTar.setText(ilanlarMap.get("bitis_tarihi"));
            ilanBitTar.setPrefSize(100, 40);
            
            ilanHBox2.getChildren().addAll(ilanBolum, ilanPersonelSayisi, ilanBasTar, ilanBitTar);
            VBox2.getChildren().add(ilanHBox2);
            
            
            i++;
        }
        
        
    }
    
    
     private void ilanGuncelleme(HashMap bilgi){
        PaneCenter.getChildren().clear();
        GridPane page = new GridPane();
        page.setPrefSize(321, 351);
        page.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        page.setHgap(10);
        page.setVgap(10);

  

        
        Label lblBaslik = new Label();
        TextField bolumler = new TextField();
        TextField baslik = new TextField();
        TextField kisaAciklama = new TextField();
        TextField kosullar = new TextField();
        TextField personelSayisi = new TextField();
        TextArea detay = new TextArea();
        DatePicker baslangicTarihi = new DatePicker();
        DatePicker bitisTarihi = new DatePicker();
        
        bolumler.setText((String) bilgi.get("bolumler"));
        baslik.setText((String) bilgi.get("baslik"));
        kisaAciklama.setText((String) bilgi.get("kisa_aciklama"));
        kosullar.setText((String) bilgi.get("kosullar"));
        personelSayisi.setText((String) bilgi.get("personel_sayisi"));
        detay.setText((String) bilgi.get("detay"));
        baslangicTarihi.setValue(LocalDate.now());
        bitisTarihi.setValue(LocalDate.now());

        Button btnGuncelle = new Button();
        btnGuncelle.setText("Güncelle");
        Button btniptal = new Button();
        btniptal.setText("İptal");
        
        

        btnGuncelle.setOnAction(new EventHandler<javafx.event.ActionEvent>() {

            @Override
            public void handle(javafx.event.ActionEvent event) {
                FirmaYonetimi btnGuncelle = new FirmaYonetimi();
                btnGuncelle.ilanGuncelle((String) bilgi.get("id"),bolumler.getText(), baslik.getText(), kisaAciklama.getText(), detay.getText(), kosullar.getText(), personelSayisi.getText(), baslangicTarihi.getValue(), bitisTarihi.getValue());
            }
        });
        
        btniptal.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                ilanSil();
            }
        });
       

        lblBaslik.setText("İlan Ekleme Bölümü");
        bolumler.setPromptText("Bölüm");
        baslik.setPromptText("Başlık");
        kisaAciklama.setPromptText("Kısa Açıklama");
        kosullar.setPromptText("Koşullar");
        personelSayisi.setPromptText("Personel Sayisi");
        detay.setPromptText("Detaylar");
        baslangicTarihi.setPromptText("Başlangıç Tarihi");
        bitisTarihi.setPromptText("Bitiş Tarihi");

        page.add(lblBaslik, 0, 0);
        page.add(bolumler, 0, 1);
        page.add(baslik, 1, 1);
        page.add(kisaAciklama, 0, 2);
        page.add(kosullar, 1, 2);
        page.add(personelSayisi, 0, 3);
        page.add(baslangicTarihi, 0, 4);
        page.add(bitisTarihi, 1, 4);
        page.add(detay, 0, 5);
        page.add(btnGuncelle, 0, 6);
        page.add(btniptal, 1, 6);

        ColumnConstraints col1Constraints = new ColumnConstraints();
        col1Constraints.setPercentWidth(100);

        ColumnConstraints col2Constraints = new ColumnConstraints();
        col2Constraints.setPercentWidth(100);

        page.getColumnConstraints().addAll(col1Constraints, col2Constraints);

        PaneCenter.getChildren().addAll(page);
    }
    
            
}
