package tr.com.ecenk.tehlikeliMal.domain;

import javax.persistence.*;

/**
 * Created by AKSTEST on 20/05/2015.
 */
@MappedSuperclass
public abstract class BaseModel implements IModel {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "idGenerator", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Version
    @Column(name = "VERSIYON", nullable = false)
    private long versiyon = 0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getVersiyon() {
        return versiyon;
    }

    public void setVersiyon(long versiyon) {
        this.versiyon = versiyon;
    }

}
