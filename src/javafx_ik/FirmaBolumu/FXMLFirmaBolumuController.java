package javafx_ik.FirmaBolumu;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcons;
import javafx_ik.FirmaBolumu.SplitPaneDividerSlider;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SplitPane;
import javafx.scene.control.ToggleButton;

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
}



///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package javafx_ik.FirmaBolumu;
//
//import java.net.URL;
//import java.util.ResourceBundle;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Label;
//
///**
// * FXML Controller class
// *
// * @author java-1
// */
//public class FXMLFirmaBolumuController implements Initializable {
//
//    @FXML
//    private Label label;
//
//    @FXML
//    private void handleButtonAction(ActionEvent event) {
//
//        System.out.println("Butona tıklayın");
//
//
//    }
//
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        // TODO
//    }
//
//}
