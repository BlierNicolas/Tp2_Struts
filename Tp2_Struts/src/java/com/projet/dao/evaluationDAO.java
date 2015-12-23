package com.projet.dao;

import com.projet.entites.Evaluation;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class evaluationDAO {
    private List<Evaluation> ListeEvaluation = new LinkedList<Evaluation>();
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Tp2StrutsPU");
    private EntityManager em = emf.createEntityManager();

    public boolean add(Evaluation e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        return true;
    }
    public boolean update(Evaluation e) {
        if (ListeEvaluation.contains(e)) {
            em.persist(e);
            return true;
        }
        return false;
    }
    public List<Evaluation> findAll() {
        Query query = em.createQuery("SELECT e FROM Evaluation e");
        return query.getResultList();
    }
    public Evaluation find(int id) {
        return em.find(Evaluation.class, id);
    }
}
