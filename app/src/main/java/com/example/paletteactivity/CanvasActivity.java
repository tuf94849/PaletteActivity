package com.example.paletteactivity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        setTitle("Canvas Activity");
        


        String selectedColor = (getIntent().getStringExtra("colorPicked"));
        getWindow().getDecorView().setBackgroundColor(Color.parseColor(selectedColor));
    }
}
