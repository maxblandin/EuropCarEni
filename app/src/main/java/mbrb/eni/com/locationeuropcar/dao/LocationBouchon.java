package mbrb.eni.com.locationeuropcar.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import mbrb.eni.com.locationeuropcar.model.Agence;
import mbrb.eni.com.locationeuropcar.model.Location;
import mbrb.eni.com.locationeuropcar.model.Utilisateur;
import mbrb.eni.com.locationeuropcar.model.Vehicule;
import mbrb.eni.com.locationeuropcar.model.Voiture;

/**
 * Created by mblandin2016 on 09/04/2018.
 */

public class LocationBouchon implements ILocationDAO{
    @Override
    public boolean seConnecter(String identifiant, String motDePasse) {
        boolean isUtilisateur = false;
        if(identifiant.equals("jeanjean") && motDePasse.equals("1234")){
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

        return new Agence(raisonSociale, siret, voie, codePostal, ville);
    }

    @Override
    public Agence recupererAgence(Utilisateur u) {
        return new Agence(UUID.randomUUID().toString(), "40802471900572",
                "rue Christian Pauc", "44300", "Nantes");
    }

    @Override
    public void modifierAgence(Agence agence) {
        // Rien à faire en bouchon
    }

    @Override
    public List<Location> getLocations(String id) {
        List<Location> locations = new ArrayList<>();

        Voiture v1 = new Voiture("1","C4", 2, 25,35, 95, 5);
        Voiture v2 = new Voiture("2","205", 4, 57,28, 34, 5);
        Voiture v3 = new Voiture("3","Megan 3", 7, 14,11, 35, 5);
        Voiture v4 = new Voiture("4","Ferrari", 1, 3,142, 540, 2);
        Voiture v5 = new Voiture("5","Mini", 9, 98,41, 65, 4);

        Location l1 = new Location("1",new Date() ,new Date(),45,v1);
        Location l2 = new Location("2",new Date() ,new Date(),29,v2);
        Location l3 = new Location("3",new Date() ,new Date(),12,v3);
        Location l4 = new Location("4",new Date() ,new Date(),345,v4);
        Location l5 = new Location("5",new Date() ,new Date(),57,v5);

        locations.add(l1);
        locations.add(l2);
        locations.add(l3);
        locations.add(l4);
        locations.add(l5);

        return locations;
    }
}
