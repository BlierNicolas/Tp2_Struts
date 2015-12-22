package com.projet.actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.projet.dao.livreDAO;
import com.projet.entites.Livre;
import com.opensymphony.xwork2.ActionSupport;
import com.projet.dao.coursDAO;
import com.projet.dao.evaluationDAO;
import com.projet.dao.evaluationcoursDAO;
import com.projet.entites.Cours;
import com.projet.entites.Evaluation;
import com.projet.entites.Evaluationcours;
import static java.lang.System.out;

public class BookAction extends ActionSupport implements SessionAware {

    private Map<String, Object> session;
    private List<Livre> ListeLivre;
    private Livre livre;
    private List<Evaluation> ListeEvaluation;
    private List<Evaluationcours> ListeEvaluationcours;
    private List<Cours> ListeCours;
    private Cours cours;
    private String unCommentaire;
    private int uneNote;
    private String unCours;
    private int idE = 4;
    private int idEC = 2;
    private int tailleL = 9;

    @Override
    public void setSession(Map<String, Object> s) {
        // TODO Auto-generated method stub
        session = s;
    }

    public String list()
    {
//    if (!session.containsKey("connecte"))
//        return INPUT;
        ListeLivre = livreDAO.getListeLivre();
        trierListeLivre();
        return SUCCESS;
    }
    public String add() {
        if (livre!=null) {
            if (livre.getIsbn().trim().equals("")) {
                this.addFieldError("livre.isbn", "L'ISBN est obligatoire");
                return SUCCESS;
            }
            String str;
            str = livre.getNomAuteur();
            char[] cs = str.toCharArray();
            for(int i = 0; i< cs.length; i++)
            {
                if(Character.isDigit(cs[i]))
                {
                    this.addActionMessage("Le nom d'auteur ne doit pas contenir de chiffre!");
                    return SUCCESS;
                }    
            }
            if (livreDAO.addBook(livre)) {
                this.addActionMessage("Livre ajoute avec succes.");
            } else {
                this.addActionMessage("L'ISBN existe deja.");
            }
        }
        return SUCCESS;
    }
    public String evaluer() {
        ListeCours = coursDAO.getListeCours();
        ListeEvaluation = evaluationDAO.getListeEvaluation();
        ListeEvaluationcours = evaluationcoursDAO.getListeEvaluationcours();
        if (unCours != null) {
            if (unCours.equals("General")) {
                if ((unCommentaire != null) && (uneNote >= 0) && (uneNote <= 10)) {
                    //int id = ListeEvaluation.size();
                    Evaluation e = new Evaluation(idE, (String)session.get("username"), livre.getIsbn(), (short)uneNote, unCommentaire);
                    idE++;
                    ListeEvaluation.add(e);
                }
            } else {
                if ((unCommentaire != null) && (uneNote >= 0) && (uneNote <= 10)) {
                    Evaluationcours ec = new Evaluationcours(idEC, livre.getIsbn(), (String)session.get("username"), unCours, (short)uneNote, unCommentaire);
                    idEC++;
                    ListeEvaluationcours.add(ec);
                }
            }
        }
        ListeCours = coursDAO.getListeCours();
        livre = livreDAO.getBook(livre.getIsbn());
        ListeEvaluation = evaluationDAO.getListeEvaluation();
        ListeEvaluationcours = evaluationcoursDAO.getListeEvaluationcours();
        return SUCCESS;
    }

    public void trierListeLivre() {
        System.out.println("1");
        ListeLivre = livreDAO.getListeLivre();
        System.out.println("2");
        int i = 9;
        boolean change = true;
        System.out.println("3");
        while ((i>0) && (change = true)) {
        System.out.println("4");
            change = false;
            for (int j=0; j>i-1; j++) {
        System.out.println("5");
                if ((j+1)<i) {
                    if (ListeLivre.get(j).getNote() > ListeLivre.get(j+1).getNote()) {
            System.out.println("6");
                        Livre temp = ListeLivre.get(j);
                        ListeLivre.set(j, ListeLivre.get(j+1));
                        ListeLivre.set(j+1, temp);
                        change = true;
            System.out.println("7");
                    }
                }
            }
            i--;
        }
//        System.out.println("1");
//        ListeLivre = livreDAO.getListeLivre();
//        System.out.println("2");
//        int i;
//        for (i = tailleL-1; i > 0; i--) {
//            Livre l = ListeLivre.get(tailleL-1);
//            System.out.println("3");
//            if (ListeLivre.get(i).getNote() < l.getNote()) {
//                System.out.println("4");
//                ListeLivre.set(i, ListeLivre.get(i-1));
//                System.out.println("5");
//            }
//            ListeLivre.set(i, l);
//        }
    }
    
    public void validate()
    {
        if (!session.containsKey("connecte"))
            this.addActionError("Vous devez vous connecter pour accéder aux infos sur les livres");
    }

    public List<Livre> getListeLivre() {
        return ListeLivre;
    }

    public void setListeLivre(List<Livre> listeLivre) {
        this.ListeLivre = listeLivre;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public List<Evaluation> getListeEvaluation() {
        return ListeEvaluation;
    }

    public void setListeEvaluation(List<Evaluation> listeEvaluation) {
        this.ListeEvaluation = listeEvaluation;
    }

    public List<Evaluationcours> getEvaluationcours() {
        return ListeEvaluationcours;
    }

    public void setListeEvaluationcours(List<Evaluationcours> listeEvaluationcours) {
        this.ListeEvaluationcours = listeEvaluationcours;
    }

    public List<Cours> getListeCours() {
        return ListeCours;
    }

    public void setListeCours(List<Cours> listeCours) {
        this.ListeCours = listeCours;
    }

    public String getUnCommentaire() {
        return unCommentaire;
    }

    public void setUnCommentaire(String unCommentaire) {
        this.unCommentaire = unCommentaire;
    }
    
    public int getUneNote() {
        return uneNote;
    }
    
    public void setUneNote(int uneNote) {
        this.uneNote = uneNote;
    }
    
    public String getUncours()
    {
        return unCours;
    }
    
    public void setUnCours(String unCours)
    {
        this.unCours = unCours;
    }

}
