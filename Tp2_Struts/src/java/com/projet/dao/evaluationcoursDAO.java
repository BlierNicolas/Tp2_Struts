package com.projet.dao;

import com.projet.entites.Evaluationcours;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class evaluationcoursDAO {
    private List<Evaluationcours> ListeEvaluationcours = new LinkedList<Evaluationcours>();
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Tp2StrutsPU");
    private EntityManager em = emf.createEntityManager();
    
    public boolean add(Evaluationcours ec) {
        em.getTransaction().begin();
        em.persist(ec);
        em.getTransaction().commit();
        return true;
    }
    public boolean update(Evaluationcours ec) {
        if (ListeEvaluationcours.contains(ec)) {
            em.persist(ec);
            return true;
        }
        return false;
    }
    public List<Evaluationcours> findAll() {
        Query query = em.createQuery("SELECT e FROM Evaluationcours e");
        return query.getResultList();
    }
    public Evaluationcours find(int id) {
        return em.find(Evaluationcours.class, id);
    }
}
