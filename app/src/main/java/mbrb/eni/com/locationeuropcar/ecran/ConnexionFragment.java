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

/**
 * A simple {@link Fragment} subclass.
 */
public class ConnexionFragment extends Fragment {
    private  OnConnexionListenner mListener;

    EditText txtIdentifiant;
    EditText txtMotDePasse;
    TextView lblConfirmation;
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
        lblConfirmation = view.findViewById(R.id.lbl_confirmer_mdp);
        txtConfirmation = view.findViewById(R.id.confirmer_mot_de_passe);

        btnConnexion = view.findViewById(R.id.se_connecter);
        btnInscription = view.findViewById(R.id.inscription);

        if(mListener !=null){
            gestionVueConnexion();
        }

        this.btnConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mListener !=null){
                    mListener.connexionOK(txtIdentifiant.getText().toString(),txtMotDePasse.getText().toString());
                }
            }
        });

        this.btnInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mListener != null){
                    gestionVueInscription();
                    if(txtMotDePasse.getText().toString().equals(txtConfirmation.getText().toString())){
                        mListener.inscriptionOK(txtIdentifiant.getText().toString(),txtMotDePasse.getText().toString());
                    }
                }
            }
        });

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnConnexionListenner) {
            mListener = (OnConnexionListenner) context;
    } else {
        throw new RuntimeException(context.toString()
                + " must implement OnFragmentInteractionListener");
    }
    }

    public void gestionVueConnexion(){
        this.lblConfirmation.setVisibility(View.GONE);
        this.txtConfirmation.setVisibility(View.GONE);
        this.btnConnexion.setVisibility(View.VISIBLE);
        this.btnInscription.setText("Inscription");
    }

    private void gestionVueInscription(){
        this.lblConfirmation.setVisibility(View.VISIBLE);
        this.txtConfirmation.setVisibility(View.VISIBLE);
        this.btnConnexion.setVisibility(View.GONE);
        this.btnInscription.setText("S'inscrire");

    }

    public interface OnConnexionListenner{
        void connexionOK(String identifiant,String mdp);
        void inscriptionOK(String identifiant,String mdp);
    }
}
