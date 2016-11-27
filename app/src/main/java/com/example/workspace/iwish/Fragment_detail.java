package com.example.workspace.iwish;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.workspace.iwish.model.Meta;

public class Fragment_detail extends Fragment implements View.OnClickListener{


    Meta meta;
    public Fragment_detail() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_detail, container, false);


        TextView descripcion=(TextView) v.findViewById(R.id.descripcion);
        TextView prioridad=(TextView)v.findViewById(R.id.prioridad);
        TextView fecha=(TextView)v.findViewById(R.id.fecha);
        TextView categoria=(TextView)v.findViewById(R.id.categoria);
        ImageButton fab= (ImageButton) v.findViewById(R.id.fab);

        Bundle bundle = this.getArguments();
        meta = (Meta) bundle.getSerializable("meta");
        // Log.v("meta",meta.getCategoria()); // ahi esta devuelve


        descripcion.setText(meta.getDescripcion());
        prioridad.setText(meta.getPrioridad());
        fecha.setText(meta.getFecha());
        categoria.setText(meta.getCategoria());

        setHasOptionsMenu(true);

        fab.setOnClickListener(this);

        return v;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_prueba, menu);

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onClick(View view) {
        Intent activityEditar= new Intent(view.getContext(), EditarMeta.class);

        activityEditar.putExtra("meta", meta);
        startActivity(activityEditar);
    }
}
