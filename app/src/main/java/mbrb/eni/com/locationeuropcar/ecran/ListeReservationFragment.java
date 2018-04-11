package mbrb.eni.com.locationeuropcar.ecran;

import android.content.Context;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import mbrb.eni.com.locationeuropcar.R;
import mbrb.eni.com.locationeuropcar.model.Reservation;
import mbrb.eni.com.locationeuropcar.model.Vehicule;
import mbrb.eni.com.locationeuropcar.service.LocationSvc;


public class ListeReservationFragment extends Fragment {
    private OnListeReservationListener mListener;
    ListView lstReservation;
    LocationSvc locationSvc = new LocationSvc();

    public ListeReservationFragment() {}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_liste_reservation, container, false);
        lstReservation = v.findViewById(R.id.lst_reservation);

        Context context = getContext();
        List<Reservation> reservations = mListener.recupererReservations();

        final ReservationAdapter reservationAdapter = new ReservationAdapter(context,reservations);
        lstReservation.setAdapter(reservationAdapter);

        lstReservation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                mListener.appuieListe(reservationAdapter.getItem(position));
            }
        });

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnListeReservationListener) {
            mListener = (OnListeReservationListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " ERREUR CRITIQUE !");
        }
    }

    public interface OnListeReservationListener{
        Context getContext();
        List<Reservation> recupererReservations();
        void appuieListe(Reservation reservation);
    }
}
