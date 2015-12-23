package com.projet.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.projet.dao.userDAO;
import com.opensymphony.xwork2.ActionSupport;
import com.projet.dao.evaluationDAO;
import com.projet.dao.evaluationcoursDAO;
import com.projet.dao.livreDAO;
import com.projet.entites.Evaluation;
import com.projet.entites.Evaluationcours;
import com.projet.entites.Livre;
import java.util.List;

public class Authentification extends ActionSupport implements SessionAware {

    private Map<String, Object> session;
    private String username, password;
    private List<Livre> ListeLivre;
    private List<Evaluation> ListeEvaluation;
    private List<Evaluationcours> ListeEvaluationcours;
    private userDAO unUserDAO = new userDAO();
    private livreDAO unLivreDAO = new livreDAO();
    private evaluationDAO uneEvaluationDAO = new evaluationDAO();
    private evaluationcoursDAO uneEvaluationcoursDAO = new evaluationcoursDAO();

    @Override
    public void setSession(Map<String, Object> s) {
        // TODO Auto-generated method stub
        session = s;
    }

    public String login() {
        if (unUserDAO.checkLogin(username, password)) {
            session.put("username", username);
            
            //actualisation des données dans la db
            ListeLivre = unLivreDAO.findAll();
            ListeEvaluation = uneEvaluationDAO.findAll();
            ListeEvaluationcours = uneEvaluationcoursDAO.findAll();
            for (int i=0; i<ListeLivre.size(); i++) {
                double total = 0;
                ListeLivre.get(i).setNbEvaluations(0);
                for (int j=0; j<ListeEvaluation.size(); j++) {
                    if (ListeEvaluation.get(j).getIdLivre().equals(ListeLivre.get(i).getIsbn())) {
                        ListeLivre.get(i).setNbEvaluations(ListeLivre.get(i).getNbEvaluations()+1);
                        total = total + ListeEvaluation.get(j).getNote();
                        ListeLivre.get(i).setNote(total/ListeLivre.get(i).getNbEvaluations());
                    }
                }
                for (int j=0; j<ListeEvaluationcours.size(); j++) {
                    if (ListeEvaluationcours.get(j).getIdLivre().equals(ListeLivre.get(i).getIsbn())) {
                        ListeLivre.get(i).setNbEvaluations(ListeLivre.get(i).getNbEvaluations()+1);
                        total = total + ListeEvaluationcours.get(j).getNote();
                        ListeLivre.get(i).setNote(total/ListeLivre.get(i).getNbEvaluations());
                    }
                }
                unLivreDAO.update(ListeLivre.get(i));
            }
            
            session.put("connecte", true);
            return SUCCESS;
        }
        return INPUT;
    }
    public String logout() {
        session.remove("username");
        session.remove("connecte");
        session.clear();
        return SUCCESS;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}