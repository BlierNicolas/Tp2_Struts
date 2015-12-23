/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.entites;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nicolas
 */
@Entity
@Table(name = "evaluationcours")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evaluationcours.findAll", query = "SELECT e FROM Evaluationcours e"),
    @NamedQuery(name = "Evaluationcours.findById", query = "SELECT e FROM Evaluationcours e WHERE e.id = :id"),
    @NamedQuery(name = "Evaluationcours.findByIdLivre", query = "SELECT e FROM Evaluationcours e WHERE e.idLivre = :idLivre"),
    @NamedQuery(name = "Evaluationcours.findByIdProf", query = "SELECT e FROM Evaluationcours e WHERE e.idProf = :idProf"),
    @NamedQuery(name = "Evaluationcours.findByIdCours", query = "SELECT e FROM Evaluationcours e WHERE e.idCours = :idCours"),
    @NamedQuery(name = "Evaluationcours.findByNote", query = "SELECT e FROM Evaluationcours e WHERE e.note = :note"),
    @NamedQuery(name = "Evaluationcours.findByCommentaire", query = "SELECT e FROM Evaluationcours e WHERE e.commentaire = :commentaire")})
public class Evaluationcours implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "idLivre")
    private String idLivre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "idProf")
    private String idProf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "idCours")
    private String idCours;
    @Basic(optional = false)
    @NotNull
    @Column(name = "note")
    private short note;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "commentaire")
    private String commentaire;

    public Evaluationcours() {
    }

    public Evaluationcours(Integer id) {
        this.id = id;
    }

    public Evaluationcours(String idLivre, String idProf, String idCours, short note, String commentaire) {
        this.idLivre = idLivre;
        this.idProf = idProf;
        this.idCours = idCours;
        this.note = note;
        this.commentaire = commentaire;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public short getNote() {
        return note;
    }

    public void setNote(short note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evaluationcours)) {
            return false;
        }
        Evaluationcours other = (Evaluationcours) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.projet.entites.Evaluationcours[ id=" + id + " ]";
    }
    
}
