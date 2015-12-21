package com.projet.dao;

import com.projet.entites.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class userDAO {
    
    private static List<User> users = new LinkedList<User>();

    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static Query query;
    
    static {
        users.add(new User("adupont", "Alain Dupont", "dupont"));
        users.add(new User("sduvet", "Sylvie Duvet", "duvet"));
        users.add(new User("alopointe", "Ali Lapointe", "lapointe"));
        users.add(new User("jmarois", "Jean Marois", "marois"));
        users.add(new User("pcharest", "Pauline Charest", "charest"));
        
//        emf = Persistence.createEntityManagerFactory("Tp2_StrutsPU");
//        em = emf.createEntityManager();
//        query = em.createNamedQuery("User.findAll");
//        users = query.getResultList();
    }

    public static boolean checkLogin(String usn, String psw) {
        ListIterator<User> it = users.listIterator();
        User unUser;
        while (it.hasNext()) {
            unUser = it.next();
            if (unUser.getUsername().equals(usn)) {
                if (psw.equals(unUser.getPassword())) {
                    return true;
                }
            }
        }
        return false;
    }
    public static int getNbUsers() {
        return users.size();
    }
}