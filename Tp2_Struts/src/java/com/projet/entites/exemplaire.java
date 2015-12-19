package com.projet.entites;

public class exemplaire {
    
    private String isbn, proprietaire, detenteur;
    private int numero;
    
    public exemplaire() {
        this("",0,"","");
    }
    
    public exemplaire(String isbn, int numero, String proprietaire, String detenteur) {
        this.isbn = isbn;
        this.numero = numero;
        this.proprietaire = proprietaire;
        this.detenteur = detenteur;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    public String getDetenteur() {
        return detenteur;
    }

    public void setDetenteur(String detenteur) {
        this.detenteur = detenteur;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
