package mbrb.eni.com.locationeuropcar.dao;

import mbrb.eni.com.locationeuropcar.model.Voiture;

/**
 * Created by mblandin2016 on 09/04/2018.
 */

public class LocationBouchon implements ILocationDAO{
    @Override
    public boolean seConnecter(String identifiant, String motDePasse) {
        boolean isUtilisateur = false;
        if(identifiant.equals("jeanjean") && motDePasse.equals("1234")){
            isUtilisateur = true;
        }
        return isUtilisateur;
    }

    @Override
    public void louerVoiture(Voiture voiture) {

    }

    @Override
    public void rendreVoiture(Voiture voiture) {

    }
}
