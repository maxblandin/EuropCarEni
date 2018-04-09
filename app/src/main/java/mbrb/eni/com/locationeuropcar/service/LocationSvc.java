package mbrb.eni.com.locationeuropcar.service;

import mbrb.eni.com.locationeuropcar.dao.LocationBouchon;

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
}
