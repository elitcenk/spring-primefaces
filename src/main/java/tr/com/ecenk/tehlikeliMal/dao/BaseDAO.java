package tr.com.ecenk.tehlikeliMal.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by AKSTEST on 20/05/2015.
 */
public interface BaseDAO {
    <T> T find(Class<T> tClass, Serializable id);

    <T> T[] find(Class<T> tClass, Serializable... ids);

    <T> T getReference(Class<T> tClass, Serializable id);

    <T> T[] getReferences(Class<T> tClass, Serializable... ids);

    boolean save(Object object);

    boolean remove(Object object);

    void remove(Object... objects);

    boolean removeById(Class<?> tClass, Serializable id);

    void removeByIds(Class<?> tClass, Serializable... ids);

    <T> List<T> findAll(Class<T> tClass);

    boolean isAttached(Object object);

    void refresh(Object... objects);

    void flush();
}
