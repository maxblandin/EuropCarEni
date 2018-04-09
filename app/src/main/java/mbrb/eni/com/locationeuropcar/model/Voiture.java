package mbrb.eni.com.locationeuropcar.model;

import java.util.Date;

/**
 * Created by mblandin2016 on 09/04/2018.
 */

public class Voiture {
    private String id;
    private String libelle;
    private int nbPlaces;
    private float tarifMin;
    private float tarifMax;
    private Date locationMin;
    private Date locationMax;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getNbPlaces() {
        return nbPlaces;
    }
    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    public float getTarifMin() {
        return tarifMin;
    }
    public void setTarifMin(float tarifMin) {
        this.tarifMin = tarifMin;
    }

    public float getTarifMax() {
        return tarifMax;
    }
    public void setTarifMax(float tarifMax) {
        this.tarifMax = tarifMax;
    }

    public Date getLocationMin() {
        return locationMin;
    }
    public void setLocationMin(Date locationMin) {
        this.locationMin = locationMin;
    }

    public Date getLocationMax() {
        return locationMax;
    }
    public void setLocationMax(Date locationMax) {
        this.locationMax = locationMax;
    }

    public Voiture() {}
    public Voiture(String id, String libelle, int nbPlaces, float tarifMin, float tarifMax, Date locationMin, Date locationMax) {
        this.id = id;
        this.libelle = libelle;
        this.nbPlaces = nbPlaces;
        this.tarifMin = tarifMin;
        this.tarifMax = tarifMax;
        this.locationMin = locationMin;
        this.locationMax = locationMax;
    }
}
