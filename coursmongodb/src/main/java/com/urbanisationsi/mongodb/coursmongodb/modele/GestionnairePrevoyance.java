package com.urbanisationsi.mongodb.coursmongodb.modele;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "gestionprevdb")
public class GestionnairePrevoyance {
    @Id
    private String id;

    @Indexed(unique = true, direction = IndexDirection.DESCENDING)
    private String mail;

    private String motdepasse;

    private String nomcomplet;

    private boolean active;

    @DBRef
    private Set<Role> roles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public String getNomcomplet() {
        return nomcomplet;
    }

    public void setNomcomplet(String nomcomplet) {
        this.nomcomplet = nomcomplet;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((mail == null) ? 0 : mail.hashCode());
        result = prime * result + ((nomcomplet == null) ? 0 : nomcomplet.hashCode());
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
        GestionnairePrevoyance other = (GestionnairePrevoyance) obj;
        if (mail == null) {
            if (other.mail != null)
                return false;
        } else if (!mail.equals(other.mail))
            return false;
        if (nomcomplet == null) {
            if (other.nomcomplet != null)
                return false;
        } else if (!nomcomplet.equals(other.nomcomplet))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "GestionnairePrevoyance [id=" + id + ", mail=" + mail + ", motdepasse=" + motdepasse + ", nomcomplet="
                + nomcomplet + ", active=" + active + ", roles=" + roles + "]";
    }

}
