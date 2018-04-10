package mbrb.eni.com.locationeuropcar.ecran;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import mbrb.eni.com.locationeuropcar.R;
import mbrb.eni.com.locationeuropcar.dto.LoginDTO;
import mbrb.eni.com.locationeuropcar.service.LocationSvc;

public class ConnexionActivity extends AppCompatActivity implements ConnexionFragment.OnConnexionListenner {

    LocationSvc locaService= new LocationSvc();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

    }

    @Override
    public void connexionOK(LoginDTO login) {
        if(locaService.verifierUtilisateur(login)){
            Intent intent = new Intent(ConnexionActivity.this,ListeReservationActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this, "User inconnu ! :(", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void inscriptionOK(LoginDTO login) {
        Intent intent = new Intent(ConnexionActivity.this,ModifierAgenceActivity.class);
        startActivity(intent);
    }
}
