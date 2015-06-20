/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_ik.FirmaBolumu;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx_ik.msDB;

public class FirmaYonetimi extends msDB {
    
    private int firmaID = 1;
    
    

    public ArrayList ilanlarıGetir() {
        
        ArrayList<Object> ilanListesi = new ArrayList<>();

        try {
            ResultSet rs;
            rs = baglan().executeQuery("SELECT * FROM ilanlar WHERE firma_id = '"+firmaID+"'");

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

    public void ilanEkle(String bolum, String baslik, String kisaAciklama, String detay, String kosullar, String personelSayisi, LocalDate baslangicTarihi, LocalDate bitisTarihi) {
        try {
            int x = baglan().executeUpdate("INSERT INTO ilanlar (firma_id,bolumler,baslik,kisa_aciklama,detay,kosullar,izlenme,personel_sayisi,baslangic_tarihi,bitis_tarihi,eklenme_tarihi,durum) VALUES('"+firmaID+"','" + bolum + "','" + baslik + "','" + kisaAciklama + "','" + detay + "', '" + kosullar + "',0, '" + personelSayisi + "','" + baslangicTarihi + "','" + bitisTarihi + "',GETDATE(),0)");

            if (x > 0) {
                System.out.println("Kayıt Yapıldı.");
            } else {
                System.out.println("kayıt başarısız.");
            }
        } catch (Exception e) {
            System.err.println("hata : " + e);
        }
    }

    public void ilanGuncelle(String id,String bolum, String baslik, String kisaAciklama, String detay, String kosullar, String personelSayisi, LocalDate baslangicTarihi, LocalDate bitisTarihi) {
        try {
            int x = baglan().executeUpdate("UPDATE ilanlar SET bolumler='"+bolum+"', baslik='"+baslik+"', kisa_aciklama='"+kisaAciklama+"', detay='"+detay+"', kosullar='"+kosullar+"', personel_sayisi='"+personelSayisi+"', baslangic_tarihi='"+baslangicTarihi+"', bitis_tarihi='"+bitisTarihi+"' WHERE id='"+id+"' AND firma_id='"+firmaID+"'");

            if (x > 0) {
                System.out.println("Kayıt Yapıldı.");
            } else {
                System.out.println("kayıt başarısız.");
            }
        } catch (Exception e) {
            System.err.println("hata : " + e);
        }
    }

    public void setFirmaID(int firmaID) {
        this.firmaID = firmaID;
    }
    
    
}
