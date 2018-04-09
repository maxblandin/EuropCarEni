package mbrb.eni.com.locationeuropcar.dao;

import java.util.Random;
import java.util.UUID;

import mbrb.eni.com.locationeuropcar.model.Agence;
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
    public void louerVoiture(Voiture voiture) {

    }

    @Override
    public void rendreVoiture(Voiture voiture) {

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
}
