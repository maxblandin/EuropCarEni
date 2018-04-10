package mbrb.eni.com.locationeuropcar.ecran;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import mbrb.eni.com.locationeuropcar.R;
import mbrb.eni.com.locationeuropcar.model.Reservation;
import mbrb.eni.com.locationeuropcar.model.Vehicule;
import mbrb.eni.com.locationeuropcar.service.LocationSvc;

public class ReserverActivity extends AppCompatActivity implements ReserverFragment.OnReserverListener {

    LocationSvc locationSvc = new LocationSvc();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserver);
    }

    @Override
    public Vehicule recupererVehicule() {
        Intent intent = getIntent();

        return locationSvc.recupererVehicule(intent.getStringExtra("idVehicule"));
    }

    @Override
    public void reservationOk() {
        Toast.makeText(ReserverActivity.this, getText(R.string.toast_reservation_ok), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(ReserverActivity.this, ListeReservationActivity.class);
        startActivity(intent);
    }
}
