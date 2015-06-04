package javafx_ik.Kullanicilar;

import java.sql.ResultSet;
import javafx_ik.msDB;

public abstract class Kisiler extends msDB {

    public void kayitOl(String kul_adi, String kul_sifre, int seviye) {
        // kayıt kul_adi ve şifre ile
        try {

            int durum = baglan().executeUpdate("INSERT INTO kisiler values ('" + kul_adi + "', '" + kul_sifre + "', '" + seviye + "', null)");
            if (durum > 0) {
                if (seviye == 1) {
                    ResultSet rs = baglan().executeQuery("(SELECT id FROM ik_uzmani WHERE id = (SELECT MAX(id) FROM ik_uzmani))");
                    if (rs.next()) {
                        int profil = rs.getInt("id");
                        System.out.println(profil);
                        int durumProfil = baglan().executeUpdate("UPDATE kisiler SET profil_id = '" + profil + "' WHERE id = (SELECT MAX(id) FROM kisiler)");
                    }
                } else if (seviye == 2) {
                    ResultSet rs = baglan().executeQuery("(SELECT id FROM firmalar WHERE id = (SELECT MAX(id) FROM firmalar))");
                    if (rs.next()) {
                        int profil = rs.getInt("id");
                        System.out.println(profil);
                        int durumProfil = baglan().executeUpdate("UPDATE kisiler SET profil_id = '" + profil + "' WHERE id = (SELECT MAX(id) FROM kisiler)");
                    }
                } else if (seviye == 3) {
                    ResultSet rs = baglan().executeQuery("(SELECT id FROM personel WHERE id = (SELECT MAX(id) FROM personel))");
                    if (rs.next()) {
                        int profil = rs.getInt("id");
                        System.out.println(profil);
                        int durumProfil = baglan().executeUpdate("UPDATE kisiler SET profil_id = '" + profil + "' WHERE id = (SELECT MAX(id) FROM kisiler)");
                    }
                } else {
                    System.out.println("ADMIN kayıt!");
                }
            }
        } catch (Exception e) {
            System.err.println("Kayıt Hatası : " + e);
        }
    }

    public void girisYap(String kul_adi, String kul_sifre) {
        // girişyap kul_adi
        try {
            ResultSet rs = baglan().executeQuery("SELECT *FROM kisiler WHERE kul_adi='" + kul_adi + "' AND kul_sifre ='" + kul_sifre + "'");
            if (rs.next()) {
                System.out.println("Giriş Başarılı!");
            }
        } catch (Exception e) {
            System.err.println("Giriş Yapılamadı : " + e);
        }
    }

}
