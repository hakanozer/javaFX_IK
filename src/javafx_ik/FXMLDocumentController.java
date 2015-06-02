
package javafx_ik;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import static javax.swing.text.html.HTML.Tag.HEAD;


public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        System.out.println("Butona tıklayın");
<<<<<<< HEAD
      
        label.setText("Merhaba Dünya.");
        
        System.out.println("Bence tıklamayın");
        label.setText("Hello World!");
        
=======
<<<<<<< HEAD
        label.setText("Merhaba Dünya.");
=======
        System.out.println("Bence tıklamayın");
        label.setText("Hello World!");
>>>>>>> origin/master
>>>>>>> 734022c9acc3e39e243ab461b4ff2bbb4e2c999c
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
