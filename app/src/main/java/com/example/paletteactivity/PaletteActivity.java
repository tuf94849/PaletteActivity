package com.example.paletteactivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;


public class PaletteActivity extends AppCompatActivity {
    private boolean firstLaunch = true;



    //submit apk file on canvas with github link
    //LOOK INTO CHANGING APPBAR NAME IN SPANISH
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PalletteFragment paletteFragment = new PalletteFragment();
        addFragment(paletteFragment, R.id.container_1);
        CanvasFragment canvasFragment = new CanvasFragment();
        addFragment(canvasFragment, R.id.container_2);

        //move to its own method to save time
        /*PalletteFragment palletteFragment = new PalletteFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(r.id.containter_1, palletteFragment)
                .addToBackStack(null)
                .commit();
                */

        setTitle("Palette Activity");

        //final Spinner spinner = findViewById(R.id.spinner);

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

        ColorAdapter colorAdapter = new ColorAdapter(PaletteActivity.this, EnglishColors, ESColors);



    }

    public void colorSelected(String color) {
        Bundle bundle = new Bundle();
        bundle.putString("color", color);
        CanvasFragment.setArguments(bundle);
        CanvasFragment.changeColor();
    }

    public void addFragment(Fragment fragment, int id){
        getSupportFragmentManager()
                .beginTransaction()
                .add(id, fragment)
                .addToBackStack(null)
                .commit();
    }
}
