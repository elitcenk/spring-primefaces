package tr.com.ecenk.tehlikeliMal.service;

import org.springframework.stereotype.Service;
import tr.com.ecenk.tehlikeliMal.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AKSTEST on 14/05/2015.
 */
@Service
public class UserService {
    private List<User> userList = new ArrayList<>();
    public List<User> getAll(){
        return userList;
    }
    public void save(User user){
        user.setId(userList.size());
        userList.add(user);
    }
}
