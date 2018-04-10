package mbrb.eni.com.locationeuropcar.ecran;

import android.content.Context;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import mbrb.eni.com.locationeuropcar.R;
import mbrb.eni.com.locationeuropcar.model.Reservation;
import mbrb.eni.com.locationeuropcar.model.Vehicule;
import mbrb.eni.com.locationeuropcar.service.LocationSvc;


public class ListeReservationFragment extends Fragment {

    ListView lstReservation;
    LocationSvc locationSvc = new LocationSvc();

    public ListeReservationFragment() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_liste_reservation, container, false);
        lstReservation = v.findViewById(R.id.lst_reservation);
        return v;
    }

    public void afficherListeReservation(Context context){
        List<Reservation> reservations = locationSvc.recupererReservations();
        ReservationAdapter rAdapter = new ReservationAdapter(context,reservations);
        lstReservation.setAdapter(rAdapter);
    }
}
