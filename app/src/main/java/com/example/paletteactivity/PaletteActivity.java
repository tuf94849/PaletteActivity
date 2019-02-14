package com.example.paletteactivity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;


public class PaletteActivity extends AppCompatActivity {
    private boolean firstLaunch = true;

    //submit apk file on canvas with github link

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner spinner = findViewById(R.id.spinner);

        //must have 10 colors
        //colors like "LTGray" dont work well with parsecolor
        //LTGray must be spelled out as "LightGray
        final String[] colorsArr = {"White", "Black", "Blue", "Cyan", "Gray", "Green",
                "Magenta", "Red", "Yellow", "DarkGray", "LightGray"};

        ColorAdapter colorAdapter = new ColorAdapter(PaletteActivity.this, colorsArr);

        spinner.setAdapter(colorAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //getWindow().getDecorView().setBackgroundColor(Color.parseColor(colorsArr[position]));
                //spinner.setBackgroundColor(Color.WHITE);

                String colorPicked = colorsArr[position];

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
