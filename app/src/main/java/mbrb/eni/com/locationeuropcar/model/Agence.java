package mbrb.eni.com.locationeuropcar.model;

/**
 * Created by mblandin2016 on 09/04/2018.
 */

public class Agence {

    private String id;
    private String siret;
    private String voie;
    private String codePostal;
    private String ville;

    public Agence() {
    }

    public Agence(String id, String siret, String voie, String codePostal, String ville) {
        this.id = id;
        this.siret = siret;
        this.voie = voie;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public String getVoie() {
        return voie;
    }

    public void setVoie(String voie) {
        this.voie = voie;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}
