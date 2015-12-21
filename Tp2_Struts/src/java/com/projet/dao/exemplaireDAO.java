package com.projet.dao;

import com.projet.entites.Cours;
import com.projet.entites.Exemplaire;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class exemplaireDAO {
    private static List<Exemplaire> ListeExemplaire = new LinkedList<Exemplaire>();

    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static Query query;
    
    static {
        
//        emf = Persistence.createEntityManagerFactory("Tp2_StrutsPU");
//        em = emf.createEntityManager();
//        query = em.createNamedQuery("Livre.findAll");
//        LivreList = query.getResultList();
    }

    public static List<Exemplaire> getListeExemplaire() {
            return ListeExemplaire;
    }
    public static Exemplaire getExemplaire(String isbn, int numero) {
        ListIterator<Exemplaire> it = ListeExemplaire.listIterator();
        Exemplaire ex;
        while (it.hasNext())
        {
            ex = it.next();
            if ((ex.getExemplairePK().getIsbn().equals(isbn)) && (ex.getExemplairePK().getNumero() == numero))
                return ex;
        }
        return null;
    }
    public static boolean addExemplaire(Exemplaire ex) {
        if (ListeExemplaire.contains(ex))
            return false;
        ListeExemplaire.add(ex);
//        em.getTransaction().begin();
//        em.persist(ex);
//        em.getTransaction().commit();
        return true;
    }
}
