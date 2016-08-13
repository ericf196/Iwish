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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener, MenuItem.OnMenuItemClickListener{
    Fragment fragmentoGenerico = null;

    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setToolbar();

        fragmentManager = getSupportFragmentManager();  //reemplazar fragments
        fragmentoGenerico = new Fragment_main();

        fragmentManager.beginTransaction().replace(R.id.contenedor_main, fragmentoGenerico).commit(); // El toolbar lo trabajamos por aqui


        fragmentManager.addOnBackStackChangedListener(this);

    }

    private void setToolbar() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            // Poner ícono del drawer toggle
            ab.setHomeAsUpIndicator(R.drawable.ic_back);
            ab.setDisplayHomeAsUpEnabled(true);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        List<Fragment> fragments= fragmentManager.getFragments();


        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
       // menu.findItem(R.id.action_search).setVisible(false);
        menu.findItem(R.id.action_search).setOnMenuItemClickListener(this);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
               // onBackPressed();
                Toast.makeText(this, "Mensaje "+fragmentManager.getBackStackEntryCount(), Toast.LENGTH_SHORT).show();
                /*if(fragmentManager.findFragmentById(R.id.fragmentDetail))

                    fragmentManager.findFragmentById(R.id.fragmentDetail).*/
                break;
            case R.id.action_compose:
                Toast.makeText(this, "Mensaje "+ item.getTitle().toString(), Toast.LENGTH_SHORT).show();

                break;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackStackChanged() {
            Log.v("Mensaje", "Aqui estoy");

    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        Toast.makeText(this, "onMenuItemClick", Toast.LENGTH_SHORT).show();

        return false;
    }
}
