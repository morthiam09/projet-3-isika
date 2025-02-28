package com.urbanisationsi.springapirest.modele;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Garantie {
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long numeroGarantie;
    private String libelle;


    @ManyToMany(mappedBy = "garanties", fetch = FetchType.EAGER) // Signifie que la relation est de type ManyToMany, c'est-à-dire que plusieurs garanties peuvent être associées à plusieurs
    private Set<Produit> produits = new HashSet<>();

    // Constructeurs, Getters et Setters
    public Garantie() {}

    public Garantie(Long numeroGarantie, String libelle) {
        this.numeroGarantie = numeroGarantie;
        this.libelle = libelle;
    }

    public Long getId() { return id; }
    public String getDescription() { return libelle; }
    public void setDescription(String libelle) { this.libelle = libelle; }
    public Set<Produit> getProduits() { return produits; }
    public void setProduits(Set<Produit> produits) { this.produits = produits; }
    public Long getNumeroGarantie() { return numeroGarantie; }
    public void setNumeroGarantie(Long numeroGarantie) { this.numeroGarantie = numeroGarantie; }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((numeroGarantie == null) ? 0 : numeroGarantie.hashCode());
        result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
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
        Garantie other = (Garantie) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (numeroGarantie == null) {
            if (other.numeroGarantie != null)
                return false;
        } else if (!numeroGarantie.equals(other.numeroGarantie))
            return false;
        if (libelle == null) {
            if (other.libelle != null)
                return false;
        } else if (!libelle.equals(other.libelle))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Garantie [id=" + id + ", numeroGarantie=" + numeroGarantie + ", description=" + libelle
                + ", produits= " + produits.size() + "]";
    }
   
}

