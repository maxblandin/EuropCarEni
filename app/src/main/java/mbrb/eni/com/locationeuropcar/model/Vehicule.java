package mbrb.eni.com.locationeuropcar.model;

import java.util.Date;

/**
 * Created by mblandin2016 on 09/04/2018.
 */

public class Vehicule {
    private String id;
    private String libelle;
    private int nbJourLocationMin;
    private int nbJourLocationMax;
    private float tarifMin;
    private float tarifMax;
    private boolean isDisponible;
    private int nbPlaces;

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

    public int getNbJourLocationMin() {
        return nbJourLocationMin;
    }
    public void setNbJourLocationMin(int nbJourLocationMin) {
        this.nbJourLocationMin = nbJourLocationMin;
    }

    public int getNbJourLocationMax() {
        return nbJourLocationMax;
    }
    public void setNbJourLocationMax(int nbJourLocationMax) {
        this.nbJourLocationMax = nbJourLocationMax;
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

    public boolean isDisponible() {
        return isDisponible;
    }
    public void setDisponible(boolean disponible) {
        isDisponible = disponible;
    }

    public int getNbPlaces() {
        return nbPlaces;
    }
    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    public Vehicule(){};
    public Vehicule(String id, String libelle, int nbJourLocationMin, int nbJourLocationMax, float tarifMin, float tarifMax, boolean isDisponible, int nbPlaces) {
        this.id = id;
        this.libelle = libelle;
        this.nbJourLocationMin = nbJourLocationMin;
        this.nbJourLocationMax = nbJourLocationMax;
        this.tarifMin = tarifMin;
        this.tarifMax = tarifMax;
        this.isDisponible = isDisponible;
        this.nbPlaces = nbPlaces;
    }
}
