package com.example.lijo.tabtest.fragments;

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
public class fragthree extends Fragment {

    private OnFragmentSelectedListener onFragmentSelectedListener;
    public fragthree(OnFragmentSelectedListener onFragmentSelectedListener) {

        this.onFragmentSelectedListener = onFragmentSelectedListener;


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        onFragmentSelectedListener.onFragmentSelected(3);
        return inflater.inflate(R.layout.fragment_three, container, false);
    }




}
