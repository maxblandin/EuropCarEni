package mbrb.eni.com.locationeuropcar.ecran;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.List;

import mbrb.eni.com.locationeuropcar.R;
import mbrb.eni.com.locationeuropcar.model.Reservation;
import mbrb.eni.com.locationeuropcar.service.LocationSvc;

public class ListeReservationActivity extends AppCompatActivity implements ListeReservationFragment.OnListeReservationListener{
    LocationSvc locationSvc = new LocationSvc();
    FloatingActionButton btnAjout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_reservation);

        btnAjout = findViewById(R.id.ajouter_reservation);

        btnAjout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListeReservationActivity.this,ListeVehiculeActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public Context getContext() {
        return ListeReservationActivity.this;
    }

    @Override
    public List<Reservation> recupererReservations() {
        return locationSvc.recupererReservations();
    }

    @Override
    public void appuieListe(Reservation reservation) {
        Intent intent = new Intent(ListeReservationActivity.this, RendreActivity.class);
        intent.putExtra("idReservation", reservation.getReservationId());
        startActivity(intent);
    }
}
