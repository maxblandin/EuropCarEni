package mbrb.eni.com.locationeuropcar.model;

import java.util.Date;

/**
 * Created by mblandin2016 on 09/04/2018.
 */

public class Vehicule {
    private String id;
    private String libelle;
    private Date locationMin;
    private Date locationMax;
    private float tarifMin;
    private float tarifMax;

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

    public Vehicule(){};
    public Vehicule(String id, String libelle, Date locationMin, Date locationMax, float tarifMin, float tarifMax) {
        this.id = id;
        this.libelle = libelle;
        this.locationMin = locationMin;
        this.locationMax = locationMax;
        this.tarifMin = tarifMin;
        this.tarifMax = tarifMax;
    }
}
