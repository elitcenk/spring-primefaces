package tr.com.ecenk.tehlikeliMal.controller;

import tr.com.ecenk.tehlikeliMal.domain.TehlikeliMallar;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

/**
 * Created by AKSTEST on 14/05/2015.
 */
@ManagedBean
@ViewScoped
public class TehlikeliMalController extends AbstractController<TehlikeliMallar> {
    private TehlikeliMallar formBean;

    @Override
    public TehlikeliMallar getFormBean() {
        return formBean;
    }

    @Override
    public void setFormBean(TehlikeliMallar formBean) {
        this.formBean = formBean;
    }

}
