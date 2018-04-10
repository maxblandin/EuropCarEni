package mbrb.eni.com.locationeuropcar.ecran;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

        Vehicule vehicule = mListener.recupererVehicule();

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

            }
        });

        return v;
    }

    public boolean checkErreur() {
        boolean erreur = false;

        if (edtDateDebut.getText().toString().isEmpty()) {
            edtDateDebut.setError("");
            erreur = true;
        }

        return erreur;
    }

    public interface OnReserverListener {
        Vehicule recupererVehicule();
    }
}
