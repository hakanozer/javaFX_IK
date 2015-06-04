/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_ik.Bolumu;

import java.util.Date;

public class Ilan {

    private int id;
    private int firma_id;
    private String bolumler;
    private String baslik;
    private String kisa_aciklama;
    private String detay;
    private String kosullar;
    private short izlenme;
    private byte personel_sayisi;
    private Date baslangic_tarihi;
    private Date bitis_tarihi;
    private Date eklenme_tarihi;
    private byte durum;

    public Ilan(int id, int firma_id, String bolumler, String baslik, String kisa_aciklama, String detay, String kosullar, short izlenme, byte personel_sayisi, Date baslangic_tarihi, Date bitis_tarihi, Date eklenme_tarihi, byte durum) {
        this.id = id;
        this.firma_id = firma_id;
        this.bolumler = bolumler;
        this.baslik = baslik;
        this.kisa_aciklama = kisa_aciklama;
        this.detay = detay;
        this.kosullar = kosullar;
        this.izlenme = izlenme;
        this.personel_sayisi = personel_sayisi;
        this.baslangic_tarihi = baslangic_tarihi;
        this.bitis_tarihi = bitis_tarihi;
        this.eklenme_tarihi = eklenme_tarihi;
        this.durum = durum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFirma_id() {
        return firma_id;
    }

    public void setFirma_id(int firma_id) {
        this.firma_id = firma_id;
    }

    public String getBolumler() {
        return bolumler;
    }

    public void setBolumler(String bolumler) {
        this.bolumler = bolumler;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getKisa_aciklama() {
        return kisa_aciklama;
    }

    public void setKisa_aciklama(String kisa_aciklama) {
        this.kisa_aciklama = kisa_aciklama;
    }

    public String getDetay() {
        return detay;
    }

    public void setDetay(String detay) {
        this.detay = detay;
    }

    public String getKosullar() {
        return kosullar;
    }

    public void setKosullar(String kosullar) {
        this.kosullar = kosullar;
    }

    public short getIzlenme() {
        return izlenme;
    }

    public void setIzlenme(short izlenme) {
        this.izlenme = izlenme;
    }

    public byte getPersonel_sayisi() {
        return personel_sayisi;
    }

    public void setPersonel_sayisi(byte personel_sayisi) {
        this.personel_sayisi = personel_sayisi;
    }

    public Date getBaslangic_tarihi() {
        return baslangic_tarihi;
    }

    public void setBaslangic_tarihi(Date baslangic_tarihi) {
        this.baslangic_tarihi = baslangic_tarihi;
    }

    public Date getBitis_tarihi() {
        return bitis_tarihi;
    }

    public void setBitis_tarihi(Date bitis_tarihi) {
        this.bitis_tarihi = bitis_tarihi;
    }

    public Date getEklenme_tarihi() {
        return eklenme_tarihi;
    }

    public void setEklenme_tarihi(Date eklenme_tarihi) {
        this.eklenme_tarihi = eklenme_tarihi;
    }

    public byte getDurum() {
        return durum;
    }

    public void setDurum(byte durum) {
        this.durum = durum;
    }

}
