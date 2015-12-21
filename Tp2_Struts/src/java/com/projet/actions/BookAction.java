package com.projet.actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.projet.dao.livreDAO;
import com.projet.entites.Livre;
import com.opensymphony.xwork2.ActionSupport;
import com.projet.dao.evaluationDAO;
import com.projet.dao.evaluationcoursDAO;
import com.projet.entites.Evaluation;
import com.projet.entites.Evaluationcours;

public class BookAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private List<Livre> ListeLivre ;//= LivreDAO.getBookList();
	private Livre livre ;//= new Book();
	private List<Evaluation> ListeEvaluation;
	private List<Evaluationcours> ListeEvaluationcours;
	private String unCommentaire;
        private int uneNote;
        private String unCours;
	
	@Override
	public void setSession(Map<String, Object> s) {
            // TODO Auto-generated method stub
            session = s;
	}

	public String list()
	{
     //   if (!session.containsKey("connecte"))
     //   	return INPUT;

            ListeLivre = livreDAO.getLivreList();
            return SUCCESS;
	}
        public String add() {
            if (livre!=null) 
            {
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
            int id = ListeEvaluation.size();
            if ((unCommentaire != null) && (uneNote >= 0) && (uneNote <= 10)) {
                Evaluation e = new Evaluation(id, (String)session.get("username"), livre.getIsbn(), (short)uneNote, unCommentaire);
                evaluationDAO.addEvaluation(e);
            }
            livre = livreDAO.getBook(livre.getIsbn());
            ListeEvaluation = evaluationDAO.getListeEvaluation();
            return SUCCESS;
        }
        public String evaluercours() {
            int id = ListeEvaluation.size();
            if ((unCommentaire != null) && (uneNote >= 0) && (uneNote <= 10) && (unCours != null)) {
                Evaluationcours ec = new Evaluationcours(id, livre.getIsbn(), (String)session.get("username"), unCours, (short)uneNote, unCommentaire);
                evaluationcoursDAO.addEvaluationcours(ec);
            }
            livre = livreDAO.getBook(livre.getIsbn());
            ListeEvaluationcours = evaluationcoursDAO.getListeEvaluationcours();
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

    public List<Evaluation> getEvaluation() {
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
