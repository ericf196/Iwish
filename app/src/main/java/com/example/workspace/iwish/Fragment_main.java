package com.example.workspace.iwish;


import android.content.Context;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;


public class Fragment_main extends Fragment {


    private RecyclerView reciclador;
    private LinearLayoutManager layoutManager;
    private AdaptaptadorMain adapterMain;


    public Fragment_main() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_main, container,false);

        reciclador= (RecyclerView) view.findViewById(R.id.recicladorWish);
        layoutManager=new LinearLayoutManager(getActivity());
        reciclador.setLayoutManager(layoutManager);

        adapterMain=new AdaptaptadorMain(getContext());
        reciclador.setAdapter(adapterMain);

        //Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        Log.v("MensajeM", "get called");


        super.onCreateOptionsMenu(menu,inflater);

    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {

        Log.v("MensajeM", "get called");

        super.onPrepareOptionsMenu(menu);
    }

}
