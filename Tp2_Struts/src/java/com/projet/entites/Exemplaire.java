package com.projet.entites; 

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "exemplaire")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Exemplaire.findAll", query = "SELECT e FROM Exemplaire e"),
    @NamedQuery(name = "Exemplaire.findByIsbn", query = "SELECT e FROM Exemplaire e WHERE e.exemplairePK.isbn = :isbn"),
    @NamedQuery(name = "Exemplaire.findByNumero", query = "SELECT e FROM Exemplaire e WHERE e.exemplairePK.numero = :numero"),
    @NamedQuery(name = "Exemplaire.findByProprietaire", query = "SELECT e FROM Exemplaire e WHERE e.proprietaire = :proprietaire"),
    @NamedQuery(name = "Exemplaire.findByDetenteur", query = "SELECT e FROM Exemplaire e WHERE e.detenteur = :detenteur")})
public class Exemplaire implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ExemplairePK exemplairePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "proprietaire")
    private String proprietaire;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "detenteur")
    private String detenteur;

    public Exemplaire() {
    }

    public Exemplaire(ExemplairePK exemplairePK) {
        this.exemplairePK = exemplairePK;
    }

    public Exemplaire(ExemplairePK exemplairePK, String proprietaire, String detenteur) {
        this.exemplairePK = exemplairePK;
        this.proprietaire = proprietaire;
        this.detenteur = detenteur;
    }

    public Exemplaire(String isbn, short numero) {
        this.exemplairePK = new ExemplairePK(isbn, numero);
    }

    public ExemplairePK getExemplairePK() {
        return exemplairePK;
    }

    public void setExemplairePK(ExemplairePK exemplairePK) {
        this.exemplairePK = exemplairePK;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (exemplairePK != null ? exemplairePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exemplaire)) {
            return false;
        }
        Exemplaire other = (Exemplaire) object;
        if ((this.exemplairePK == null && other.exemplairePK != null) || (this.exemplairePK != null && !this.exemplairePK.equals(other.exemplairePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.projet.entites.Exemplaire[ exemplairePK=" + exemplairePK + " ]";
    }
    
}
