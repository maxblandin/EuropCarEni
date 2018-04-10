package mbrb.eni.com.locationeuropcar.ecran;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import mbrb.eni.com.locationeuropcar.R;
import mbrb.eni.com.locationeuropcar.model.Reservation;
import mbrb.eni.com.locationeuropcar.model.Vehicule;
import mbrb.eni.com.locationeuropcar.service.LocationSvc;

public class ListeVehiculeActivity extends AppCompatActivity implements ListeVehiculeFragment.OnListeVehiculeListener {
    LocationSvc locationSvc = new LocationSvc();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_vehicule);
    }

    @Override
    public Context getContext() {
        return ListeVehiculeActivity.this;
    }

    @Override
    public List<Vehicule> recupererListeVehicule() {
        return locationSvc.recupererVehicules();
    }

    @Override
    public void voirDetailVehicule(String id) {
        Intent intent = new Intent(ListeVehiculeActivity.this,ReserverActivity.class);
        intent.putExtra("idVehicule",id);
        startActivity(intent);
    }
}
