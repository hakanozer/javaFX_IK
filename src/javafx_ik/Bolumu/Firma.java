/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_ik.Bolumu;

import java.util.Date;

public class Firma {

    private int id;
    private String bolum_id;
    private String unvan;
    private String yetkili_adi;
    private String yetkili_soyadi;
    private String telefon;
    private String gsm;
    private String logo;
    private byte puan;
    private String aciklama;
    private String web_adresi;
    private String mail;
    private Date tarih;

    public Firma(int id, String bolum_id, String unvan, String yetkili_adi, String yetkili_soyadi, String telefon, String gsm, String logo, byte puan, String aciklama, String web_adresi, String mail, Date tarih) {
        this.id = id;
        this.bolum_id = bolum_id;
        this.unvan = unvan;
        this.yetkili_adi = yetkili_adi;
        this.yetkili_soyadi = yetkili_soyadi;
        this.telefon = telefon;
        this.gsm = gsm;
        this.logo = logo;
        this.puan = puan;
        this.aciklama = aciklama;
        this.web_adresi = web_adresi;
        this.mail = mail;
        this.tarih = tarih;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBolum_id() {
        return bolum_id;
    }

    public void setBolum_id(String bolum_id) {
        this.bolum_id = bolum_id;
    }

    public String getUnvan() {
        return unvan;
    }

    public void setUnvan(String unvan) {
        this.unvan = unvan;
    }

    public String getYetkili_adi() {
        return yetkili_adi;
    }

    public void setYetkili_adi(String yetkili_adi) {
        this.yetkili_adi = yetkili_adi;
    }

    public String getYetkili_soyadi() {
        return yetkili_soyadi;
    }

    public void setYetkili_soyadi(String yetkili_soyadi) {
        this.yetkili_soyadi = yetkili_soyadi;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getGsm() {
        return gsm;
    }

    public void setGsm(String gsm) {
        this.gsm = gsm;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public byte getPuan() {
        return puan;
    }

    public void setPuan(byte puan) {
        this.puan = puan;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getWeb_adresi() {
        return web_adresi;
    }

    public void setWeb_adresi(String web_adresi) {
        this.web_adresi = web_adresi;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

}
