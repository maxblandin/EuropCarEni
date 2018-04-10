package mbrb.eni.com.locationeuropcar.service;

import java.util.List;

import mbrb.eni.com.locationeuropcar.dao.ILocationDAO;
import mbrb.eni.com.locationeuropcar.dao.LocationBouchon;
import mbrb.eni.com.locationeuropcar.dto.LoginDTO;
import mbrb.eni.com.locationeuropcar.model.Agence;
import mbrb.eni.com.locationeuropcar.model.Reservation;
import mbrb.eni.com.locationeuropcar.model.User;
import mbrb.eni.com.locationeuropcar.model.Vehicule;

/**
 * Created by mblandin2016 on 09/04/2018.
 */

public class LocationSvc {
    ILocationDAO dao = new LocationBouchon();

    public boolean verifierUtilisateur(LoginDTO login){
        boolean isUtilisateur = false;
        if(dao.seConnecter(login)){
            isUtilisateur = true;
        }

        return isUtilisateur;
    }

    public boolean creerAgence(String raisonSociale, String siret, String voie,
                               String codePostal, String ville) {
        boolean creer = true;

        try {
            dao.creerAgence(raisonSociale, siret, voie, codePostal, ville);
        } catch (Exception e) {
            creer = false;
        }

        return creer;
    }

    public Agence recupererAgence(User u) {
        return dao.recupererAgence(u);
    }

    public void modifierAgence(Agence agence) {
        dao.modifierAgence(agence);
    }


    public List<Vehicule> recupererVehicules(){ return dao.getVehicules(); }
    public List<Reservation> recupererReservations(){ return dao.getReservation(); }

    public Vehicule recupererVehicule(String id) {
        return dao.recupererVehicule(id);
    }

    public Reservation recupererReservation(String id) {
        return dao.recupererReservation(id);
    }
}
