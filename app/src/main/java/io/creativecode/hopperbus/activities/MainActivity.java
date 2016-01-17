package io.creativecode.hopperbus.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;

import io.creativecode.hopperbus.R;
import io.creativecode.hopperbus.fragments.RouteFragment;
import io.creativecode.hopperbus.presenters.DataProvider;


public class MainActivity extends ActionBarActivity  {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configureActionBar();

        Log.i("Rfkjfjkfjf", "FaifffhjhfhRRd");

        DataProvider p = new DataProvider(this);

        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            RouteFragment fragment = new RouteFragment();
            transaction.replace(R.id.sample_content_fragment, fragment);
            transaction.commit();
        }
    }

    private void configureActionBar() {
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.hb_logo);
        getSupportActionBar().setElevation(0);
    }
}
