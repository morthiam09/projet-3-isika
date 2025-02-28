package com.urbanisationsi.springdataH2.modele;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private Long numeroProduit;
    private double prix;

    @ManyToMany(fetch = FetchType.EAGER)// Signifie que la relation est de type ManyToMany, c'est-à-dire que plusieurs produits peuvent avoir plusieurs garanties
    @JoinTable(
        name = "produit_garantie", // Nom de la table de jointure
        joinColumns = @JoinColumn(name = "produit_id", referencedColumnName = "id"), // Nom de la colonne de la table de jointure qui fait référence à la table Produit
         inverseJoinColumns = @JoinColumn(name = "garantie_id", referencedColumnName = "id") // Nom de la colonne de la table de jointure qui fait référence à la table Garantie
    )
    
    private Set<Garantie> garanties = new HashSet<>();

    // Constructeurs, Getters et Setters
    public Produit() {}

    public Produit(String nom, Long numeroProduit, double prix) {
        this.nom = nom;
        this.numeroProduit = numeroProduit;
        this.prix = prix;
    }

    public Long getId() { return id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public double getPrix() { return prix; }
    public void setPrix(double prix) { this.prix = prix; }
    public Set<Garantie> getGaranties() { return garanties; }
    public void setGaranties(Set<Garantie> garanties) { this.garanties = garanties; }
    public Long getNumeroProduit() { return numeroProduit;    }
    public void setNumeroProduit(Long numeroProduit) { this.numeroProduit = numeroProduit; }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nom == null) ? 0 : nom.hashCode());
        result = prime * result + ((numeroProduit == null) ? 0 : numeroProduit.hashCode());
        long temp;
        temp = Double.doubleToLongBits(prix);
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
        Produit other = (Produit) obj;
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
        if (numeroProduit == null) {
            if (other.numeroProduit != null)
                return false;
        } else if (!numeroProduit.equals(other.numeroProduit))
            return false;
        if (Double.doubleToLongBits(prix) != Double.doubleToLongBits(other.prix))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Produit [id=" + id + ", nom=" + nom + ", numeroProduit=" + numeroProduit + ", prix=" + prix
                + ", garanties= " + garanties.size() + "]";
    }
    
}

