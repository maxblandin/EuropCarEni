package mbrb.eni.com.locationeuropcar.ecran;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mbrb.eni.com.locationeuropcar.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LouerFragment extends Fragment {


    public LouerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_louer, container, false);
    }

}
