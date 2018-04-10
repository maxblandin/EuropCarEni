package mbrb.eni.com.locationeuropcar.model;

import java.util.Date;
import java.util.List;

/**
 * Created by mblandin2016 on 09/04/2018.
 */

public class Reservation {
    private String reservationId;
    private Date dateDebut;
    private Date dateFin;
    private float tarifJournalier;
    private Vehicule vehicule;

    public Reservation() {
    }

    public Reservation(String reservationId, Date dateDebut, Date dateFin, float tarifJournalier, Vehicule vehicule) {
        this.reservationId = reservationId;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.tarifJournalier = tarifJournalier;
        this.vehicule = vehicule;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
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

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }
}
