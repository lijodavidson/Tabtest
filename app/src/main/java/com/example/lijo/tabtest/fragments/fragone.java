package com.example.lijo.tabtest.fragments;

import android.graphics.SurfaceTexture;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;

import com.example.lijo.tabtest.OnFragmentSelectedListener;
import com.example.lijo.tabtest.R;

/**
 * Created by LIJO on 1/18/2016.
 */
public class fragone extends Fragment {

    private OnFragmentSelectedListener onFragmentSelectedListener;
    public fragone(OnFragmentSelectedListener onFragmentSelectedListener) {

        this.onFragmentSelectedListener = onFragmentSelectedListener;


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        onFragmentSelectedListener.onFragmentSelected(1);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false);
    }




}
