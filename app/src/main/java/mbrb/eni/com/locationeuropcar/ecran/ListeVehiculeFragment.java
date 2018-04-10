package mbrb.eni.com.locationeuropcar.ecran;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import mbrb.eni.com.locationeuropcar.R;
import mbrb.eni.com.locationeuropcar.model.Vehicule;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListeVehiculeFragment extends Fragment {
    ListView lstVehicule;
    private OnListeVehiculeListener mListener;

    public ListeVehiculeFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_liste_vehicule, container, false);
        lstVehicule = v.findViewById(R.id.lst_voiture);

        List<Vehicule> vehicules = mListener.recupererListeVehicule();
        Context context = getContext();

        VehiculeAdapter vAdapter = new VehiculeAdapter(context,vehicules);
        lstVehicule.setAdapter(vAdapter);

        lstVehicule.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mListener.voirDetailVehicule(((Vehicule)lstVehicule.getItemAtPosition(i)).getId());
            }
        });

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnListeVehiculeListener) {
            mListener = (OnListeVehiculeListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " ERREUR CRITIQUE !");
        }
    }

    public interface OnListeVehiculeListener {
        Context getContext();
        List<Vehicule> recupererListeVehicule();
        void voirDetailVehicule(String id);
    }


}
