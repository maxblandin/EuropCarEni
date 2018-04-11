package mbrb.eni.com.locationeuropcar.ecran;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import mbrb.eni.com.locationeuropcar.R;
import mbrb.eni.com.locationeuropcar.model.Reservation;
import mbrb.eni.com.locationeuropcar.model.Vehicule;

/**
 * A simple {@link Fragment} subclass.
 */
public class RendreFragment extends Fragment {

    TextView txtVehiculeId;
    TextView txtVehiculeDates;
    TextView txtTarifJournalier;
    CheckBox chkEndommage;
    CheckBox chkPlein;
    EditText edtVehiculeNbKm;
    Button   btnPhoto;
    Button   btnRendre;

    private OnRendreListener mListener;

    public RendreFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnRendreListener) {
            mListener = (OnRendreListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " ERREUR CRITIQUE !");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_rendre, container, false);

        txtVehiculeId      = v.findViewById(R.id.rendre_vehicule_id);
        txtVehiculeDates   = v.findViewById(R.id.rendre_vehicule_dates);
        txtTarifJournalier = v.findViewById(R.id.rendre_vehicule_tarif_journalier);
        chkEndommage       = v.findViewById(R.id.rendre_vehicule_endommage);
        chkPlein           = v.findViewById(R.id.rendre_vehicule_plein);
        edtVehiculeNbKm    = v.findViewById(R.id.rendre_vehicule_km);
        btnPhoto           = v.findViewById(R.id.btn_ajouter_photo);
        btnRendre          = v.findViewById(R.id.btn_rendre);

        Reservation reservation = mListener.recupererReservation();

        String vehiculeIdNom = reservation.getVehicule().getId() + " - " + reservation.getVehicule().getLibelle();
        txtVehiculeId.setText(vehiculeIdNom);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        String dates = sdf.format(reservation.getDateDebut()) + " - " + sdf.format(reservation.getDateFin());
        txtVehiculeDates.setText(dates);

        txtTarifJournalier.setText(String.valueOf(reservation.getTarifJournalier()));

        return v;
    }

    public interface OnRendreListener {
        Reservation recupererReservation();
    }
}
