package com.example.paletteactivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
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

        setTitle("Palette Activity");

        final Spinner spinner = findViewById(R.id.spinner);

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
                    Intent startNewActivity = new Intent(PaletteActivity.this, CanvasActivity.class);

                    startNewActivity.putExtra("colorPicked", colorPicked);
                    startActivity(startNewActivity);

                }



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {



            }
        });
    }
}
