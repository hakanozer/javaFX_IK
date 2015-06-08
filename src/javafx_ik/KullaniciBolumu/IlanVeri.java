/*
 Akın Çandır
 */
package javafx_ik.KullaniciBolumu;

public class IlanVeri {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private String firmaAd;
    private String ilanBaslik;

    public IlanVeri(int id) {
        this.id = id;
    }

    public IlanVeri(int id, String firmaAd, String ilanBaslik) {
        this.id = id;
        this.firmaAd = firmaAd;
        this.ilanBaslik = ilanBaslik;
    }

    public String getFirmaAd() {
        return firmaAd;
    }

    public void setFirmaAd(String firmaAd) {
        this.firmaAd = firmaAd;
    }

    public String getIlanBaslik() {
        return ilanBaslik;
    }

    public void setIlanBaslik(String ilanBaslik) {
        this.ilanBaslik = ilanBaslik;
    }

}
