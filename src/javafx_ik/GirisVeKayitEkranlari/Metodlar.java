/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_ik.GirisVeKayitEkranlari;

import java.security.MessageDigest;

/**
 *
 * @author Java1
 */
public class Metodlar {

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
}
