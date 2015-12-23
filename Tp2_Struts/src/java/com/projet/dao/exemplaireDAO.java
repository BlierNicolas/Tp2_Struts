package com.projet.dao;

import com.projet.entites.Exemplaire;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class exemplaireDAO {
    private List<Exemplaire> ListeExemplaire = new LinkedList<Exemplaire>();
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Tp2StrutsPU");
    private EntityManager em = emf.createEntityManager();

    public boolean add(Exemplaire ex) {
        em.getTransaction().begin();
        em.persist(ex);
        em.getTransaction().commit();
        return true;
    }
    public boolean update(Exemplaire ex) {
        if (ListeExemplaire.contains(ex)) {
            em.persist(ex);
            return true;
        }
        return false;
    }
    public List<Exemplaire> findAll() {
        Query query = em.createQuery("SELECT e FROM Exemplaire e");
        return query.getResultList();
    }
 
    public Exemplaire find(int isbn) {
        return em.find(Exemplaire.class, isbn);
    }
}
