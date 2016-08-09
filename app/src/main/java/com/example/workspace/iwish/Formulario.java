package com.example.workspace.iwish;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.app.FragmentTransaction;


public class Formulario extends AppCompatActivity implements View.OnFocusChangeListener,View.OnTouchListener{


    EditText txtFecha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

    }

    @Override
    protected void onStart() {
        super.onStart();
        txtFecha= (EditText) findViewById(R.id.fecha);
        txtFecha.setOnFocusChangeListener(this);
        txtFecha.setOnTouchListener(this);


    }

    @Override
    public void onFocusChange(View view, boolean hasFocus) {

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if(motionEvent.getAction()==motionEvent.ACTION_DOWN) {
            DateDialog dialog = new DateDialog(view);
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            dialog.show(transaction, "Fecha");
        }
        return true;
    }
}
