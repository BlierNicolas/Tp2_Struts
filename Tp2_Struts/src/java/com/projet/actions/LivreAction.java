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
import java.util.LinkedList;

public class LivreAction extends ActionSupport implements SessionAware {

    private Map<String, Object> session;
    private List<Livre> ListeLivre;
    private Livre livre;
    private List<Evaluation> ListeEvaluation, ListeEvaluationSpecifique;
    private Evaluation evaluation;
    private List<Evaluationcours> ListeEvaluationcours;
    private List<Cours> ListeCours;
    private Cours cours;
    private String unCommentaire;
    private int uneNote;
    private String unCours;
    private livreDAO unLivreDAO = new livreDAO();
    private coursDAO unCoursDAO = new coursDAO();
    private evaluationDAO uneEvaluationDAO = new evaluationDAO();
    private evaluationcoursDAO uneEvaluationcoursDAO = new evaluationcoursDAO();

    @Override
    public void setSession(Map<String, Object> s) {
        // TODO Auto-generated method stub
        session = s;
    }

    public String list() {
        ListeLivre = unLivreDAO.findAll(); //le findAll sort la liste déjà triée
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
            for(int i = 0; i< cs.length; i++) {
                if(Character.isDigit(cs[i])) {
                    this.addActionMessage("Le nom d'auteur ne doit pas contenir de chiffre!");
                    return SUCCESS;
                }    
            }
            if (unLivreDAO.add(livre)) {
                this.addActionMessage("Livre ajoute avec succes.");
            } else {
                this.addActionMessage("L'ISBN existe deja.");
            }
        }
        return SUCCESS;
    }
    public String evaluer() {
        ListeCours = unCoursDAO.findAll();
        ListeEvaluation = uneEvaluationDAO.findAll();
        ListeEvaluationcours = uneEvaluationcoursDAO.findAll();
        if (unCours != null) {
            if (unCours.equals("General")) {
                if ((unCommentaire != null) && (uneNote >= 0) && (uneNote <= 10)) {
                    Evaluation e = new Evaluation((String)session.get("username"), livre.getIsbn(), (short)uneNote, unCommentaire);
                    uneEvaluationDAO.add(e);
                }
            } else {
                if ((unCommentaire != null) && (uneNote >= 0) && (uneNote <= 10)) {
                    Evaluationcours ec = new Evaluationcours(livre.getIsbn(), (String)session.get("username"), unCours, (short)uneNote, unCommentaire);
                    uneEvaluationcoursDAO.add(ec);
                }
            }
        }
        livre = unLivreDAO.find(livre.getIsbn());
        ListeEvaluationSpecifique = new LinkedList<Evaluation>();
        for (int i=0; i<ListeEvaluation.size();i++) {
            if (ListeEvaluation.get(i).getIdLivre().equals(livre.getIsbn())) {
                ListeEvaluationSpecifique.add(ListeEvaluation.get(i));
            }
        }
        return SUCCESS;
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

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
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

    public List<Evaluation> getListeEvaluationSpecifique() {
        return ListeEvaluationSpecifique;
    }

    public void setListeEvaluationSpecifique(List<Evaluation> listeEvaluationSpecifique) {
        this.ListeEvaluationSpecifique = listeEvaluationSpecifique;
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
