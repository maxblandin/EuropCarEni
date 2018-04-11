package mbrb.eni.com.locationeuropcar.ecran;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import mbrb.eni.com.locationeuropcar.R;
import mbrb.eni.com.locationeuropcar.model.Agence;
import mbrb.eni.com.locationeuropcar.service.LocationSvc;

public class ModifierAgenceActivity extends AppCompatActivity implements AgenceFragment.OnAgenceActionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier_agence);
    }

    @Override
    public void modificationAgence(String raisonSociale, String siret, String voie, String codePostal, String ville) {

        LocationSvc service = new LocationSvc();

        service.creerAgence(raisonSociale, siret, voie, codePostal, ville);

        Intent intent = new Intent(ModifierAgenceActivity.this, ListeReservationActivity.class);
        startActivity(intent);
    }
}
