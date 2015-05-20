package tr.com.ecenk.tehlikeliMal.domain;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by AKSTEST on 15/05/2015.
 */
@Entity
@Table(name = "tehlikelimallar")
@XmlRootElement
public class TehlikeliMallar {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
