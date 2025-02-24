package com.urbanisationsi.springdata10.modele;


import jakarta.persistence.Entity;


@Entity // JPA : cette classe est une entité, c'est-à-dire qu'elle est mappée sur une table de la base de données, et que chaque instance de cette classe correspond à une ligne de cette table. Si on avait mis component, on aurait dit que c'est un bean Spring, c'est-à-dire un objet géré par Spring, mais qui n'est pas mappé sur une table de la base de données.
public class Assure extends Personne {
    
    private Long numeroAssure;
    private String dossierMedical;
    
    public Long getNumeroAssure() {
        return numeroAssure;
    }
    public void setNumeroAssure(Long numeroAssure) {
        this.numeroAssure = numeroAssure;
    }
    public String getDossierMedical() {
        return dossierMedical;
    }
    public void setDossierMedical(String dossierMedical) {
        this.dossierMedical = dossierMedical;
    }
    @Override
    public String toString() {
        return "\nAssure [numeroAssure=" + numeroAssure + ", dossierMedical=" + dossierMedical + ", getId()=" + getId()
                + ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom() + ", getNumeroPersonne()="
                + getNumeroPersonne() + ", getDateNaissance()=" + getDateNaissance() + "]\n";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((numeroAssure == null) ? 0 : numeroAssure.hashCode());
        result = prime * result + ((dossierMedical == null) ? 0 : dossierMedical.hashCode());
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
        Assure other = (Assure) obj;
        if (numeroAssure == null) {
            if (other.numeroAssure != null)
                return false;
        } else if (!numeroAssure.equals(other.numeroAssure))
            return false;
        if (dossierMedical == null) {
            if (other.dossierMedical != null)
                return false;
        } else if (!dossierMedical.equals(other.dossierMedical))
            return false;
        return true;
    }
    
}
