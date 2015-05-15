package tr.com.ecenk.tehlikeliMal.domain;

/**
 * Created by AKSTEST on 14/05/2015.
 */
public class User {
    private long id;

    private String userName;

    private String password;

    public User(String userName, String password, int id) {
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
