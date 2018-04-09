package mbrb.eni.com.locationeuropcar.ecran;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import mbrb.eni.com.locationeuropcar.R;
import mbrb.eni.com.locationeuropcar.service.LocationSvc;

public class ConnexionActivity extends AppCompatActivity implements ConnexionFragment.OnConnexionListenner {

    LocationSvc locaService= new LocationSvc();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

    }

    @Override
    public void connexionOK(String identifiant, String mdp) {
        if(locaService.verifierUtilisateur(identifiant,mdp)){
            Toast.makeText(this, identifiant + " est connecté ! :)", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Utilisateur inconnu ! :(", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void inscriptionOK(String identifiant, String mdp) {
        Toast.makeText(this, "Inscription succes ! :)", Toast.LENGTH_SHORT).show();
    }
}
