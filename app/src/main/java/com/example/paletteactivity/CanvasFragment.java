package com.example.paletteactivity;


import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;



public class CanvasFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    FrameLayout canvasLayout;

    public CanvasFragment() {
        // Required empty public constructor
    }

    public static CanvasFragment newInstance(String param1, String param2) {
        CanvasFragment fragment = new CanvasFragment();
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
        View view = inflater.inflate(R.layout.fragment_canvas, container, false);
        canvasLayout = view.findViewById(R.id.canvas_layout);
        return canvasLayout;
    }

    public void changeColor(){
        String selectedColor = getArguments().getString("color");
        canvasLayout.setBackgroundColor(Color.parseColor(selectedColor));
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

}
