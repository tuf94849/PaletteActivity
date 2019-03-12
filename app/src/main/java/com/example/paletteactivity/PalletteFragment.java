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


/**
 * A simple {@link Fragment} subclass.
 */
public class PalletteFragment extends Fragment {

    //use framelayout to hold fragments

    Context c;

    public PalletteFragment() {
        // Required empty public constructor
    }

    private boolean firstLaunch = true;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_pallette, container, false);
        final Spinner spinner = v.findViewById(R.id.spinner);


        //must have 10 colors
        //colors like "LTGray" dont work well with parsecolor
        //LTGray must be spelled out as "LightGray
        /*
        final String[] colorsArr = {"White", "Black", "Blue", "Cyan", "Gray", "Green",
                "Magenta", "Red", "Yellow", "DarkGray", "LightGray"};
        */

        Resources res = getResources() ;
        final String [] EnglishColors = res.getStringArray(R.array.colorsArray);
        final String [] ESColors = res.getStringArray(R.array.colorsArray2);

        ColorAdapter colorAdapter = new ColorAdapter(c, EnglishColors, ESColors);

        spinner.setAdapter(colorAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //getWindow().getDecorView().setBackgroundColor(Color.parseColor(colorsArr[position]));
                //spinner.setBackgroundColor(Color.WHITE);

                String colorPicked = EnglishColors[position];

                if(firstLaunch){
                    firstLaunch = false;
                }
                else{
                    /*Intent startNewActivity = new Intent(PaletteActivity.this, CanvasActivity.class);

                    startNewActivity.putExtra("colorPicked", colorPicked);
                    startActivity(startNewActivity);
                    */

                }



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {



            }
        });
        return v;
    }


}
