package javafx_ik.Kullanicilar;

import java.sql.ResultSet;
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

    public int[] girisYap(String kul_adi, String kul_sifre) {
        // girişyap kul_adi
        int sevID[] = new int[2];
        try {
            ResultSet rs = baglan().executeQuery("SELECT *FROM kisiler WHERE kul_adi='" + kul_adi + "' AND kul_sifre ='" + kul_sifre + "'");
            if (rs.next()) {
                System.out.println("Giriş Başarılı!");
                sevID[0] = rs.getInt("seviye");
                sevID[1] = rs.getInt("profil_id");

            }
        } catch (Exception e) {
            System.err.println("Giriş Yapılamadı : " + e);
        }
        return sevID;
    }

}
