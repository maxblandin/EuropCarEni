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
import mbrb.eni.com.locationeuropcar.dto.LoginDTO;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConnexionFragment extends Fragment {
    private OnConnexionListenner mListener;

    EditText txtIdentifiant;
    EditText txtMotDePasse;
    EditText txtToken;
    TextView lblConfirmation;
    EditText txtConfirmation;
    Button btnConnexion;
    Button btnInscription;
    Button btnValiderInscription;


    public ConnexionFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_connexion, container, false);

        txtIdentifiant = view.findViewById(R.id.identifiant);
        txtMotDePasse = view.findViewById(R.id.mot_de_passe);
        txtToken = view.findViewById(R.id.token);
        lblConfirmation = view.findViewById(R.id.lbl_confirmer_mdp);
        txtConfirmation = view.findViewById(R.id.confirmer_mot_de_passe);

        btnConnexion = view.findViewById(R.id.se_connecter);
        btnInscription = view.findViewById(R.id.inscription);
        btnValiderInscription = view.findViewById(R.id.valider_inscription);

        if(mListener !=null){
            gestionVueConnexion();
        }

        this.btnConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isError = checkErreur();
                if(mListener !=null){
                    if(!isError){
                        LoginDTO login = new LoginDTO(txtIdentifiant.getText().toString(),txtMotDePasse.getText().toString(),txtToken.getText().toString());
                        mListener.connexionOK(login);
                    }
                }
            }
        });

        this.btnInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mListener != null){
                    gestionVueInscription();
                }
            }
        });

        this.btnValiderInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isError = checkErreur();
                if(mListener !=null){
                    if(!isError){
                        LoginDTO login = new LoginDTO(txtIdentifiant.getText().toString(),txtMotDePasse.getText().toString(),txtToken.getText().toString());
                        mListener.inscriptionOK(login);
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
                + " ERREUR CRITIQUE !");
        }
    }

    public void gestionVueConnexion(){
        this.lblConfirmation.setVisibility(View.GONE);
        this.txtConfirmation.setVisibility(View.GONE);
        this.btnConnexion.setVisibility(View.VISIBLE);
        this.btnInscription.setVisibility(View.VISIBLE);
        this.btnValiderInscription.setVisibility(View.GONE);
    }

    private void gestionVueInscription(){
        this.lblConfirmation.setVisibility(View.VISIBLE);
        this.txtConfirmation.setVisibility(View.VISIBLE);
        this.btnConnexion.setVisibility(View.GONE);
        this.btnInscription.setVisibility(View.GONE);
        this.btnValiderInscription.setVisibility(View.VISIBLE);
    }

    public boolean checkErreur() {
        boolean erreur = false;

        if (txtIdentifiant.getText().toString().isEmpty()) {
            txtIdentifiant.setError(getText(R.string.erreur_identifiant));
            erreur = true;
        }

        if (txtMotDePasse.getText().toString().isEmpty()) {
            txtMotDePasse.setError(getText(R.string.erreur_mdp));
            erreur = true;
        }

        if(txtConfirmation.getVisibility() == View.VISIBLE){
            if(txtConfirmation.getText().toString().isEmpty()){
                txtConfirmation.setError(getText(R.string.erreur_confirm_mdp));
                erreur = true;
            }else if(!txtConfirmation.getText().toString().equals(txtMotDePasse.getText().toString())){
                txtConfirmation.setError(getText(R.string.erreur_mdp_different));
                erreur = true;
            }
        }

        return erreur;
    }


    public interface OnConnexionListenner{
        void connexionOK(LoginDTO login);
        void inscriptionOK(LoginDTO login);
    }
}
