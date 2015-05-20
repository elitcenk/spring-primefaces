package tr.com.ecenk.tehlikeliMal.service;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.ecenk.tehlikeliMal.dao.BaseDAO;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

/**
 * Created by AKSTEST on 20/05/2015.
 */
@Service(value = "baseService")
@Transactional
public class BaseServiceImpl implements BaseService{

    @Autowired
    private BaseDAO baseDAO;

    @Override
    public <T> T find(Class<T> tClass, Serializable id) {
        return baseDAO.find(tClass, id);
    }

    @Override
    public <T> T[] find(Class<T> tClass, Serializable... ids) {
        return baseDAO.find(tClass, ids);
    }

    @Override
    public <T> T getReference(Class<T> tClass, Serializable id) {
        return baseDAO.getReference(tClass, id);
    }

    @Override
    public <T> T[] getReferences(Class<T> tClass, Serializable... ids) {
        return baseDAO.getReferences(tClass,ids);
    }

    @Override
    public boolean save(Object object) {
        return baseDAO.save(object);
    }

    @Override
    public boolean remove(Object object) {
        return baseDAO.remove(object);
    }

    @Override
    public void remove(Object... objects) {
        baseDAO.remove(objects);
    }

    @Override
    public boolean removeById(Class<?> tClass, Serializable id) {
        return baseDAO.removeById(tClass,id);
    }

    @Override
    public void removeByIds(Class<?> tClass, Serializable... ids) {
        baseDAO.removeByIds(tClass, ids);
    }

    @Override
    public <T> List<T> findAll(Class<T> tClass) {
        return baseDAO.findAll(tClass);
    }

    @Override
    public boolean isAttached(Object object) {
        return baseDAO.isAttached(object);
    }

    @Override
    public void refresh(Object... objects) {
        baseDAO.refresh(objects);
    }

    @Override
    public void flush() {
        baseDAO.flush();
    }
}
