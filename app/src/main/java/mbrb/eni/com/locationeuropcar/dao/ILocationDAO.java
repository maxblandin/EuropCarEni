package mbrb.eni.com.locationeuropcar.dao;

import mbrb.eni.com.locationeuropcar.model.Voiture;

/**
 * Created by mblandin2016 on 09/04/2018.
 */

public interface ILocationDAO {
    boolean seConnecter(String identifiant,String motDePasse);
    void louerVoiture(Voiture voiture);
    void rendreVoiture(Voiture voiture);
}
