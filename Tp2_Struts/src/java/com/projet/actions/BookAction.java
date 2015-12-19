package com.projet.actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.projet.dao.livreDAO;
import com.opensymphony.xwork2.ActionSupport;
import com.projet.dao.evaluationDAO;
import com.projet.entites.evaluation;
import com.projet.entites.livre;

public class BookAction extends ActionSupport implements SessionAware {

    private Map<String, Object> session;
    private List<livre> ListeLivre ;//= LivreDAO.getBookList();
    private livre unLivre ;//= new Book();
    private List<String> commentaires;
    private String unCommentaire;
    private livreDAO unLivreDAO = new livreDAO(Connexion.getInstance());
    private evaluationDAO uneEvaluationDAO = new evaluationDAO(Connexion.getInstance());

    @Override
    public void setSession(Map<String, Object> s) {
        // TODO Auto-generated method stub
        session = s;
    }

    public String list()
    {
 //   if (!session.containsKey("connecte"))
 //   	return INPUT;
        ListeLivre = unLivreDAO.findAll();
        return SUCCESS;
    }
    public String add()
    {
        if (unLivre!=null)
        {
            if (unLivre.getISBN().trim().equals(""))
            {
                this.addFieldError("livre.isbn", "L'ISBN est obligatoire");
                return SUCCESS;
            }
            if (unLivreDAO.create(unLivre))
            {
                this.addActionMessage("Livre ajoute avec succes.");
            }
            else
            {
                this.addActionMessage("L'ISBN existe deja.");
            }
        }
        return SUCCESS;
    }
    public String comment()
    {
        if (unCommentaire != null)
        {
            evaluation uneEvaluation = new evaluation((String)session.get("username"), unLivre.getISBN(), 0, unCommentaire);
            uneEvaluationDAO.create(uneEvaluation);
        }
        unLivre = unLivreDAO.read(unLivre.getISBN());
        List<evaluation> uneListeEvaluations = uneEvaluationDAO.findAll();
        for (int i=0; i<uneListeEvaluations.size();i++) {
            commentaires.add(uneListeEvaluations.get(i).getCommentaire());
        }
        return SUCCESS;
    }

    
    public void validate()
    {
        if (!session.containsKey("connecte"))
            this.addActionError("Vous devez vous connecter pour accéder aux infos sur les livres");
    }

    public List<livre> getBookList() {
        return ListeLivre;
    }

    public void setBookList(List<livre> uneListeLivre) {
        this.ListeLivre = uneListeLivre;
    }

    public livre getLivre() {
        return unLivre;
    }

    public void setLivre(livre unLivre) {
        this.unLivre = unLivre;
    }

    public List<String> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<String> commentaires) {
        this.commentaires = commentaires;
    }

    public String getUnCommentaire() {
        return unCommentaire;
    }

    public void setUnCommentaire(String unCommentaire) {
        this.unCommentaire = unCommentaire;
    }	
	
}
