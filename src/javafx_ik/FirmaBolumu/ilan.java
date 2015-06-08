/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_ik.FirmaBolumu;

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
public class ilan extends msDB {
    
    
    private ArrayList ilanlarıGetir(){
        
        ArrayList<Object> ilanListesi = new ArrayList<>();
        
        try {
            ResultSet rs;
            rs = baglan().executeQuery("SELECT * FROM ilanlar");
            
            while (rs.next()) {                
                HashMap<String,String> ilanMap = new HashMap<>();
                ilanMap.put("bolum", rs.getString("bolumler"));
                ilanMap.put("baslik", rs.getString("baslik"));
                ilanMap.put("kisa_aciklama", rs.getString("kisa_aciklama"));
                ilanMap.put("izlenme", rs.getString("izlenme"));
                ilanMap.put("personel_sayisi", rs.getString("personel_sayisi"));
                ilanListesi.add(ilanMap);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ilan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ilanListesi;
    }
    
    private void ilanEkle(){
        
    }
    
}
