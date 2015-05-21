package tr.com.ecenk.tehlikeliMal.controller;

import tr.com.ecenk.tehlikeliMal.domain.TehlikeliMallar;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.*;

/**
 * Created by AKSTEST on 14/05/2015.
 */
@ManagedBean
@ViewScoped
public class TehlikeliMalController extends AbstractController<TehlikeliMallar> {
    private TehlikeliMallar formBean;

    private int pageNumber=1;

    private List<String> groupList = new ArrayList<>();

    @Override
    public TehlikeliMallar getFormBean() {
        return formBean;
    }

    @Override
    public void setFormBean(TehlikeliMallar formBean) {
        this.formBean = formBean;
    }

    public List<String> getGroupList() {
        Set<String> group = new HashSet<>();
        for(TehlikeliMallar tehlikeliMallar: formBeanList){
            group.add(tehlikeliMallar.getGroup());
        }
        groupList = new ArrayList<>(group);
        return groupList;
    }

    public void setGroupList(List<String> groupList) {
        this.groupList = groupList;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

}
