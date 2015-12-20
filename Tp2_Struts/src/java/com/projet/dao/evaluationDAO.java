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
    private static List<Evaluation> ListeEvaluation = new LinkedList<Evaluation>();
    private static Map<String,List<String>> comments = new HashMap<String,List<String>>();

    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static Query query;
    
    static {
        Evaluation evaluation1 = new Evaluation(1, "adupond", "978-1-4302-2889-9", (short)8, "Très bon livre couvrant une bonne partie de la technologie Java-EE avec une étude assez approfondie de JPA. Le livre couvre aussi le framework JSF ainsi que les services web (SOAP et Restful). Le seul reproche que je peux lui faire est qu'il ne couvre pas les fondements de la programmation web (servlets et JSP).");
        Evaluation evaluation2 = new Evaluation(2, "sduvet", "978-1-4302-2889-9", (short)7, "Assez bon livre sur la technologie Java-EE. La couverture de JSF et JPA est appréciée. Par contre, je regrette qu'il ne couvre pas des frameworks très populaires tels que Struts et Hibernate.");
        Evaluation evaluation3 = new Evaluation(3, "adupond", "2-89377-250-1", (short)7, "Bon et gros livre couvrant beaucoup de sujets relatifs au développement de systèmes d'informations. On s'y perd un peu dans les nombreux sujets quelques fois antagonistes (exemple : approche structurée et approche objet).");
        Evaluation evaluation4 = new Evaluation(4, "alapointe", "9781430239307", (short)7, "Très bon livre pour découvrir le développement d'applications Android avec Java.");
        ListeEvaluation.add(evaluation1);
        ListeEvaluation.add(evaluation2);
        ListeEvaluation.add(evaluation3);
        ListeEvaluation.add(evaluation4);
        
//        emf = Persistence.createEntityManagerFactory("Tp2_StrutsPU");
//        em = emf.createEntityManager();
//        query = em.createNamedQuery("Livre.findAll");
//        LivreList = query.getResultList();
    }

    public static List<Evaluation> getListeCours() {
            return ListeEvaluation;
    }
    public static Evaluation getEvaluation(int id) {
        ListIterator<Evaluation> it = ListeEvaluation.listIterator();
        Evaluation c;
        while (it.hasNext())
        {
            c = it.next();
            if (c.getId().equals(id))
                return c;
        }
        return null;
    }
    public static boolean addEvaluation(Evaluation e) {
        if (ListeEvaluation.contains(e))
            return false;
        ListeEvaluation.add(e);
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        return true;
    }
}
