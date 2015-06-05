/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 * FXML Controller class
 *
 * @author java-1
 */
public class IK_BolumuController implements Initializable {

    msDB db = new msDB();
    ObservableList<ObservableList> data;

    @FXML
    private TableView table;
    @FXML
    private TextField txtArama;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DataGetir("personel");
    }

    public void DataGetir(String tabloAdi) {

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
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });
                table.getColumns().addAll(col);
            }

            // rows getirme
            while (rs.next()) {
                ObservableList<Object> row = FXCollections.observableArrayList();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(rs.getObject(i));
                }
                data.add(row);
            }
            table.setItems(data);

        } catch (Exception e) {

            System.err.println("Data Getirme Hatası : " + e);

        }

        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    }

    public void fncArama() {
        String search = txtArama.getText();
        for (ObservableList name : data) {
            if (name.contains(search)) {
                System.out.println(name);
            }
        }
    }

}
