package tr.com.ecenk.tehlikeliMal.service;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import tr.com.ecenk.tehlikeliMal.dao.BaseDAO;
import tr.com.ecenk.tehlikeliMal.dao.BaseDAOImpl;
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

    @Autowired
    private BaseDAO baseDAO;
    public List<User> getAll(){
        return baseDAO.findAll(User.class);
    }
    public void save(User user){
        baseDAO.save(user);
    }
}
