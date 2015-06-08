package javafx_ik.FirmaBolumu;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FirmaBolumu extends Application {

    

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLFirmaBolumu.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("shichimifx.css");

        stage.setTitle("Firma Bölümü");
        stage.setScene(scene);
        stage.show();
    }
    
    

}