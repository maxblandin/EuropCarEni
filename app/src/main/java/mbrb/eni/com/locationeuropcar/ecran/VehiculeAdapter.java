package mbrb.eni.com.locationeuropcar.ecran;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

import mbrb.eni.com.locationeuropcar.R;
import mbrb.eni.com.locationeuropcar.model.Location;
import mbrb.eni.com.locationeuropcar.model.Vehicule;
import mbrb.eni.com.locationeuropcar.model.Voiture;

/**
 * Created by rbonhomme2016 on 09/04/2018.
 */

public class VehiculeAdapter extends ArrayAdapter<Vehicule> {


    public VehiculeAdapter(@NonNull Context context, @NonNull List<Vehicule> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.ligne_vehicule,parent, false);
        }

        VehiculeViewHolder viewHolder = (VehiculeViewHolder) convertView.getTag();
        if(viewHolder==null){
            viewHolder = new VehiculeViewHolder();
            viewHolder.vehiculeId          = convertView.findViewById(R.id.vehicule_id);
            viewHolder.vehiculeLibelle     = convertView.findViewById(R.id.vehicule_libelle);
            viewHolder.vehiculeNbPlaces    = convertView.findViewById(R.id.vehicule_nb_places);
            viewHolder.vehiculeLocMinMax   = convertView.findViewById(R.id.vehicule_loc_min_max);
            viewHolder.vehiculeTarifMinMax = convertView.findViewById(R.id.vehicule_tarif_min_max);
            convertView.setTag(viewHolder);
        }

        Vehicule vehicule = getItem(position);

        viewHolder.vehiculeId.setText(vehicule.getId());
        viewHolder.vehiculeLibelle.setText(vehicule.getLibelle());

        if (vehicule instanceof Voiture) {
            viewHolder.vehiculeNbPlaces.setText(((Voiture) vehicule).getNbPlace());
        }

        String locMinMax = vehicule.getNbJourLocationMin() + " / " + vehicule.getNbJourLocationMax();
        viewHolder.vehiculeLocMinMax.setText(locMinMax);

        String tarifMinMax = vehicule.getTarifMin() + " / " + vehicule.getTarifMax();
        viewHolder.vehiculeTarifMinMax.setText(tarifMinMax);

        return convertView;

    }

    private class VehiculeViewHolder {
        TextView vehiculeId;
        TextView vehiculeLibelle;
        TextView vehiculeNbPlaces;
        TextView vehiculeLocMinMax;
        TextView vehiculeTarifMinMax;
    }
}
