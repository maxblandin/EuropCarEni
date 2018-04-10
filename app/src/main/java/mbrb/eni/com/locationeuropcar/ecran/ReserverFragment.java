package mbrb.eni.com.locationeuropcar.ecran;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import mbrb.eni.com.locationeuropcar.R;
import mbrb.eni.com.locationeuropcar.model.Vehicule;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReserverFragment extends Fragment {

    private OnReserverListener mListener;

    TextView txtVehiculeId;
    TextView txtLibelle;
    TextView txtNbPlaces;
    TextView txtLocMinMax;
    TextView txtTarifMinMax;
    EditText edtDateDebut;
    EditText edtDateFin;
    EditText edtTarifJournalier;
    Button   btnReserver;

    public ReserverFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnReserverListener) {
            mListener = (OnReserverListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " ERREUR CRITIQUE !");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_reserver, container, false);

        txtVehiculeId      = v.findViewById(R.id.reservation_id);
        txtLibelle         = v.findViewById(R.id.reservation_libelle);
        txtNbPlaces        = v.findViewById(R.id.reservation_nb_places);
        txtLocMinMax       = v.findViewById(R.id.reservation_loc_min_max);
        txtTarifMinMax     = v.findViewById(R.id.reservation_tarif_min_max);
        edtDateDebut       = v.findViewById(R.id.reservation_date_debut);
        edtDateFin         = v.findViewById(R.id.reservation_date_fin);
        edtTarifJournalier = v.findViewById(R.id.reservation_tarif_journalier);
        btnReserver        = v.findViewById(R.id.btn_reserver);

        final Vehicule vehicule = mListener.recupererVehicule();

        txtVehiculeId.setText(vehicule.getId());
        txtLibelle.setText(vehicule.getLibelle());

        String nbPlaces = String.valueOf(vehicule.getNbPlaces());
        txtNbPlaces.setText(nbPlaces);

        String locMinMax = vehicule.getNbJourLocationMin() + " / " + vehicule.getNbJourLocationMax();
        txtLocMinMax.setText(locMinMax);

        String tarifMinMax = vehicule.getTarifMin() + " / " + vehicule.getTarifMax();
        txtTarifMinMax.setText(tarifMinMax);

        btnReserver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!checkErreur(vehicule)) {
                    mListener.reservationOk();
                }
            }
        });

        return v;
    }

    public boolean checkErreur(Vehicule vehicule) {
        boolean erreur = false;

        if (edtDateDebut.getText().toString().isEmpty()) {
            edtDateDebut.setError(getText(R.string.erreur_reserver_date_debut));
            erreur = true;
        } else {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/YYYY");
                Date dateDebut = sdf.parse(edtDateDebut.getText().toString());
            } catch (ParseException e) {
                edtDateDebut.setError(getText(R.string.erreur_parse_date));
                erreur = true;
            }
        }

        if (edtDateFin.getText().toString().isEmpty()) {
            edtDateFin.setError(getText(R.string.erreur_reserver_date_fin));
            erreur = true;
        } else {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/YYYY");
                Date dateFin = sdf.parse(edtDateFin.getText().toString());
            } catch (ParseException e) {
                edtDateFin.setError(getText(R.string.erreur_parse_date));
                erreur = true;
            }
        }

        if (edtTarifJournalier.getText().toString().isEmpty()) {
            edtTarifJournalier.setError(getText(R.string.erreur_reserver_tarif_journalier));
            erreur = true;
        } else {

            float tarif = -1;

            try {
                tarif = Float.parseFloat(edtTarifJournalier.getText().toString());
            } catch (NumberFormatException e) {
                edtTarifJournalier.setError(getText(R.string.erreur_montant_incorrect));
            }

            if (!(tarif <= vehicule.getTarifMax() && tarif >= vehicule.getTarifMin())) {
                edtTarifJournalier.setError(getText(R.string.erreur_montant_tarif));
            }
        }

        return erreur;
    }

    public interface OnReserverListener {
        Vehicule recupererVehicule();
        void reservationOk();
    }
}
