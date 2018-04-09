package mbrb.eni.com.locationeuropcar.dao;

import mbrb.eni.com.locationeuropcar.model.Voiture;

/**
 * Created by mblandin2016 on 09/04/2018.
 */

public class LocationSQL implements ILocationDAO{
    @Override
    public boolean seConnecter(String identifiant, String motDePasse) {
        return false;
    }

    @Override
    public void louerVoiture(Voiture voiture) {

    }

    @Override
    public void rendreVoiture(Voiture voiture) {

    }
}
