package tr.com.ecenk.tehlikeliMal.service;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import tr.com.ecenk.tehlikeliMal.domain.User;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AKSTEST on 14/05/2015.
 */
@Service
@Transactional
public class UserService {
    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }


    private List<User> userList = new ArrayList<>();
    public List<User> getAll(){
        Criteria criteria = getCurrentSession().createCriteria(User.class);
        return criteria.list();
    }
    public void save(User user){
        getCurrentSession().save(user);
    }
}
