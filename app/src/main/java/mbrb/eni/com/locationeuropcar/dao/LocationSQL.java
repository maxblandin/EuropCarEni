package mbrb.eni.com.locationeuropcar.dao;

import mbrb.eni.com.locationeuropcar.model.Agence;
import mbrb.eni.com.locationeuropcar.model.User;
import mbrb.eni.com.locationeuropcar.model.Vehicule;

/**
 * Created by mblandin2016 on 09/04/2018.
 */

public class LocationSQL implements ILocationDAO{
    @Override
    public boolean seConnecter(String identifiant, String motDePasse) {
        return false;
    }

    @Override
    public void louerVehicule(Vehicule vehicule) {

    }

    @Override
    public void rendreVehicule(Vehicule vehicule) {

    }

    @Override
    public Agence creerAgence(String raisonSociale, String siret, String voie, String codePostal, String ville) throws Exception {
        return null;
    }

    @Override
    public Agence recupererAgence(User u) {
        return null;
    }

    @Override
    public void modifierAgence(Agence agence) {

    }
}
