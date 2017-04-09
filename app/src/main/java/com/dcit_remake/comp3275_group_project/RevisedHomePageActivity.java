package com.dcit_remake.comp3275_group_project;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;


public class RevisedHomePageActivity extends AppCompatActivity
{
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener()
    {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item)
        {
            displaySelectedItem(item.getItemId());
            return true;
        }

    };

    private void displaySelectedItem(int itemId)
    {
        Fragment fragment = null;
        switch (itemId)
        {
            case R.id.programmes:
                fragment = new CourseSelectionFragment();
                break;
            case R.id.News:
                fragment = new NewsFragment();
                break;
            case R.id.Staff:
                fragment = new LecturerFragment();
                break;
        }

        if (fragment != null)
        {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame, fragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revised_home_page);
        displaySelectedItem(R.id.programmes);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null)
        {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }

    }

}
