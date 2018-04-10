package mbrb.eni.com.locationeuropcar.ecran;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import mbrb.eni.com.locationeuropcar.R;
import mbrb.eni.com.locationeuropcar.model.Agence;

/**
 * A simple {@link Fragment} subclass.
 */
public class AgenceFragment extends Fragment {

    private OnAgenceActionListener mListenner;

    EditText txtRaisonSociale;
    EditText txtSiret;
    EditText txtVoie;
    EditText txtCodePostal;
    EditText txtVille;
    Button   btnModifier;
    final String TARACE = "wallah frere fais les liste !";

    public AgenceFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_agence, container, false);

        txtRaisonSociale = v.findViewById(R.id.agence_raison_sociale);
        txtSiret         = v.findViewById(R.id.agence_siret);
        txtVoie          = v.findViewById(R.id.agence_voie);
        txtCodePostal    = v.findViewById(R.id.agence_code_postal);
        txtVille         = v.findViewById(R.id.agence_ville);
        btnModifier      = v.findViewById(R.id.agence_btn_modifier);

        btnModifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean erreur = checkErreur();

                if (!erreur) {
                    String raisonSociale = txtRaisonSociale.getText().toString();
                    String siret = txtSiret.getText().toString();
                    String voie = txtVoie.getText().toString();
                    String codePostal = txtCodePostal.getText().toString();
                    String ville = txtVille.getText().toString();

                    mListenner.modificationAgence(raisonSociale, siret, voie, codePostal, ville);
                }
            }
        });

        return v;
    }

    public boolean checkErreur() {
        boolean erreur = false;

        if (txtRaisonSociale.getText().toString().isEmpty()) {
            txtRaisonSociale.setError("Veuillez entrer une raison sociale");
            erreur = true;
        }

        if (txtSiret.getText().toString().isEmpty()) {
            txtSiret.setError("Veuillez entrer un SIRET");
            erreur = true;
        }

        if (txtVoie.getText().toString().isEmpty()) {
            txtVoie.setError("Veuillez entrer une voie");
            erreur = true;
        }

        if (txtCodePostal.getText().toString().isEmpty()) {
            txtCodePostal.setError("Veuillez entrer un code postal");
            erreur = true;
        }

        if (txtVille.getText().toString().isEmpty()) {
            txtVille.setError("Veuillez entrer une ville");
            erreur = true;
        }

        return erreur;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof  OnAgenceActionListener) {
            mListenner = (OnAgenceActionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " ERREUR CRITIQUE !");
        }
    }

    public interface OnAgenceActionListener {
        void modificationAgence(String raisonSociale, String siret, String voie, String codePostal, String ville);
    }

}
