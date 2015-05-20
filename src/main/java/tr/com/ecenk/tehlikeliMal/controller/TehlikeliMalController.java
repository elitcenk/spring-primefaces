package tr.com.ecenk.tehlikeliMal.controller;

import org.hibernate.HibernateException;
import tr.com.ecenk.tehlikeliMal.dao.BaseDAOImpl;
import tr.com.ecenk.tehlikeliMal.domain.TehlikeliMallar;
import tr.com.ecenk.tehlikeliMal.domain.User;
import tr.com.ecenk.tehlikeliMal.service.BaseServiceImpl;
import tr.com.ecenk.tehlikeliMal.service.UserService;
import tr.com.ecenk.tehlikeliMal.util.JsfUtil;
import tr.com.ecenk.tehlikeliMal.util.JsfUtil.PersistAction;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by AKSTEST on 14/05/2015.
 */
@ManagedBean
@ViewScoped
public class TehlikeliMalController {
    private PersistAction action = PersistAction.VIEW;

    @ManagedProperty(value = "#{baseService}")
    private BaseServiceImpl baseService;

    private List<TehlikeliMallar> tehlikeliMallarList;

    private TehlikeliMallar formBean = new TehlikeliMallar();

    public void save(){
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TehlikelimallarCreated"));
    }
    public void prepareView(){
        action = PersistAction.VIEW;
    }
    public void prepareEdit(){
        action = PersistAction.UPDATE;
    }
    public boolean isEdit(){
        return action.equals(PersistAction.UPDATE);
    }

    public boolean isView(){
        return action.equals(PersistAction.VIEW);
    }

    public TehlikeliMallar prepareCreate(){
        action = PersistAction.CREATE;
        formBean = new TehlikeliMallar();
        return formBean;
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("TehlikelimallarDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            formBean = null; // Remove selection
            tehlikeliMallarList = null;    // Invalidate list of items to trigger re-query.
        }
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (formBean != null) {
            try {
                if (persistAction != PersistAction.DELETE) {
                    baseService.save(formBean);
                } else {
                    baseService.remove(formBean);
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

    public TehlikeliMallar getFormBean() {
        return formBean;
    }

    public void setFormBean(TehlikeliMallar formBean) {
        this.formBean = formBean;
    }

    public List<TehlikeliMallar> getTehlikeliMallarList() {
        tehlikeliMallarList = baseService.findAll(TehlikeliMallar.class);
        return tehlikeliMallarList;
    }

    public void setTehlikeliMallarList(List<TehlikeliMallar> tehlikeliMallarList) {
        this.tehlikeliMallarList = tehlikeliMallarList;
    }

}
