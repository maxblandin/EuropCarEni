package mbrb.eni.com.locationeuropcar.ecran;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import mbrb.eni.com.locationeuropcar.R;
import mbrb.eni.com.locationeuropcar.model.Location;
import mbrb.eni.com.locationeuropcar.model.Vehicule;

/**
 * Created by rbonhomme2016 on 09/04/2018.
 */

public class ReservationAdapter extends ArrayAdapter<Location> {
    public ReservationAdapter(@NonNull Context context, @NonNull List<Location> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.ligne_reservation,parent, false);
        }

        ReservationViewHolder viewHolder = (ReservationViewHolder) convertView.getTag();
        if(viewHolder==null){
            viewHolder = new ReservationViewHolder();
            viewHolder.vehiculeId          = convertView.findViewById(R.id.loc_vehicule_id);
            viewHolder.locationDates       = convertView.findViewById(R.id.loc_dates);
            viewHolder.locationTarif       = convertView.findViewById(R.id.loc_tarif);
            convertView.setTag(viewHolder);
        }

        Location location = getItem(position);
        Vehicule vehicule = location.getVehicule();

        viewHolder.vehiculeId.setText(vehicule.getId());

        String dates = location.getDateDebut() + " - " + location.getDateFin();
        viewHolder.locationDates.setText(dates);

        String tarif = "" + location.getTarifJournalier();
        viewHolder.locationTarif.setText(tarif);

        return convertView;

    }

    private class ReservationViewHolder {
        TextView vehiculeId;
        TextView locationDates;
        TextView locationTarif;
    }
}
