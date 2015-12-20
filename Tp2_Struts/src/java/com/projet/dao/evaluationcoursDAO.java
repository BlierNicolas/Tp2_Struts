package com.projet.dao;

import com.projet.entites.Cours;
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
    private static List<Evaluationcours> ListeEvaluationcours = new LinkedList<Evaluationcours>();
    private static Map<String,List<String>> comments = new HashMap<String,List<String>>();

    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static Query query;
    
    static {
        Evaluationcours evaluationcours1 = new Evaluationcours(1, "2-89377-250-1", "alapointe", "420-AW6-RO", (short)5, "Pour ce cours sur le développement de projets selon l'approche objet, ce livre ne peut servir que de référence aux étudiants dans le volet de gestion de projet (surtout sa planification). UML et les processus de développement objet ne sont pas couverts ad");
        Evaluationcours evaluationcours2 = new Evaluationcours(2, "978-1-4302-2889-9", "alapointe", "420-AW6-RO", (short)5, "Dans ce cours, ce livre peut être utile pour des étudiants qui développent leur projet en Java-EE s'ils utilisent un des éléments suivants : JSF, JPA, seervices web.");
        ListeEvaluationcours.add(evaluationcours1);
        ListeEvaluationcours.add(evaluationcours1);
        
//        emf = Persistence.createEntityManagerFactory("Tp2_StrutsPU");
//        em = emf.createEntityManager();
//        query = em.createNamedQuery("Livre.findAll");
//        LivreList = query.getResultList();
    }

    public static List<Evaluationcours> getListeEvaluationcours() {
            return ListeEvaluationcours;
    }
    public static Evaluationcours getEvaluationcours(int id) {
        ListIterator<Evaluationcours> it = ListeEvaluationcours.listIterator();
        Evaluationcours ec;
        while (it.hasNext())
        {
            ec = it.next();
            if (ec.getId().equals(id))
                return ec;
        }
        return null;
    }
    public static boolean addEvaluationcours(Evaluationcours ec) {
        if (ListeEvaluationcours.contains(ec))
            return false;
        ListeEvaluationcours.add(ec);
        em.getTransaction().begin();
        em.persist(ec);
        em.getTransaction().commit();
        return true;
    }
}
