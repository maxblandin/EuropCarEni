package mbrb.eni.com.locationeuropcar.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import mbrb.eni.com.locationeuropcar.model.Agence;
import mbrb.eni.com.locationeuropcar.dto.LoginDTO;
import mbrb.eni.com.locationeuropcar.model.Reservation;
import mbrb.eni.com.locationeuropcar.model.User;
import mbrb.eni.com.locationeuropcar.model.Vehicule;

/**
 * Created by mblandin2016 on 09/04/2018.
 */

public class LocationBouchon implements ILocationDAO{
    @Override
    public boolean seConnecter(LoginDTO loginDTO) {
        boolean isUtilisateur = false;
        if(loginDTO.getIdentifiant().equals("jeanjean") && loginDTO.getMotDePasse().equals("1234")){
            isUtilisateur = true;
        }
        return isUtilisateur;
    }

    @Override
    public void louerVehicule(Vehicule vehicule) {

    }

    @Override
    public void rendreVehicule(Vehicule vehicule) {

    }

    @Override
    public Agence creerAgence(String raisonSociale, String siret, String voie, String codePostal,
                              String ville) throws Exception {
        Random rand = new Random(3);

        if (rand.nextInt() != 1) {
            throw new Exception("L'agence existe déjà.");
        }

        return new Agence(UUID.randomUUID().toString(), raisonSociale, siret, voie, codePostal, ville);
    }

    @Override
    public Agence recupererAgence(User u) {
        return new Agence(UUID.randomUUID().toString(), "Atos", "40802471900572",
                "rue Christian Pauc", "44300", "Nantes");
    }

    @Override
    public void modifierAgence(Agence agence) {
        // Rien à faire en bouchon
    }

    @Override
    public List<Vehicule> getVehicules() {
        List<Vehicule> voitures = new ArrayList<>();

        Vehicule v1 = new Vehicule("1","C4", 2, 25,35, 95, true, 5);
        Vehicule v2 = new Vehicule("2","205", 4, 57,28, 34, true, 5);
        Vehicule v3 = new Vehicule("3","Megan 3", 7, 14,11, 35, true, 5);
        Vehicule v4 = new Vehicule("4","Ferrari", 1, 3,142, 540, false, 2);
        Vehicule v5 = new Vehicule("5","Mini", 9, 98,41, 65, false, 4);

        voitures.add(v1);
        voitures.add(v2);
        voitures.add(v3);
        voitures.add(v4);
        voitures.add(v5);

        return voitures;
    }

    @Override
    public List<Reservation> getReservation() {
        List<Reservation> reservations = new ArrayList<>();

        Vehicule v1 = new Vehicule("1","C4", 2, 25,35, 95, true, 5);
        Vehicule v2 = new Vehicule("2","205", 4, 57,28, 34, true, 5);
        Vehicule v3 = new Vehicule("3","Megan 3", 7, 14,11, 35, true, 5);
        Vehicule v4 = new Vehicule("4","Ferrari", 1, 3,142, 540, false, 2);
        Vehicule v5 = new Vehicule("5","Mini", 9, 98,41, 65, false, 4);

        Reservation l1 = new Reservation("1",new Date() ,new Date(),45,v1);
        Reservation l2 = new Reservation("2",new Date() ,new Date(),29,v2);
        Reservation l3 = new Reservation("3",new Date() ,new Date(),12,v3);
        Reservation l4 = new Reservation("4",new Date() ,new Date(),345,v4);
        Reservation l5 = new Reservation("5",new Date() ,new Date(),57,v5);

        reservations.add(l1);
        reservations.add(l2);
        reservations.add(l3);
        reservations.add(l4);
        reservations.add(l5);

        return reservations;
    }

    @Override
    public Vehicule recupererVehicule(String id) {
        return new Vehicule("1","C4", 2, 25,35, 95, true, 5);
    }

    @Override
    public Reservation recupererReservation(String id) {
        Vehicule v1 = new Vehicule("1","C4", 2, 25,35, 95, true, 5);
        return new Reservation("1",new Date() ,new Date(),45,v1);
    }
}
