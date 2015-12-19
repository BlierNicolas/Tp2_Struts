package com.projet.entites;

import java.util.Objects;

public class livre {
    private String ISBN, Titre, Edition, MotsCles, NomAuteur, etat, Description;
    private int Annee, NbPages, nbEvaluations;
    private double note;
    
    public livre() {
        this("","","",0,"","","","",0,0,0);
    }
    
    public livre(String ISBN, String Titre, String Edition, int Annee, String MotsCles, String NomAuteur, String etat, String Description, int NbPages, double note, int nbEvaluations) {
        this.ISBN = ISBN;
        this.Titre = Titre;
        this.Edition = Edition;
        this.Annee = Annee;
        this.MotsCles = MotsCles;
        this.NomAuteur = NomAuteur;
        this.etat = etat;
        this.Description = Description;
        this.NbPages = NbPages;
        this.note = note;
        this.nbEvaluations = nbEvaluations;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String Titre) {
        this.Titre = Titre;
    }

    public String getEdition() {
        return Edition;
    }

    public void setEdition(String Edition) {
        this.Edition = Edition;
    }

    public String getMotsCles() {
        return MotsCles;
    }

    public void setMotsCles(String MotsCles) {
        this.MotsCles = MotsCles;
    }

    public String getNomAuteur() {
        return NomAuteur;
    }

    public void setNomAuteur(String NomAuteur) {
        this.NomAuteur = NomAuteur;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getAnnee() {
        return Annee;
    }

    public void setAnnee(int Annee) {
        this.Annee = Annee;
    }

    public int getNbPages() {
        return NbPages;
    }

    public void setNbPages(int NbPages) {
        this.NbPages = NbPages;
    }

    public int getNbEvaluations() {
        return nbEvaluations;
    }

    public void setNbEvaluations(int nbEvaluations) {
        this.nbEvaluations = nbEvaluations;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof livre)
            return this.ISBN.equalsIgnoreCase(((livre)obj).ISBN);
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.ISBN);
        return hash;
    }
}
