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
    private static List<Cours> ListeCours = new LinkedList<Cours>();

    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static Query query;
    
    static {
        Cours cours1 = new Cours("420-AW6-RO", "Développement de projets informatiques", 90);
        Cours cours2 = new Cours("420-AV4-RO", "Conception d'applications hypermédias", 60);
        Cours cours3 = new Cours("420-AX4-RO", "Développement en environnement graphique", 60);
        Cours cours4 = new Cours("420-353-RO", "Programmation réseau", 45);
        Cours cours5 = new Cours("420-026-RO", "Programmation structurée", 90);
        Cours cours6 = new Cours("420-046-RO", "Programmation orientée objets", 90);
        ListeCours.add(cours1);
        ListeCours.add(cours2);
        ListeCours.add(cours3);
        ListeCours.add(cours4);
        ListeCours.add(cours5);
        ListeCours.add(cours6);
        
//        emf = Persistence.createEntityManagerFactory("Tp2_StrutsPU");
//        em = emf.createEntityManager();
//        query = em.createNamedQuery("Livre.findAll");
//        LivreList = query.getResultList();
    }

    public static List<Cours> getListeCours() {
            return ListeCours;
    }
    public static Cours getCours(String numero) {
        ListIterator<Cours> it = ListeCours.listIterator();
        Cours c;
        while (it.hasNext())
        {
            c = it.next();
            if (c.getNumero().equals(numero))
                return c;
        }
        return null;
    }
    public static boolean addCours(Cours c) {
        if (ListeCours.contains(c))
            return false;
        ListeCours.add(c);
//        em.getTransaction().begin();
//        em.persist(c);
//        em.getTransaction().commit();
        return true;
    }
}
