package javafx_ik;

import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public interface Hata {

    public static boolean boslukKontrol(String kontrol) {
        boolean boslukDurum = false;
        if (kontrol.equals("")) {
            boslukDurum = true;
        }
        return boslukDurum;
    }

    public static boolean hataDenetle(Object component) {
        boolean hata = true;
        if (component instanceof TextField) {
            TextField textField = (TextField) component;
            if (boslukKontrol(textField.getText().trim())) {
                textField.setStyle("-fx-border-color: red;");
                Alert uyari = new Alert(Alert.AlertType.ERROR);
                uyari.setTitle("Uyarı");
                uyari.setHeaderText("Hata");
                uyari.setContentText(textField.getPromptText() + " alanı boş olamaz ");
                textField.setText("");
                textField.requestFocus();
                uyari.show();
                hata = true;
            } else {
                textField.setStyle("");
                hata = false;
            }
        }

        if (component instanceof CheckBox) {
            CheckBox checkBox = (CheckBox) component;
            if (!checkBox.isSelected()) {
                checkBox.setStyle("-fx-border-color: red;");
                Alert uyari = new Alert(Alert.AlertType.ERROR);
                uyari.setTitle("Uyarı");
                uyari.setHeaderText("Hata");
                uyari.setContentText(checkBox.getText() + " işaretlenmelidir");
                checkBox.requestFocus();
                uyari.show();
                hata = true;
            } else {
                checkBox.setStyle("");
                hata = false;
            }
        }
        if (component instanceof RadioButton) {
            RadioButton radioButton = (RadioButton) component;
            if (!radioButton.isSelected()) {
                radioButton.setStyle("-fx-border-color: red;");
                Alert uyari = new Alert(Alert.AlertType.ERROR);
                uyari.setTitle("Uyarı");
                uyari.setHeaderText("Hata");
                uyari.setContentText(radioButton.getText() + " işaretlenmelidir ");
                uyari.show();
                hata = true;
            } else {
                radioButton.setStyle("");
                hata = false;
            }
        }

        if (component instanceof ComboBox) {
            ComboBox comboBox = (ComboBox) component;
            if (comboBox.getSelectionModel().isEmpty()) {
                comboBox.setStyle("-fx-border-color: red;");
                Alert uyari = new Alert(Alert.AlertType.ERROR);
                uyari.setTitle("Uyarı");
                uyari.setHeaderText("Hata");
                uyari.setContentText(comboBox.getPromptText() + " alanı seçilmelidir ");
                uyari.show();
                hata = true;
            } else {
                comboBox.setStyle("");
                hata = false;
            }
        }
        return hata;
    }
}
