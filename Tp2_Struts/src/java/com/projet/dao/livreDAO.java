package com.projet.dao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import com.projet.entites.Livre;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class livreDAO {
    private static List<Livre> LivreList = new LinkedList<Livre>();
    private static Map<String,List<String>> comments = new HashMap<String,List<String>>();

    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static Query query;
    
    static {
        Livre livre1 = new Livre("978-1-4302-2889-9", "Begining Java EE 6 Platform with GlassFish 3", "Développement avec Java-EE. Gestion de persistence avec JPA. Le framework JSF. Les services web.", 508, 0);
        Livre livre2 = new Livre("9781430239307", "Pro Android 4", "Développement d'applications en Java pour Android.", 991, 0);
        Livre livre3 = new Livre("2-89377-250-1", "Analyse et conception de systèmes d'information", "Analyse et conception de systèmes selon les approches structurée et objet. Rôle de l'analyste et gestion de projets.", 100, 0);
        Livre livre4 = new Livre("2-7440-7090-4", "UML 2 et les design patterns, 3e edition", "Livre abordant l'analyse et la conception de système selon l'approche objet d'un point de vue mise en oeuvre. L'auteur nous fait partager son expérience pratique.", 655, 0);
        Livre livre5 = new Livre("2895937591", "Java Structuré", "Initiation à la programmation structurée avec le langage Java.", 158, 0);
        Livre livre6 = new Livre("9780132149181", "Java Software Solutions: Foundations of Program Development, 7Ed", "Livre très pédagogique d'introduction à la programmation en Java.", 832, 0);
        Livre livre7 = new Livre("2-7440-7312-1", "Au coeur de Java, 8e édition", "Très bon livre d'introduction à Java mais pour des personnes ayant déjà programmé.", 928, 0);
        Livre livre8 = new Livre("2-7440-1962-3", "Au coeur de Java 2, vol. 2 Fonctions avancées, JDK", "Livre couvrant des concepts avancés de la programmation avec l'édition standard de Java (Java-SE).", 858, 0);
        Livre livre9 = new Livre("0-201-73733-7", "Object-Oriented Software Development Using Java", "Livre très pédagogique axé sur la conception d'application et l'exploitation des principaux patrons de conception.", 677, 0);
        LivreList.add(livre1);
        LivreList.add(livre2);
        LivreList.add(livre3);
        LivreList.add(livre4);
        LivreList.add(livre5);
        LivreList.add(livre6);
        LivreList.add(livre7);
        LivreList.add(livre8);
        LivreList.add(livre9);
        
//        emf = Persistence.createEntityManagerFactory("Tp2_StrutsPU");
//        em = emf.createEntityManager();
//        query = em.createNamedQuery("Livre.findAll");
//        LivreList = query.getResultList();
    }

    public static List<Livre> getLivreList() {
            return LivreList;
    }
    public static Livre getBook(String isbn) {
        ListIterator<Livre> it = LivreList.listIterator();
        Livre b;
        while (it.hasNext())
        {
            b = it.next();
            if (b.getIsbn().equals(isbn))
                return b;
        }
        return null;
    }
    public static boolean addBook(Livre l) {
        if (LivreList.contains(l))
            return false;
        LivreList.add(l);
        em.getTransaction().begin();
        em.persist(l);
        em.getTransaction().commit();
        return true;
    }

    public static List<String> getComments(String isbn) {
        return comments.get(isbn);
    }
    public static void addComment(String isbn, String comment) {
        if (comments.containsKey(isbn))
        {
            comments.get(isbn).add(comment);
        }
        else
        {
            List<String> l = new LinkedList<String>();
            l.add(comment);
            comments.put(isbn, l);
        }
    }
}
