package tr.com.ecenk.tehlikeliMal.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by AKSTEST on 14/05/2015.
 */
@Entity
@Table(name = "USERS")
@GenericGenerator(
        strategy = "sequence",
        name = "idGenerator",
        parameters = {@org.hibernate.annotations.Parameter(name = "sequence", value = "USERS_SQ")}
)
public class User extends BaseModel {

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
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
