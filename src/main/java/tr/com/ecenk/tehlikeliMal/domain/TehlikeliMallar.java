package tr.com.ecenk.tehlikeliMal.domain;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by AKSTEST on 15/05/2015.
 */
@Entity
@Table(name = "TEHLIKELI_MALLAR")
@GenericGenerator(
        strategy = "sequence",
        name = "idGenerator",
        parameters = {@org.hibernate.annotations.Parameter(name = "sequence", value = "TEHLIKELI_MAL_SQ")}
)
public class TehlikeliMallar extends BaseModel {
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "grup", nullable = false)
    private String group;

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

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
