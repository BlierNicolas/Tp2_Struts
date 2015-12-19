package com.projet.entites;

public class user {
    
    private String username, nom_prenom, password;
    
    public user() {
        this("","","");
    }
    
    public user(String username, String nom_prenom, String password) {
        this.username = username;
        this.nom_prenom = nom_prenom;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNom_prenom() {
        return nom_prenom;
    }

    public void setNom_prenom(String nom_prenom) {
        this.nom_prenom = nom_prenom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
