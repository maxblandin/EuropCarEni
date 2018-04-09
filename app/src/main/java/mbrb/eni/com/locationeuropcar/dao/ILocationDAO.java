package mbrb.eni.com.locationeuropcar.dao;

import java.util.List;

import mbrb.eni.com.locationeuropcar.model.Agence;
import mbrb.eni.com.locationeuropcar.model.Utilisateur;
import mbrb.eni.com.locationeuropcar.model.Vehicule;
import mbrb.eni.com.locationeuropcar.model.Voiture;

/**
 * Created by mblandin2016 on 09/04/2018.
 */

public interface ILocationDAO {
    boolean seConnecter(String identifiant,String motDePasse);
    void louerVehicule(Vehicule vehicule);
    void rendreVehicule(Vehicule vehicule);
    Agence creerAgence(String raisonSociale, String siret, String voie, String codePostal, String ville) throws Exception;
    Agence recupererAgence(Utilisateur u);
    void modifierAgence(Agence agence);
}
