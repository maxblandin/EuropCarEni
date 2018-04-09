package mbrb.eni.com.locationeuropcar.model;

import java.util.List;

/**
 * Created by mblandin2016 on 09/04/2018.
 */

public class Utilisateur {
    private String id;
    private String identifiant;
    private String motDePasse;
    private List<Location> locations;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getIdentifiant() {
        return identifiant;
    }
    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getMotDePasse() {
        return motDePasse;
    }
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Utilisateur(){}
    public Utilisateur(String id, String identifiant, String motDePasse) {
        this.id = id;
        this.identifiant = identifiant;
        this.motDePasse = motDePasse;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id='" + id + '\'' +
                ", identifiant='" + identifiant + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                '}';
    }
}
