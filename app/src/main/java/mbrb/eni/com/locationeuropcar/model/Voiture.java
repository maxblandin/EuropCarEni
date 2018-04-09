package mbrb.eni.com.locationeuropcar.model;

import java.util.Date;

/**
 * Created by mblandin2016 on 09/04/2018.
 */

public class Voiture extends Vehicule {
    private int nbPlace;

    public int getNbPlace() {
        return nbPlace;
    }
    public void setNbPlace(int nbPlace) {
        this.nbPlace = nbPlace;
    }

    public Voiture() {}
    public Voiture(String id, String libelle, Date locationMin, Date locationMax, float tarifMin, float tarifMax, int nbPlace) {
        super(id, libelle, locationMin, locationMax, tarifMin, tarifMax);
        this.nbPlace = nbPlace;
    }
}
