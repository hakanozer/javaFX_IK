package javafx_ik.Kullanicilar;

public abstract class Kisiler {
    private String kul_adi;
    private String kul_sifre;
    private int seviye;
    private int profil_id;

    public String getKul_adi() {
        return kul_adi;
    }

    public void setKul_adi(String kul_adi) {
        this.kul_adi = kul_adi;
    }

    public String getKul_sifre() {
        return kul_sifre;
    }

    public void setKul_sifre(String kul_sifre) {
        this.kul_sifre = kul_sifre;
    }

    public int getSeviye() {
        return seviye;
    }

    public void setSeviye(int seviye) {
        this.seviye = seviye;
    }

    public int getProfil_id() {
        return profil_id;
    }

    public void setProfil_id(int profil_id) {
        this.profil_id = profil_id;
    }
    
    
    
    public abstract void kayitOl();
    
    public abstract void girisYap();
    
    
}
