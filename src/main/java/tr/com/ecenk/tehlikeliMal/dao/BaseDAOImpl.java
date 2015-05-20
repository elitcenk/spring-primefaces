package tr.com.ecenk.tehlikeliMal.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by AKSTEST on 15/05/2015.
 */
@Repository(value = "baseDAO")
public class BaseDAOImpl implements BaseDAO {

    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }


    @Override
    public <T> T find(Class<T> tClass, Serializable id) {
        return (T) getCurrentSession().get(tClass,id);
    }

    @Override
    public <T> T[] find(Class<T> tClass, Serializable... ids) {
        List<T> tList = new ArrayList<>();
        for(Serializable id: ids){
            tList.add((T) getCurrentSession().get(tClass,id));
        }
        return (T[]) tList.toArray();
    }

    @Override
    public <T> T getReference(Class<T> tClass, Serializable id) {
        return null;
    }

    @Override
    public <T> T[] getReferences(Class<T> tClass, Serializable... ids) {
        return null;
    }

    @Override
    public boolean save(Object object) {
        getCurrentSession().save(object);
        return true;
    }

    @Override
    public boolean remove(Object object) {
        getCurrentSession().delete(object);
        return true;
    }

    @Override
    public void remove(Object... objects) {
        for(Object o: objects){
            getCurrentSession().delete(o);
        }
    }

    @Override
    public boolean removeById(Class<?> tClass, Serializable id) {
        Object o = getCurrentSession().get(tClass, id);
        getCurrentSession().delete(o);
        return true;
    }

    @Override
    public void removeByIds(Class<?> tClass, Serializable... ids) {
        for(Serializable id: ids){
            Object o = getCurrentSession().get(tClass, id);
            getCurrentSession().delete(o);
        }
    }

    @Override
    public <T> List<T> findAll(Class<T> tClass) {
        Criteria criteria = getCurrentSession().createCriteria(tClass);
        return criteria.list();
    }

    @Override
    public boolean isAttached(Object object) {
        return false;
    }

    @Override
    public void refresh(Object... objects) {
        for(Object o: objects){
            getCurrentSession().refresh(o);
        }
    }

    @Override
    public void flush() {
        getCurrentSession().flush();
    }
}
