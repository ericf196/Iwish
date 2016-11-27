package com.example.workspace.iwish;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener, MenuItem.OnMenuItemClickListener {
    Fragment fragmentoGenerico = null;
    Fragment_detail fragmentoDetalle=null;
    ActionBar ab;
    FragmentManager fragmentManager;
    boolean bandera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();  //reemplazar fragments
        fragmentoGenerico = new Fragment_main();

        fragmentManager.beginTransaction().replace(R.id.contenedor_main, fragmentoGenerico, "generico").commit();

        fragmentManager.addOnBackStackChangedListener(this);
        setToolbar();

    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ab = getSupportActionBar();
        if (ab != null) {
            ab.setHomeAsUpIndicator(R.drawable.ic_back);
            // Poner ícono del drawer toggle
            ab.setDisplayHomeAsUpEnabled(false);

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        menu.findItem(R.id.action_search).setOnMenuItemClickListener(this);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                // Toast.makeText(this, "Mensaje " + fragmentManager.getBackStackEntryCount(), Toast.LENGTH_SHORT).show();
                // Toast.makeText(this, "Mensaje " +fragmentManager.findFragmentByTag("generico").isVisible() , Toast.LENGTH_SHORT).show();

                break;
            case R.id.action_compose:
               // Toast.makeText(this, "Mensaje " + item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                fragmentoDetalle = new Fragment_detail();
                fragmentManager.beginTransaction().replace(R.id.contenedor_main, fragmentoDetalle, "detalle").addToBackStack(null).commit();
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackStackChanged() {
        if (!fragmentManager.findFragmentByTag("generico").isVisible())
            ab.setDisplayHomeAsUpEnabled(true);
        else
            ab.setDisplayHomeAsUpEnabled(false);

    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        Toast.makeText(this, "onMenuItemClick", Toast.LENGTH_SHORT).show();

        return false;
    }
}
