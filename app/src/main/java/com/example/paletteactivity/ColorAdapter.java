package com.example.paletteactivity;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ColorAdapter extends BaseAdapter {
    Context c;
    String[] colorArr;

    public ColorAdapter(Context context, String[] color){
        this.c = context;
        this.colorArr = color;
    }

    @Override
    public int getCount() {
        return colorArr.length;
    }

    @Override
    public Object getItem(int position) {

        return colorArr[position];
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final TextView tv = new TextView(c);
        tv.setText(getItem(position).toString());
        if(!getItem(position).toString().equals(" ")){
            tv.setBackgroundColor(Color.parseColor(colorArr[position]));
        }
        tv.setBackgroundColor(Color.parseColor("White"));
        return tv;

    }

    public View getDropDownView(int position, View convertView, ViewGroup parent) {

        TextView tv = new TextView((c));
        tv.setText(colorArr[position]);
        //tv.setText(SpinnerDisplay[position]);
        tv.setBackgroundColor(Color.parseColor(colorArr[position]));
        //tv.setBackgroundColor(Color.parseColor("White"));


        return tv;

    }
}
