package com.urbanisationsi.springdata04.modele;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class ConseillerBancaire extends Personne{

    int numeroBureau;

    public int getNumeroBureau() {
        return numeroBureau;
    }

    public void setNumeroBureau(int numeroBureau) {
        this.numeroBureau = numeroBureau;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + numeroBureau;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        ConseillerBancaire other = (ConseillerBancaire) obj;
        if (numeroBureau != other.numeroBureau)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "\nConseillerBancaire [numeroBureau=" + numeroBureau + ", getNom()=" + getNom() + ", getPrenom()="
                + getPrenom() + ", getNumeroPersonne()=" + getNumeroPersonne() + ", getDateNaissance()="
                + getDateNaissance() + "]\n";
    }

 

}
