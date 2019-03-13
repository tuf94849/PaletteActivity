package com.example.paletteactivity;


import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;



public class PalletteFragment extends Fragment {

    Context c;
    private ColorFragmentInterface mListener;
    Boolean firstLaunch = true;

    public PalletteFragment() {
        // Required empty public constructor
    }

    public static PalletteFragment newInstance(String param1, String param2) {
        PalletteFragment fragment = new PalletteFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_pallette, container, false);

        Spinner spinner = v.findViewById(R.id.spinner);
        Resources res = getResources();
        final String[] spinnerColors = res.getStringArray(R.array.colorsArray);
        spinner.setAdapter(new ColorAdapter(c, spinnerColors));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(firstLaunch == true){
                    firstLaunch = false;

                }
                else{
                    ((ColorFragmentInterface) c).colorPicked(spinnerColors[position]);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ColorFragmentInterface) {
            mListener = (ColorFragmentInterface) context;
        } else throw new RuntimeException(context.toString()
                + " An error has occurred");

        this.c = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    interface ColorFragmentInterface {
        void colorPicked(String color);
    }


}
