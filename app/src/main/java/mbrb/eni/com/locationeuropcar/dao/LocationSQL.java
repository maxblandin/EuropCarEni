package mbrb.eni.com.locationeuropcar.dao;

import java.util.List;

import mbrb.eni.com.locationeuropcar.dto.LoginDTO;
import mbrb.eni.com.locationeuropcar.model.Agence;
import mbrb.eni.com.locationeuropcar.model.Reservation;
import mbrb.eni.com.locationeuropcar.model.User;
import mbrb.eni.com.locationeuropcar.model.Vehicule;

/**
 * Created by mblandin2016 on 09/04/2018.
 */

public class LocationSQL implements ILocationDAO{
    @Override
    public boolean seConnecter(LoginDTO loginDTO) {
        return false;
    }

    @Override
    public void louerVehicule(Vehicule vehicule) {

    }

    @Override
    public void rendreVehicule(Vehicule vehicule) {

    }

    @Override
    public Agence creerAgence(String raisonSociale, String siret, String voie, String codePostal, String ville) throws Exception {
        return null;
    }

    @Override
    public Agence recupererAgence(User u) {
        return null;
    }

    @Override
    public void modifierAgence(Agence agence) {

    }

    @Override
    public List<Vehicule> getVehicules() {
        return null;
    }

    @Override
    public List<Reservation> getReservation() {
        return null;
    }

    @Override
    public Vehicule recupererVehicule(String id) {
        return null;
    }

    @Override
    public Reservation recupererReservation(String id) {
        return null;
    }
}
