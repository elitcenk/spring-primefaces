package tr.com.ecenk.tehlikeliMal.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by cen2013 on 02/05/2015.
 */
@Entity
@Table(name = "TEHLIKELI_MAL")
@GenericGenerator(
        strategy = "sequence",
        name = "idGenerator",
        parameters = {@org.hibernate.annotations.Parameter(name = "sequence", value = "TEHLIKELI_MAL_SQ")}
)
public class TehlikeliMal extends BaseModel {

    @Column(name = "BM_NO")
    private String bmNo;

    @Column(name = "ISIM")
    private String isim;

    @Column(name = "SINIF")
    private String sinif;

    @Column(name = "SINIFLADIRMA_KODU")
    private String siniflandirmaKodu;

    @Column(name = "AMBALAJLAMA_GRUBU")
    private String ambalajlamaGrubu;

//    @ElementCollection
//    @CollectionTable(name="RL_TEHLIKELIMAL_ETIKET", joinColumns=@JoinColumn(name="TEHLIKELI_MAL_ID"))
    @Column(name="ETIKET")
    private String etiketler;

//    @ElementCollection
//    @CollectionTable(name="RL_TEHLIKELIMAL_OZELHUKUM", joinColumns=@JoinColumn(name="TEHLIKELI_MAL_ID"))
    @Column(name="OZEL_HUKUM")
    private String ozelHukumler;

    @Column(name = "SINIRLI_MIKTAR")
    private String sinirliMiktar;

    @Column(name = "ISTISNAI_MIKTAR")
    private String istisnaiMiktar;

    @Column(name = "TANK_TASINMASI_ICIN_ARAC")
    private String tankTasinmasiIcinArac;

    @Column(name = "TEHLIKE_TANIMLAMA_NO")
    private String tehlikeTanimlamaNo;

    @Embedded
    private Ambalajlama ambalajlama = new Ambalajlama();

    @Embedded
    private PortatifTankVeYiginKonteyner portatifTankVeYiginKonteyner = new PortatifTankVeYiginKonteyner();

    @Embedded
    private ADRTank adrTank = new ADRTank();

    @Embedded
    private Tasima tasima = new Tasima();


    public String getBmNo() {
        return bmNo;
    }


    public void setBmNo(String bmNo) {
        this.bmNo = bmNo;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSinif() {
        return sinif;
    }

    public void setSinif(String sinif) {
        this.sinif = sinif;
    }

    public String getSiniflandirmaKodu() {
        return siniflandirmaKodu;
    }

    public void setSiniflandirmaKodu(String siniflandirmaKodu) {
        this.siniflandirmaKodu = siniflandirmaKodu;
    }

    public String getAmbalajlamaGrubu() {
        return ambalajlamaGrubu;
    }

    public void setAmbalajlamaGrubu(String ambalajlamaGrubu) {
        this.ambalajlamaGrubu = ambalajlamaGrubu;
    }

    public String getEtiketler() {
        return etiketler;
    }

    public void setEtiketler(String etiketler) {
        this.etiketler = etiketler;
    }

    public String getOzelHukumler() {
        return ozelHukumler;
    }

    public void setOzelHukumler(String ozelHukumler) {
        this.ozelHukumler = ozelHukumler;
    }

    public String getSinirliMiktar() {
        return sinirliMiktar;
    }

    public void setSinirliMiktar(String sinirliMiktar) {
        this.sinirliMiktar = sinirliMiktar;
    }

    public String getIstisnaiMiktar() {
        return istisnaiMiktar;
    }

    public void setIstisnaiMiktar(String istisnaiMiktar) {
        this.istisnaiMiktar = istisnaiMiktar;
    }

    public String getTankTasinmasiIcinArac() {
        return tankTasinmasiIcinArac;
    }

    public void setTankTasinmasiIcinArac(String tankTasinmasiIcinArac) {
        this.tankTasinmasiIcinArac = tankTasinmasiIcinArac;
    }

    public String getTehlikeTanimlamaNo() {
        return tehlikeTanimlamaNo;
    }

    public void setTehlikeTanimlamaNo(String tehlikeTanimlamaNo) {
        this.tehlikeTanimlamaNo = tehlikeTanimlamaNo;
    }

    public Ambalajlama getAmbalajlama() {
        return ambalajlama;
    }

    public void setAmbalajlama(Ambalajlama ambalajlama) {
        this.ambalajlama = ambalajlama;
    }

    public PortatifTankVeYiginKonteyner getPortatifTankVeYiginKonteyner() {
        return portatifTankVeYiginKonteyner;
    }

    public void setPortatifTankVeYiginKonteyner(PortatifTankVeYiginKonteyner portatifTankVeYiginKonteyner) {
        this.portatifTankVeYiginKonteyner = portatifTankVeYiginKonteyner;
    }

    public ADRTank getAdrTank() {
        return adrTank;
    }

    public void setAdrTank(ADRTank adrTank) {
        this.adrTank = adrTank;
    }

    public Tasima getTasima() {
        return tasima;
    }

    public void setTasima(Tasima tasima) {
        this.tasima = tasima;
    }
}
