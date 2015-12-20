package com.projet.entites; 

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "livre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Livre.findAll", query = "SELECT l FROM Livre l"),
    @NamedQuery(name = "Livre.findByIsbn", query = "SELECT l FROM Livre l WHERE l.isbn = :isbn"),
    @NamedQuery(name = "Livre.findByTitre", query = "SELECT l FROM Livre l WHERE l.titre = :titre"),
    @NamedQuery(name = "Livre.findByEdition", query = "SELECT l FROM Livre l WHERE l.edition = :edition"),
    @NamedQuery(name = "Livre.findByAnnee", query = "SELECT l FROM Livre l WHERE l.annee = :annee"),
    @NamedQuery(name = "Livre.findByMotsCles", query = "SELECT l FROM Livre l WHERE l.motsCles = :motsCles"),
    @NamedQuery(name = "Livre.findByNomAuteur", query = "SELECT l FROM Livre l WHERE l.nomAuteur = :nomAuteur"),
    @NamedQuery(name = "Livre.findByEtat", query = "SELECT l FROM Livre l WHERE l.etat = :etat"),
    @NamedQuery(name = "Livre.findByNbPages", query = "SELECT l FROM Livre l WHERE l.nbPages = :nbPages"),
    @NamedQuery(name = "Livre.findByNote", query = "SELECT l FROM Livre l WHERE l.note = :note"),
    @NamedQuery(name = "Livre.findByNbEvaluations", query = "SELECT l FROM Livre l WHERE l.nbEvaluations = :nbEvaluations")})
public class Livre implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ISBN")
    private String isbn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Titre")
    private String titre;
    @Size(max = 20)
    @Column(name = "Edition")
    private String edition;
    @Column(name = "Annee")
    private Integer annee;
    @Size(max = 255)
    @Column(name = "MotsCles")
    private String motsCles;
    @Size(max = 30)
    @Column(name = "NomAuteur")
    private String nomAuteur;
    @Size(max = 15)
    @Column(name = "etat")
    private String etat;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "Description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NbPages")
    private int nbPages;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "note")
    private Double note;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nbEvaluations")
    private int nbEvaluations;

    public Livre() {
    }

    public Livre(String isbn) {
        this.isbn = isbn;
    }

    public Livre(String isbn, String titre, String description, int nbPages, int nbEvaluations) {
        this.isbn = isbn;
        this.titre = titre;
        this.description = description;
        this.nbPages = nbPages;
        this.nbEvaluations = nbEvaluations;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }

    public String getMotsCles() {
        return motsCles;
    }

    public void setMotsCles(String motsCles) {
        this.motsCles = motsCles;
    }

    public String getNomAuteur() {
        return nomAuteur;
    }

    public void setNomAuteur(String nomAuteur) {
        this.nomAuteur = nomAuteur;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNbPages() {
        return nbPages;
    }

    public void setNbPages(int nbPages) {
        this.nbPages = nbPages;
    }

    public Double getNote() {
        return note;
    }

    public void setNote(Double note) {
        this.note = note;
    }

    public int getNbEvaluations() {
        return nbEvaluations;
    }

    public void setNbEvaluations(int nbEvaluations) {
        this.nbEvaluations = nbEvaluations;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (isbn != null ? isbn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Livre)) {
            return false;
        }
        Livre other = (Livre) object;
        if ((this.isbn == null && other.isbn != null) || (this.isbn != null && !this.isbn.equals(other.isbn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.projet.entites.Livre[ isbn=" + isbn + " ]";
    }
    
}
