package com.projet.dao;

import com.projet.entites.Cours;
import com.projet.entites.Exemplaire;
import com.projet.entites.ExemplairePK;
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
        ExemplairePK ExemplairePK1 = new ExemplairePK();
        ExemplairePK ExemplairePK2 = new ExemplairePK();
        ExemplairePK ExemplairePK3 = new ExemplairePK();
        
        
        Exemplaire exemplaire1 = new Exemplaire(ExemplairePK1,"Moumene","Djibo");
        Exemplaire exemplaire2 = new Exemplaire(ExemplairePK2,"Gailloux","Bousquet");
        Exemplaire exemplaire3 = new Exemplaire(ExemplairePK3,"Elena","Junka");
       
        ListeExemplaire.add(exemplaire1);
        ListeExemplaire.add(exemplaire2);
        ListeExemplaire.add(exemplaire3);
     
        
        
        
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
