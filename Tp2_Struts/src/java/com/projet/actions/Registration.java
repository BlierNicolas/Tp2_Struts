package com.projet.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.projet.dao.userDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.projet.entites.user;

public class Registration extends ActionSupport implements SessionAware {

    userDAO userDAO = new userDAO(Connexion.getInstance());
    private Map<String, Object> session;
    private String username, password;

    @Override
    public void setSession(Map<String, Object> s) {
        // TODO Auto-generated method stub
        session = s;
    }

    public String execute()
    {
        if (username==null)
            return INPUT;
        user unUser = new user(username, "", password);
        if (userDAO.create(unUser))
            return SUCCESS;
        return INPUT;
    }


    public void validate()
    {
        if (username!=null && username.indexOf('@')==-1)
            this.addFieldError("username", "[Exemple de validation] Le username doit contenir le caractere @.");
        if (password!=null && password.length()<3)
            this.addFieldError("password", "Le mot de passe doit avoir au moins 3 caracteres.");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
