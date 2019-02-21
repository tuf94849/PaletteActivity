package com.example.paletteactivity;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ColorAdapter extends BaseAdapter {
    Context c;
    String[] colorsArr;
    String[] SpinnerDisplay;


    public ColorAdapter(Context c, String[] colors, String[] SpinnerDisplay){
        this.c = c;
        this.colorsArr = colors;
        this.SpinnerDisplay = SpinnerDisplay;

    }

    @Override
    public int getCount() {
        int count = colorsArr.length;
        return count;
    }

    @Override
    public Object getItem(int position) {
        return colorsArr[position];
    }

    @Override
    //can leave it as default
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tv = new TextView((c));
        tv.setText(colorsArr[position]);
        tv.setText(SpinnerDisplay[position]);
        //tv.setBackgroundColor(Color.parseColor(colorsArr[position]));
        tv.setBackgroundColor(Color.parseColor("White"));



        return tv;
    }

    /*public View getDropDownView(int position, View convertView, ViewGroup parent){

    }

*/
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {

        TextView tv = new TextView((c));
        tv.setText(colorsArr[position]);
        tv.setText(SpinnerDisplay[position]);
        tv.setBackgroundColor(Color.parseColor(colorsArr[position]));
        //tv.setBackgroundColor(Color.parseColor("White"));


        return tv;

    }
}
