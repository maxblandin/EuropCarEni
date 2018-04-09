package mbrb.eni.com.locationeuropcar.model;

import java.util.Date;
import java.util.List;

/**
 * Created by mblandin2016 on 09/04/2018.
 */

public class Location {
    private String id;
    private Date dateDebut;
    private Date dateFin;
    private float tarifJournalier;
    private Voiture voiture;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }
    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }
    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public float getTarifJournalier() {
        return tarifJournalier;
    }
    public void setTarifJournalier(float tarifJournalier) {
        this.tarifJournalier = tarifJournalier;
    }

    public Voiture getVoiture(){ return voiture;}
    public void setVoiture(Voiture voiture){
        this.voiture=voiture;
    }

    public Location() {}
    public Location(String id, Date dateDebut, Date dateFin, float tarifJournalier, Voiture voiture) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.tarifJournalier = tarifJournalier;
        this.voiture = voiture;
    }
}
