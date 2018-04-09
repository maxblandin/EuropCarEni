package mbrb.eni.com.locationeuropcar.service;

import mbrb.eni.com.locationeuropcar.dao.ILocationDAO;
import mbrb.eni.com.locationeuropcar.dao.LocationBouchon;
import mbrb.eni.com.locationeuropcar.model.Agence;
import mbrb.eni.com.locationeuropcar.model.Utilisateur;

/**
 * Created by mblandin2016 on 09/04/2018.
 */

public class LocationSvc {
    private LocationBouchon locaB = new LocationBouchon();

    public boolean verifierUtilisateur(String identifiant,String mdp){
        boolean tarace = false;
        if(locaB.seConnecter(identifiant,mdp)){
            tarace = true;
        }

        return tarace;
    }

    public boolean creerAgence(String raisonSociale, String siret, String voie,
                               String codePostal, String ville) {
        boolean creer = true;

        try {
            locaB.creerAgence(raisonSociale, siret, voie, codePostal, ville);
        } catch (Exception e) {
            creer = false;
        }

        return creer;
    }

    public Agence recupererAgence(Utilisateur u) {
        return locaB.recupererAgence(u);
    }

    public void modifierAgence(Agence agence) {
        locaB.modifierAgence(agence);
    }
}
