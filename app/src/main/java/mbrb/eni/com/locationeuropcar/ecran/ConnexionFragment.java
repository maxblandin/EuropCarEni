package mbrb.eni.com.locationeuropcar.ecran;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import mbrb.eni.com.locationeuropcar.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConnexionFragment extends Fragment {
    private  OnConnexionListenner mListenner;

    EditText txtIdentifiant;
    EditText txtMotDePasse;
    EditText txtConfirmation;
    Button btnConnexion;
    Button btnInscription;


    public ConnexionFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_connexion, container, false);

        txtIdentifiant = view.findViewById(R.id.identifiant);
        txtMotDePasse = view.findViewById(R.id.mot_de_passe);
        txtConfirmation = view.findViewById(R.id.confirmer_mot_de_passe);

        btnConnexion = view.findViewById(R.id.se_connecter);
        btnInscription = view.findViewById(R.id.inscription);

        if(mListenner !=null){
            gestionVueConnexion();
        }

        this.btnConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mListenner !=null){
                    mListenner.connexionOK(txtIdentifiant.getText().toString(),txtMotDePasse.getText().toString());
                }
            }
        });

        this.btnInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mListenner != null){
                    gestionVueInscription();
                    if(txtMotDePasse.getText().toString().equals(txtConfirmation.getText().toString())){
                        mListenner.inscriptionOK(txtIdentifiant.getText().toString(),txtMotDePasse.getText().toString());
                    }
                }
            }
        });

        return view;
    }

    public void gestionVueConnexion(){
        this.txtConfirmation.setVisibility(View.GONE);
        this.btnConnexion.setVisibility(View.VISIBLE);
        this.btnInscription.setText("Inscription");
    }

    private void gestionVueInscription(){
        this.txtConfirmation.setVisibility(View.VISIBLE);
        this.btnConnexion.setVisibility(View.GONE);
        this.btnInscription.setText("S'inscrire");

    }

    public interface OnConnexionListenner{
        void connexionOK(String identifiant,String mdp);
        void inscriptionOK(String identifiant,String mdp);
    }
}
