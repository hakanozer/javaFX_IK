/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_ik.FirmaBolumu;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx_ik.msDB;

/**
 *
 * @author java-1
 */
public class FirmaYonetimi extends msDB {

    public ArrayList ilanlarıGetir() {

        ArrayList<Object> ilanListesi = new ArrayList<>();

        try {
            ResultSet rs;
            rs = baglan().executeQuery("SELECT * FROM ilanlar");

            while (rs.next()) {
                HashMap<String, String> ilanMap = new HashMap<>();
                ilanMap.put("id", rs.getString("id"));
                ilanMap.put("firma_id", rs.getString("firma_id"));
                ilanMap.put("bolumler", rs.getString("bolumler"));
                ilanMap.put("baslik", rs.getString("baslik"));
                ilanMap.put("kisa_aciklama", rs.getString("kisa_aciklama"));
                ilanMap.put("detay", rs.getString("detay"));
                ilanMap.put("kosullar", rs.getString("kosullar"));
                ilanMap.put("izlenme", rs.getString("izlenme"));
                ilanMap.put("personel_sayisi", rs.getString("personel_sayisi"));
                ilanMap.put("baslangic_tarihi", rs.getString("baslangic_tarihi"));
                ilanMap.put("bitis_tarihi", rs.getString("bitis_tarihi"));
                ilanListesi.add(ilanMap);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FirmaYonetimi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ilanListesi;
    }

    public void ilanEkle(String bolum, String baslik, String kisaAciklama, String kosullar, String personelSayisi, String detay, Date baslangicTarihi, Date bitisTarihi) {
        try {
            ResultSet rs = baglan().executeQuery("INSERT INTO ilanlar VALUES(1,'" + bolum + "','" + baslik + "','" + kisaAciklama + "','" + detay + "', '" + kosullar + "',null, '" + personelSayisi + "','" + baslangicTarihi + "','" + bitisTarihi + "',now(),null)");
        } catch (Exception e) {

        }
    }
}
