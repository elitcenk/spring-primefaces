package tr.com.ecenk.tehlikeliMal.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by cen2013 on 02/05/2015.
 */
@Embeddable
public class ADRTank implements Serializable {
    @Column(name = "ADR_TANK_KODU")
    private String kod;

//    @ElementCollection
//    @CollectionTable(name="RL_ADRTANK_OZELHUKUM", joinColumns=@JoinColumn(name="TEHLIKELI_MAL_ID"))
    @Column(name="ADR_OZEL_HUKUM")
    private String ozelHukumler;


    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public String getOzelHukumler() {
        return ozelHukumler;
    }

    public void setOzelHukumler(String ozelHukumler) {
        this.ozelHukumler = ozelHukumler;
    }
}
