package com.projet.entites;

public class cours {
    
    private String numero, nom;
    private int duree;
    
    public cours() {
        this("","",0);
    }
    
    public cours(String numero, String nom, int duree) {
        this.numero = numero;
        this.nom = nom;
        this.duree = duree;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }
}
