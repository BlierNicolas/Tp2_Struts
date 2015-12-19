package com.projet.entites;

public class evaluationcours {
    
    private String idLivre, idProf, idCours, commentaire;
    private int id, note;
    
    public evaluationcours() {
        this("","","",0,"");
    }
    
    public evaluationcours(String idLivre, String idProf, String idCours, int note, String commentaire) {
        this.idLivre = idLivre;
        this.idProf = idProf;
        this.idCours = idCours;
        this.note = note;
        this.commentaire = commentaire;
    }

    public String getIdLivre() {
        return idLivre;
    }

    public void setIdLivre(String idLivre) {
        this.idLivre = idLivre;
    }

    public String getIdProf() {
        return idProf;
    }

    public void setIdProf(String idProf) {
        this.idProf = idProf;
    }

    public String getIdCours() {
        return idCours;
    }

    public void setIdCours(String idCours) {
        this.idCours = idCours;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }
}
