package tr.com.ecenk.tehlikeliMal.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by cen2013 on 02/05/2015.
 */
@Embeddable
public class PortatifTankVeYiginKonteyner implements Serializable {
//    @ElementCollection
//    @CollectionTable(name="RL_PORTATIFTANK_TALIMAT", joinColumns=@JoinColumn(name="TEHLIKELI_MAL_ID"))
    @Column(name="PORTATIF_TALIMAT")
    private String talimatlar;

//    @ElementCollection
//    @CollectionTable(name="RL_PORTATIFTANK_OZELHUKUM", joinColumns=@JoinColumn(name="TEHLIKELI_MAL_ID"))
    @Column(name="PORTATIF_OZEL_HUKUM")
    private String ozelHukumler;

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
}
