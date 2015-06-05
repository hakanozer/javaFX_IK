package javafx_ik.Bolumu;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import javafx_ik.msDB;

public class IK_BolumuController implements Initializable {

    msDB db = new msDB();
    ObservableList<ObservableList> data;

    @FXML
    private TableView table_firma, table_ilan, table_personel, table_puan, table_gorusme;
    @FXML
    private TextField txtFirma,txtIlan,txtPersonel,txtPuan,txtGorusme;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void firmaYonetimi() {
        DataGetir("kisiler", table_firma);
    }

    public void ilanYonetimi() {
        DataGetir("ilanlar", table_ilan);
    }

    public void personelYonetimi() {
        DataGetir("personel", table_personel);
    }

    public void puanYonetimi() {
        DataGetir("puanlama", table_puan);
    }

    public void gorusmeYonetimi() {
        DataGetir("gorusmeler", table_gorusme);
    }

    public void DataGetir(String tabloAdi, TableView model) {

        model.getItems().clear();
        model.getColumns().clear();
        data = FXCollections.observableArrayList();

        try {
            ResultSet rs = db.baglan().executeQuery("SELECT * FROM " + tabloAdi);
            ResultSetMetaData metaData = rs.getMetaData();

            // column oluşturma
            List<String> columns = new ArrayList<String>();
            int columnCount = metaData.getColumnCount();
            for (int column = 1; column <= columnCount; column++) {
                columns.add(metaData.getColumnName(column));
            }
            TableColumn[] tableColumns = new TableColumn[columns.size()];
            int columnIndex = 0;
            for (int i = 0; i < columns.size(); i++) {
                final int j = i;
                TableColumn col = new TableColumn(columns.get(i));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        String yaz;
                        try {
                            yaz = param.getValue().get(j).toString();
                        } catch (Exception e) {
                            yaz = "";
                        }

                        return new SimpleStringProperty(yaz);
                    }
                });
                model.getColumns().addAll(col);
            }

            // rows getirme
            while (rs.next()) {
                ObservableList<Object> row = FXCollections.observableArrayList();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(rs.getObject(i));
                }
                data.add(row);
            }
            model.setItems(data);

        } catch (Exception e) {

            System.err.println("Data Getirme Hatası : " + e);

        }

        model.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    }

    public void fncArama() {
        String search = txtFirma.getText();
        Aradatagetir("kisiler", table_firma, search);
    }
    
       public void Aradatagetir(String tabloAdi, TableView model, String ara) {
           
        model.getItems().clear();
        model.getColumns().clear();
        data = FXCollections.observableArrayList();

        try {
            ResultSet rs = db.baglan().executeQuery("SELECT * FROM " + tabloAdi+" where kul_adi like '%"+ara+"%' ");
            ResultSetMetaData metaData = rs.getMetaData();

            // column oluşturma
            List<String> columns = new ArrayList<String>();
            int columnCount = metaData.getColumnCount();
            for (int column = 1; column <= columnCount; column++) {
                columns.add(metaData.getColumnName(column));
            }
            TableColumn[] tableColumns = new TableColumn[columns.size()];
            int columnIndex = 0;
            for (int i = 0; i < columns.size(); i++) {
                final int j = i;
                TableColumn col = new TableColumn(columns.get(i));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        String yaz;
                        try {
                            yaz = param.getValue().get(j).toString();
                        } catch (Exception e) {
                            yaz = "";
                        }

                        return new SimpleStringProperty(yaz);
                    }
                });
                model.getColumns().addAll(col);
            }

            // rows getirme
            while (rs.next()) {
                ObservableList<Object> row = FXCollections.observableArrayList();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(rs.getObject(i));
                }
                data.add(row);
            }
            model.setItems(data);

        } catch (Exception e) {

            System.err.println("Data Getirme Hatası : " + e);

        }

        model.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    }

}
