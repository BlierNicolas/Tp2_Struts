package com.projet.entites;

public class evaluation {
    
    private String idProf, idLivre, commentaire;
    private int id, note;
    
    public evaluation() {
        this("","",0,"");
    }
    
    public evaluation(String idProf, String idLivre, int note, String commentaire) {
        this.idProf = idProf;
        this.idLivre = idLivre;
        this.note = note;
        this.commentaire = commentaire;
    }

    public String getIdProf() {
        return idProf;
    }

    public void setIdProf(String idProf) {
        this.idProf = idProf;
    }

    public String getIdLivre() {
        return idLivre;
    }

    public void setIdLivre(String idLivre) {
        this.idLivre = idLivre;
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
