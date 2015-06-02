
package javafx_ik;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;


public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
<<<<<<< HEAD
        System.out.println("Butona tıklayınız");
=======
        System.out.println("Butona tıklayın");
>>>>>>> origin/master

        label.setText("Merhaba Dünya.");

        System.out.println("Bence tıklamayın");
        label.setText("Hello World!");

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
