package com.projet.dao;

import java.util.LinkedList;
import java.util.List;

import com.projet.entites.Livre;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class livreDAO {
    private List<Livre> ListeLivre = new LinkedList<Livre>();
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Tp2StrutsPU");
    private EntityManager em = emf.createEntityManager();
    
    public boolean add(Livre l) {
        ListeLivre = findAll();
        for (int i=0;i<ListeLivre.size();i++) {
            if (ListeLivre.get(i).getIsbn().equals(l.getIsbn())) {
                return false;
            } else {
                em.getTransaction().begin();
                em.persist(l);
                em.getTransaction().commit();
                return true;
            }
        }
        return false;
    }
    public boolean update(Livre l) {
        if (ListeLivre.contains(l)) {
            em.persist(l);
            return true;
        }
        return false;
    }
    public List<Livre> findAll() {
        Query query = getEntityManager().createQuery("SELECT l FROM Livre l ORDER BY l.note DESC");
        return query.getResultList();
    }
    
    private EntityManager getEntityManager() {
        return em;
    }
 
    public Livre find(String isbn) {
        return em.find(Livre.class, isbn);
    }
}
