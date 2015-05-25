package tr.com.ecenk.tehlikeliMal.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by cen2013 on 02/05/2015.
 */
@Embeddable
public class Tasima implements Serializable {
    @Column(name = "TASIMA_KATEGORISI")
    private String kategori;

//    @ElementCollection
//    @CollectionTable(name="RL_TASIMA_AMBALAJ", joinColumns=@JoinColumn(name="TEHLIKELI_MAL_ID"))
    @Column(name="TASIMA_AMBALAJ")
    private String ambalajlar;

    @Column(name = "TASIMA_DOKME")
    private String dokme;

    @Column(name = "TASIMA_YKLM_BSLTM_ELLCLM")
    private String yuklemeBosaltmaEllecleme;

    @Column(name = "TASIMA_OPERASYON")
    private String operasyon;


    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getAmbalajlar() {
        return ambalajlar;
    }

    public void setAmbalajlar(String ambalajlar) {
        this.ambalajlar = ambalajlar;
    }

    public String getDokme() {
        return dokme;
    }

    public void setDokme(String dokme) {
        this.dokme = dokme;
    }

    public String getYuklemeBosaltmaEllecleme() {
        return yuklemeBosaltmaEllecleme;
    }

    public void setYuklemeBosaltmaEllecleme(String yuklemeBosaltmaEllecleme) {
        this.yuklemeBosaltmaEllecleme = yuklemeBosaltmaEllecleme;
    }

    public String getOperasyon() {
        return operasyon;
    }

    public void setOperasyon(String operasyon) {
        this.operasyon = operasyon;
    }
}
