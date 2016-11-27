package com.example.workspace.iwish;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.workspace.iwish.model.Meta;

import java.util.ArrayList;
import java.util.List;

public class EditarMeta extends AppCompatActivity {

    private Spinner spinnerPrioridad, spinnerCategoria;
    private List<String> listCategoria;
    private List<String> listPrioridad;
    private Meta meta;
    private ActionBar ab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_meta);
        setToolbar();
        listCategoria = new ArrayList<>();
        listCategoria.add("Seleccione");
        listCategoria.add("Universidad");
        listCategoria.add("Vida");
        listCategoria.add("Fisica");

        listPrioridad = new ArrayList<>();
        listPrioridad.add("Seleccione");
        listPrioridad.add("Baja");
        listPrioridad.add("Media");
        listPrioridad.add("Alta");


        spinnerCategoria = (Spinner) findViewById(R.id.spinnerCategoria);
        spinnerPrioridad = (Spinner) findViewById(R.id.spinnerPrioridad);

        ArrayAdapter<String> dataAdapterCategoria = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, listCategoria);
        dataAdapterCategoria.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPrioridad.setAdapter(dataAdapterCategoria);

        ArrayAdapter<String> dataAdapterPrioridad = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, listPrioridad);
        dataAdapterPrioridad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategoria.setAdapter(dataAdapterPrioridad);

        meta= (Meta) getIntent().getSerializableExtra("meta");

        EditText textTitulo= (EditText) findViewById(R.id.textTitulo);
        textTitulo.setText(meta.getTitulo());

        EditText textDescripcion= (EditText) findViewById(R.id.textDescripcion);
        textDescripcion.setText(meta.getDescripcion());

        EditText textFecha= (EditText) findViewById(R.id.textFecha);
        textFecha.setText(meta.getFecha());

        setPrioridad();
        setCategoria();


    }

    private void setCategoria() {
        boolean resp=true;
        int i=0;

        while(resp){
            if(meta.getCategoria().equals(listCategoria.get(i))) {
                spinnerCategoria.setSelection(i);
                resp=false;
            }else
                i++;
        }
    }

    private void setPrioridad() {
        boolean resp=true;
        int i=0;
        while(resp){
            if(meta.getPrioridad().equals(listPrioridad.get(i))) {
                spinnerPrioridad.setSelection(i);
                resp=false;
            }else
                i++;
        }
    }


    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ab = getSupportActionBar();
        if (ab != null) {
            ab.setHomeAsUpIndicator(R.drawable.ic_action_name);
            // Poner ícono del drawer toggle
            ab.setDisplayHomeAsUpEnabled(true);
            ab.setHomeButtonEnabled(true);

        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        /*getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        menu.findItem(R.id.action_search).setOnMenuItemClickListener(this);*/

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:

                Log.v("mensaje","aqui estoy");
                // Toast.makeText(this, "Mensaje " + fragmentManager.getBackStackEntryCount(), Toast.LENGTH_SHORT).show();
                // Toast.makeText(this, "Mensaje " +fragmentManager.findFragmentByTag("generico").isVisible() , Toast.LENGTH_SHORT).show();

                break;
            case R.id.action_compose:
                /* Toast.makeText(this, "Mensaje " + item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                fragmentoDetalle = new Fragment_detail();
                fragmentManager.beginTransaction().replace(R.id.contenedor_main, fragmentoDetalle, "detalle").addToBackStack(null).commit();*/
                break;

        }

        return super.onOptionsItemSelected(item);
    }


}
