package javafx_ik.Admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx_ik.msDB;

public class Bolumler extends msDB {

    private int id;
    private String adi;
    private int alt_kat_id;

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public void setAlt_kat_id(int alt_kat_id) {
        this.alt_kat_id = alt_kat_id;
    }

    public int getId() {
        return id;
    }

    public String getAdi() {
        return adi;
    }

    public int getAlt_kat_id() {
        return alt_kat_id;
    }

    public void bolumEkle() {

        try {
            int durum = baglan().executeUpdate("INSERT INTO bolumler VALUES ('" + adi + "','" + alt_kat_id + "')");
        } catch (Exception e) {
            System.err.println("Bölüm eklenemedi : " + e);
        }

    }

    public ObservableList<Bolumler> bilgileriGetir() {

        ObservableList<Bolumler> bolumList = FXCollections.observableArrayList();
        try {
            baglan();
            ResultSet rs = baglan().executeQuery("SELECT *FROM bolumler");
            while (rs.next()) {
                bolumList.add(new Bolumler(rs.getInt("id"), rs.getString("adi"), rs.getInt("alt_kat_id")));
            }
            baglan().close();
        } catch (Exception e) {
            System.err.println("Data Getirme Hatası : " + e);
        }
        return bolumList;

    }

    public Bolumler(int id, String adi, int alt_kat_id) {
        this.id = id;
        this.adi = adi;
        this.alt_kat_id = alt_kat_id;
    }

    public Bolumler() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void BolumDuzenle() {

        try {
            int duzenleSonuc = baglan().executeUpdate("UPDATE bolumler SET adi ='" + adi + "', alt_kat_id = '" + alt_kat_id + "' WHERE id = '" + id + "'");
            if (duzenleSonuc > 0) {
                System.out.println("İşlem Doğru");
            } else {
                System.out.println("İşlem Hatalı");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Bolumler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void sil() {

        try {
            int durum = baglan().executeUpdate("DELETE FROM bolumler WHERE id = '" + id + "'");

        } catch (Exception e) {
            System.err.println("Silme Hatası : " + e);
        }
    }

}
