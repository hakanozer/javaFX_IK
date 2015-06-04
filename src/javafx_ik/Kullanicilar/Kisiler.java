package javafx_ik.Kullanicilar;

import java.io.IOException;
import java.security.MessageDigest;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx_ik.Admin.AdminPanelController;
import javafx_ik.GirisVeKayitEkranlari.KayitEkraniController;
import javafx_ik.msDB;

public abstract class Kisiler extends msDB {

    public boolean kayitOl(String kul_adi, String kul_sifre, int seviye) {
        // kayıt kul_adi ve şifre ile
        boolean sonuc = false;
        try {

            int durum = baglan().executeUpdate("INSERT INTO kisiler values ('" + kul_adi + "', '" + kul_sifre + "', '" + seviye + "', null)");
            if (durum > 0) {
                if (seviye == 1) {
                    ResultSet rs = baglan().executeQuery("(SELECT id FROM ik_uzmani WHERE id = (SELECT MAX(id) FROM ik_uzmani))");
                    if (rs.next()) {
                        int profil = rs.getInt("id");
                        System.out.println(profil);
                        int durumProfil = baglan().executeUpdate("UPDATE kisiler SET profil_id = '" + profil + "' WHERE id = (SELECT MAX(id) FROM kisiler)");
                        sonuc = durumProfil > 0 ? true : false;
                    }
                } else if (seviye == 2) {
                    ResultSet rs = baglan().executeQuery("(SELECT id FROM firmalar WHERE id = (SELECT MAX(id) FROM firmalar))");
                    if (rs.next()) {
                        int profil = rs.getInt("id");
                        System.out.println(profil);
                        int durumProfil = baglan().executeUpdate("UPDATE kisiler SET profil_id = '" + profil + "' WHERE id = (SELECT MAX(id) FROM kisiler)");
                        sonuc = durumProfil > 0 ? true : false;
                    }
                } else if (seviye == 3) {
                    ResultSet rs = baglan().executeQuery("(SELECT id FROM personel WHERE id = (SELECT MAX(id) FROM personel))");
                    if (rs.next()) {
                        int profil = rs.getInt("id");
                        System.out.println(profil);
                        int durumProfil = baglan().executeUpdate("UPDATE kisiler SET profil_id = '" + profil + "' WHERE id = (SELECT MAX(id) FROM kisiler)");
                        sonuc = durumProfil > 0 ? true : false;
                    }
                } else {
                    System.out.println("ADMIN kayıt!");
                }
            }
            System.out.println("Kayıt Başarılı");
            sonuc = true;
        } catch (Exception e) {
            System.err.println("Kayıt Hatası : " + e);
            sonuc = false;
        }

        return sonuc;

    }

    public String[] girisYap(String kul_adi, String kul_sifre) {
        // girişyap kul_adi
        String sevID[] = new String[2];
        try {
            ResultSet rs = baglan().executeQuery("SELECT *FROM kisiler WHERE kul_adi='" + kul_adi + "' AND kul_sifre ='" + kul_sifre + "'");
            if (rs.next()) {
                //Giriş yapan kullanıcının seviyesi ve profil_idsi alınarak diziye atanır.
                //Giriş yapan admin ise profil_idsi bulunmadığından kul_adi alınır.
                System.out.println("Giriş Başarılı!");
                sevID[0] = String.valueOf(rs.getInt("seviye"));
                if (rs.getInt("seviye") == 0) {
                    sevID[1] = rs.getString("kul_adi");
                } else {
                    sevID[1] = String.valueOf(rs.getInt("profil_id"));
                }
            }
        } catch (Exception e) {
            System.err.println("Giriş Yapılamadı : " + e);
        }
        return sevID;
    }

    public String md5Olustur(String pass) {

        StringBuffer sb32 = null;

        try {

            MessageDigest messageDigestNesnesi = MessageDigest.getInstance("MD5");
            messageDigestNesnesi.update(pass.getBytes());
            byte messageDigestDizisi[] = messageDigestNesnesi.digest();
            sb32 = new StringBuffer();

            for (int i = 0; i < messageDigestDizisi.length; i++) {
                sb32.append(Integer.toString((messageDigestDizisi[i] & 0xff) + 0x100, 16).substring(1));

            }
//           System.out.println("Parolanın Şifrelenmiş Hali:(32) " + sb32.toString());

        } catch (Exception e) {
            System.err.println("MD5 Oluşturma Hatası : " + e);
        }

        return sb32.toString();

    }

    public EventHandler geriDonus = new EventHandler() {

        @Override
        public void handle(Event event) {
            try {
                AdminPanelController adm = new AdminPanelController();
                Stage ns = new Stage();
                FXMLLoader ld = new FXMLLoader();
                Parent loader = ld.load(adm.getClass().getResource("AdminPanel.fxml").openStream());
                Scene gec = new Scene(loader);
                ns.setScene(gec);
                ns.show();
            } catch (IOException ex) {
                Logger.getLogger(KayitEkraniController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    };

}
