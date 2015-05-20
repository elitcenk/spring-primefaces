package tr.com.ecenk.tehlikeliMal.controller;

import org.hibernate.HibernateException;
import tr.com.ecenk.tehlikeliMal.domain.TehlikeliMallar;
import tr.com.ecenk.tehlikeliMal.service.BaseServiceImpl;
import tr.com.ecenk.tehlikeliMal.util.JsfUtil;
import tr.com.ecenk.tehlikeliMal.util.JsfUtil.PersistAction;

import javax.faces.bean.ManagedProperty;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractController<T> {
    private PersistAction action = PersistAction.VIEW;
    @ManagedProperty(value = "#{baseService}")
    private BaseServiceImpl baseService;

    public List<T> formBeanList = null;
    private List<T> filteredFormBeanList = null;

    public abstract T getFormBean();
    public abstract void setFormBean(T formBean);



    public void persist() {
        switch (action){
            case CREATE:
                persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("Saved"));
                if (!JsfUtil.isValidationFailed()) {
                    setFormBeanList(null);    // Invalidate list of items to trigger re-query.
                }
                break;
            case UPDATE:
                persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("Updated"));
                if (!JsfUtil.isValidationFailed()) {
                    setFormBean(null);
                    setFormBeanList(null);
                }
                break;
            case DELETE:
                persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("Deleted"));
                if (!JsfUtil.isValidationFailed()) {
                    setFormBean(null);
                    setFormBeanList(null);
                }
                break;
        }
    }
    public void destroy(){
        action = PersistAction.DELETE;
        persist();
    }

    public void prepareDestroy() {
        action = PersistAction.VIEW;
    }
    public void prepareView() {
        action = PersistAction.VIEW;
    }
    public void prepareEdit() {
        action = PersistAction.UPDATE;
    }
    public void prepareCreate() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        action = PersistAction.CREATE;
        Class<T> clazz = (Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Constructor constructor = clazz.getConstructor();
        setFormBean((T) constructor.newInstance());
    }

    public boolean isEdit() {
        return action.equals(PersistAction.UPDATE);
    }

    public boolean isView() {
        return action.equals(PersistAction.VIEW);
    }


    private void persist(JsfUtil.PersistAction persistAction, String successMessage) {
        if (getFormBean() != null) {
            try {
                if (persistAction != PersistAction.DELETE) {
                    baseService.save(getFormBean());
                } else {
                    baseService.remove(getFormBean());
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (HibernateException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }


    public void setBaseService(BaseServiceImpl baseService) {
        this.baseService = baseService;
    }

    public void setFormBeanList(List<T> formBeanList) {
        this.formBeanList = formBeanList;
    }

    public List<T> getFormBeanList() {
        Class persistentClass = (Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        if (formBeanList == null) {
            setFormBeanList(baseService.findAll(persistentClass));
        }
        return formBeanList;
    }

    public List<T> getFilteredFormBeanList() {
        return filteredFormBeanList;
    }

    public void setFilteredFormBeanList(List<T> filteredFormBeanList) {
        this.filteredFormBeanList = filteredFormBeanList;
    }
}