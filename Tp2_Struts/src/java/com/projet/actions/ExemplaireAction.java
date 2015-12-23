package com.projet.actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.projet.dao.exemplaireDAO;
import com.projet.entites.Exemplaire;
import com.projet.entites.ExemplairePK;

public class ExemplaireAction extends ActionSupport implements SessionAware {

    private Map<String, Object> session;
    private List<Exemplaire> ListeExemplaire;
    private Exemplaire exemplaire;
    private ExemplairePK exemplairePK;
    private String unIsbn;
    private int unNumero;
    private String unProprietaire;
    private String unDetenteur;
    private exemplaireDAO unExemplaireDAO = new exemplaireDAO();

    @Override
    public void setSession(Map<String, Object> s) {
        // TODO Auto-generated method stub
        session = s;
    }

    public String list()
    {
//    if (!session.containsKey("connecte"))
//        return INPUT;
        ListeExemplaire = unExemplaireDAO.findAll();
        return SUCCESS;
    }
    public String addExemplaire() {
//        if (unNumero != 0)
//            exemplairePK = new ExemplairePK(unIsbn, (short)unNumero);
        if (exemplairePK!=null) {
            if (exemplairePK.getIsbn().trim().equals("")) {
                this.addFieldError("exemplairePK.isbn", "L'ISBN est obligatoire");
                return SUCCESS;
            }
            if (exemplaire.getProprietaire().trim().equals("")) {
                this.addFieldError("exemplaire.proprietaire", "Le nom du propriétaire est obligatoire");
                return SUCCESS;
            }
            if(exemplaire.getDetenteur().trim().equals(""))
                exemplaire.setDetenteur(exemplaire.getProprietaire());
            exemplaire.setExemplairePK(exemplairePK);
            if (unExemplaireDAO.add(exemplaire)) {
                this.addActionMessage("L'exemplaire a ete ajoute avec succes.");
            } else {
                this.addActionMessage("L'ISBN existe deja.");
            }
        }
        return SUCCESS;
    }
    
    public void validate() {
        if (!session.containsKey("connecte"))
            this.addActionError("Vous devez vous connecter pour accéder aux infos sur les livres");
    }

    public List<Exemplaire> getListeExemplaire() {
        return ListeExemplaire;
    }

    public void setListeExemplaire(List<Exemplaire> listeExemplaire) {
        this.ListeExemplaire = listeExemplaire;
    }

    public Exemplaire getExemplaire() {
        return exemplaire;
    }

    public void setExemplaire(Exemplaire exemplaire) {
        this.exemplaire = exemplaire;
    }

    public ExemplairePK getExemplairePK() {
        return exemplairePK;
    }

    public void setExemplairePK(ExemplairePK exemplairePK) {
        this.exemplairePK = exemplairePK;
    }

    public String getUnIsbn() {
        return unIsbn;
    }

    public void setUnIsbn(String unIsbn) {
        this.unIsbn = unIsbn;
    }

    public int getUnNumero() {
        return unNumero;
    }

    public void setUnNumero(int unNumero) {
        this.unNumero = unNumero;
    }

    public String getUnProprietaire() {
        return unProprietaire;
    }

    public void setUnProprietaire(String unProprietaire) {
        this.unProprietaire = unProprietaire;
    }
    
    public String getUnDetenteur() {
        return unDetenteur;
    }
    
    public void setUnDetenteur(String unDetenteur) {
        this.unDetenteur = unDetenteur;
    }

}
