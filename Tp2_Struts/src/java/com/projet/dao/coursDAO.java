package com.projet.dao;

import com.projet.entites.Cours;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class coursDAO {
    private List<Cours> ListeCours = new LinkedList<Cours>();
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Tp2StrutsPU");
    private EntityManager em = emf.createEntityManager();

    public boolean add(Cours c) {
        ListeCours = findAll();
        if (ListeCours.contains(c))
            return false;
        ListeCours.add(c);
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        return true;
    }
    public boolean update(Cours c) {
        if (ListeCours.contains(c)) {
            em.persist(c);
            return true;
        }
        return false;
    }
    public List<Cours> findAll() {
        Query query = em.createQuery("SELECT c FROM Cours c");
        return query.getResultList();
    }
    public Cours find(int id) {
        return em.find(Cours.class, id);
    }
}
