package tr.com.ecenk.tehlikeliMal.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by AKSTEST on 15/05/2015.
 */
public class BaseDAOImpl implements BaseDAO  {


    @Override
    public <T> T find(Class<T> var1, Serializable var2) {
        return null;
    }

    @Override
    public <T> T[] find(Class<T> var1, Serializable... var2) {
        return null;
    }

    @Override
    public <T> T getReference(Class<T> var1, Serializable var2) {
        return null;
    }

    @Override
    public <T> T[] getReferences(Class<T> var1, Serializable... var2) {
        return null;
    }

    @Override
    public boolean save(Object var1) {
        return false;
    }

    @Override
    public boolean[] save(Object... var1) {
        return new boolean[0];
    }

    @Override
    public boolean remove(Object var1) {
        return false;
    }

    @Override
    public void remove(Object... var1) {

    }

    @Override
    public boolean removeById(Class<?> var1, Serializable var2) {
        return false;
    }

    @Override
    public void removeByIds(Class<?> var1, Serializable... var2) {

    }

    @Override
    public <T> List<T> findAll(Class<T> var1) {
        return null;
    }

    @Override
    public boolean isAttached(Object var1) {
        return false;
    }

    @Override
    public void refresh(Object... var1) {

    }

    @Override
    public void flush() {

    }
}
