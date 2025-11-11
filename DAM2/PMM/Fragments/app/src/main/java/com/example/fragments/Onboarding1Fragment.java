package com.example.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Onboarding1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Onboarding1Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_onboarding1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view,@Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}