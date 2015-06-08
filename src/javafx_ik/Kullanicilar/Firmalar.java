package javafx_ik.Kullanicilar;

public class Firmalar extends Kisiler{
   
    private int id;
    private int bolum_id;
    private String unvan;
    private String yetkili_adi;
    private String yetkili_soyadi;
    private String telefon;
    private String gsm;
    private String logo;
    private int puan;
    private String aciklama;
    private String web_adresi;
    private String mail;
    private String date;

  public Firmalar(int id, int bolum_id, String unvan, String yetkili_adi, String yetkili_soyadi, String telefon, String gsm, String logo, int puan, String aciklama, String web_adresi, String mail, String date) {
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
        this.date = date;
    }
  
  

// Sadece Firmalar'ı ilgilendiren metodlar...

    public int getId() {
        return id;
    }

    public int getBolum_id() {
        return bolum_id;
    }

    public String getUnvan() {
        return unvan;
    }

    public String getYetkili_adi() {
        return yetkili_adi;
    }

    public String getYetkili_soyadi() {
        return yetkili_soyadi;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getGsm() {
        return gsm;
    }

    public String getLogo() {
        return logo;
    }

    public int getPuan() {
        return puan;
    }

    public String getAciklama() {
        return aciklama;
    }

    public String getWeb_adresi() {
        return web_adresi;
    }

    public String getMail() {
        return mail;
    }

    public String getDate() {
        return date;
    }
   
}
