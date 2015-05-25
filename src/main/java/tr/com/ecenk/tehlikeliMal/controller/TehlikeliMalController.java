package tr.com.ecenk.tehlikeliMal.controller;

import tr.com.ecenk.tehlikeliMal.domain.TehlikeliMal;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.*;

/**
 * Created by AKSTEST on 14/05/2015.
 */
@ManagedBean
@ViewScoped
public class TehlikeliMalController extends AbstractController<TehlikeliMal> {
    private TehlikeliMal formBean;

    private int pageNumber=1;

    private List<String> groupList = new ArrayList<>();

    @Override
    public TehlikeliMal getFormBean() {
        return formBean;
    }

    @Override
    public void setFormBean(TehlikeliMal formBean) {
        this.formBean = formBean;
    }

    public List<String> getGroupList() {
        Set<String> group = new HashSet<>();
        for(TehlikeliMal TehlikeliMal: formBeanList){
            group.add(TehlikeliMal.getSinif());
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
