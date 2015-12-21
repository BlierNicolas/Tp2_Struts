package com.projet.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.projet.dao.userDAO;
import com.opensymphony.xwork2.ActionSupport;
import com.projet.entites.User;

public class Authentification extends ActionSupport implements SessionAware {

    private Map<String, Object> session;
    private String username, password;

    @Override
    public void setSession(Map<String, Object> s) {
        // TODO Auto-generated method stub
        session = s;
    }

    public String login()
    {
        if (userDAO.checkLogin(username, password))
        {
            session.put("username", username);
            session.put("connecte", true);
            return SUCCESS;
        }
        return INPUT;
    }
    public String logout()
    {
        session.remove("username");
        session.remove("connecte");
        session.clear();
        return SUCCESS;
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
