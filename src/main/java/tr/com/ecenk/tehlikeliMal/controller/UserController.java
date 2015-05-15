package tr.com.ecenk.tehlikeliMal.controller;

import tr.com.ecenk.tehlikeliMal.domain.User;
import tr.com.ecenk.tehlikeliMal.service.UserService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.List;

/**
 * Created by AKSTEST on 14/05/2015.
 */
@ManagedBean
@ViewScoped
public class UserController {

    @ManagedProperty(value = "#{userService}")
    private UserService userService;

    private List<User> userList;

    private User formBean = new User();

    @PostConstruct
    public void init(){
        userList = userService.getAll();
    }
    public void save(){
        userService.save(formBean);
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public User getFormBean() {
        return formBean;
    }

    public void setFormBean(User formBean) {
        this.formBean = formBean;
    }

    public List<User> getUserList() {
        userList = userService.getAll();
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
