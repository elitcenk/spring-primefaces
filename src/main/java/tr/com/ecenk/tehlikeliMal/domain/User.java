package tr.com.ecenk.tehlikeliMal.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by cen2013 on 01/05/2015.
 */

@Entity
@Table(name = "USERS")
@GenericGenerator(
        strategy = "sequence",
        name = "idGenerator",
        parameters = {@org.hibernate.annotations.Parameter(name = "sequence", value = "USERS_SQ")}
)
public class User extends BaseModel {
    
    @Column(name = "USERNAME", nullable = false)
    private String userName;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
