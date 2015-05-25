package tr.com.ecenk.tehlikeliMal.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by cen2013 on 02/05/2015.
 */
@Embeddable
public class Ambalajlama implements Serializable {
//    @ElementCollection
//    @CollectionTable(name="RL_AMBALAJLAMA_TALIMAT", joinColumns=@JoinColumn(name="TEHLIKELI_MAL_ID"))
    @Column(name="AMBALAJ_TALIMAT")
    private String talimatlar;

//    @ElementCollection
//    @CollectionTable(name="RL_AMBALAJLAMA_OZELHUKUM", joinColumns=@JoinColumn(name="TEHLIKELI_MAL_ID"))
    @Column(name="AMBALAJ_OZEL_HUKUM")
    private String ozelHukumler;

//    @ElementCollection
//    @CollectionTable(name="RL_AMBALAJLAMA_KARISIKHUKUM", joinColumns=@JoinColumn(name="TEHLIKELI_MAL_ID"))
    @Column(name="AMBALAJ_KARISIK_HUKUM")
    private String karisikHukumler;

    public String getTalimatlar() {
        return talimatlar;
    }

    public void setTalimatlar(String talimatlar) {
        this.talimatlar = talimatlar;
    }

    public String getOzelHukumler() {
        return ozelHukumler;
    }

    public void setOzelHukumler(String ozelHukumler) {
        this.ozelHukumler = ozelHukumler;
    }

    public String getKarisikHukumler() {
        return karisikHukumler;
    }

    public void setKarisikHukumler(String karisikHukumler) {
        this.karisikHukumler = karisikHukumler;
    }
}
