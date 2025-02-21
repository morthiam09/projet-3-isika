package com.urbanisationsi.springdata10.modele;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // JPA : cette classe est une entité, c'est-à-dire qu'elle est mappée sur une table de la base de données, et que chaque instance de cette classe correspond à une ligne de cette table. Si on avait mis component, on aurait dit que c'est un bean Spring, c'est-à-dire un objet géré par Spring, mais qui n'est pas mappé sur une table de la base de données.
public class Assure {
    @Id // JPA : cette propriété est la clé primaire de la table correspondante
    @GeneratedValue(strategy = GenerationType.AUTO) // JPA : l'attribut id est auto-généré
    private Integer id; // JPA : c'est un attribut de la table Assure généré automatiquement par la base de données
    private String nom;
    private String prenom;
    private Long numeroPersonne; // c'est l'identifiant de la personne, qui est unique (c'est le métier qui donne cet identifiant, pas la base de données)
    @DateTimeFormat(pattern = "yyyy-MM-dd") // Spring : le format de la date de naissance est "yyyy-MM-dd"
    private LocalDate dateNaissance;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public Long getNumeroPersonne() {
        return numeroPersonne;
    }
    public void setNumeroPersonne(Long numeroPersonne) {
        this.numeroPersonne = numeroPersonne;
    }
    public LocalDate getDateNaissance() {
        return dateNaissance;
    }
    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nom == null) ? 0 : nom.hashCode());
        result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
        result = prime * result + ((numeroPersonne == null) ? 0 : numeroPersonne.hashCode());
        result = prime * result + ((dateNaissance == null) ? 0 : dateNaissance.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Assure other = (Assure) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (nom == null) {
            if (other.nom != null)
                return false;
        } else if (!nom.equals(other.nom))
            return false;
        if (prenom == null) {
            if (other.prenom != null)
                return false;
        } else if (!prenom.equals(other.prenom))
            return false;
        if (numeroPersonne == null) {
            if (other.numeroPersonne != null)
                return false;
        } else if (!numeroPersonne.equals(other.numeroPersonne))
            return false;
        if (dateNaissance == null) {
            if (other.dateNaissance != null)
                return false;
        } else if (!dateNaissance.equals(other.dateNaissance))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Assure [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", numeroPersonne=" + numeroPersonne
                + ", dateNaissance=" + dateNaissance + "]";
    }
    
    
}
