package com.projet.dao;

import com.projet.entites.User;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class userDAO {
    private List<User> users = new LinkedList<User>();
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Tp2StrutsPU");
    private EntityManager em = emf.createEntityManager();
    
    public boolean checkLogin(String usn, String psw) {
        User unUser = em.find(User.class, usn);
        if (unUser.getUsername().equals(usn)) {
            if (psw.equals(unUser.getPassword())) {
                return true;
            }
        }
        return false;
    }
}