package tr.com.ecenk.tehlikeliMal.domain;

import javax.persistence.*;

/**
 * Created by AKSTEST on 14/05/2015.
 */
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    public User(String userName, String password, long id) {
        this.userName = userName;
        this.password = password;
        this.id = id;
    }
    public User(){

    }

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
