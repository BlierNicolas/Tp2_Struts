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
import com.projet.entites.User;
import java.util.List;

public class Authentification extends ActionSupport implements SessionAware {

    private Map<String, Object> session;
    private String username, password;
    private List<Livre> ListeLivre;
    private Livre livre;
    private List<Evaluation> ListeEvaluation;
    private Evaluation evaluation;
    private List<Evaluationcours> ListeEvaluationcours;
    private Evaluationcours evaluationcours;

    @Override
    public void setSession(Map<String, Object> s) {
        // TODO Auto-generated method stub
        session = s;
    }

    public String login()
    {
        if (userDAO.checkLogin(username, password))
        {
            session.put("username", username);
            
            ListeLivre = livreDAO.getListeLivre();
            ListeEvaluation = evaluationDAO.getListeEvaluation();
            ListeEvaluationcours = evaluationcoursDAO.getListeEvaluationcours();
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
            }
            
            session.put("connecte", true);
            return SUCCESS;
        }
        return INPUT;
    }
    public String logout()
    {
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
