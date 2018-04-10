package mbrb.eni.com.locationeuropcar.dao;

import java.util.List;

import mbrb.eni.com.locationeuropcar.model.Agence;
import mbrb.eni.com.locationeuropcar.dto.LoginDTO;
import mbrb.eni.com.locationeuropcar.model.Reservation;
import mbrb.eni.com.locationeuropcar.model.User;
import mbrb.eni.com.locationeuropcar.model.Vehicule;

/**
 * Created by mblandin2016 on 09/04/2018.
 */

public interface ILocationDAO {
    boolean seConnecter(LoginDTO loginDTO);
    void louerVehicule(Vehicule vehicule);
    void rendreVehicule(Vehicule vehicule);
    Agence creerAgence(String raisonSociale, String siret, String voie, String codePostal, String ville) throws Exception;
    Agence recupererAgence(User u);
    void modifierAgence(Agence agence);
    List<Vehicule> getVehicules();
    List<Reservation> getReservation();
    Vehicule recupererVehicule(String id);
    Reservation recupererReservation(String id);
}
