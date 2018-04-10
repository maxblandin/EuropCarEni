package mbrb.eni.com.locationeuropcar.dto;

/**
 * Created by mblandin2016 on 10/04/2018.
 */

public class LoginDTO {
    private String identifiant;
    private String motDePasse;
    private String token;

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

    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }

    public LoginDTO(String identifiant, String motDePasse, String token) {
        this.identifiant = identifiant;
        this.motDePasse = motDePasse;
        this.token = token;
    }
}
