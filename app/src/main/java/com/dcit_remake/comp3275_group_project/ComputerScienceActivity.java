package com.dcit_remake.comp3275_group_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class ComputerScienceActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
{
    private static final String KEY = "COURSE_CODE";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_science);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(), RevisedHomePageActivity.class);
                startActivity(intent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        Intent intent = getIntent();
        String courseCode = intent.getStringExtra("CODE");
        if (courseCode == null)
        {
            displaySelectedItem(R.id.homecomp);
        }
        if (courseCode != null)
        {
            if (courseCode.equalsIgnoreCase("COMP3000"))
            {
                displaySelectedItem(R.id.comp3000);
            }
            else if (courseCode.equalsIgnoreCase("COMP3150"))
            {
                displaySelectedItem(R.id.comp3150);
            }
            else if (courseCode.equalsIgnoreCase("COMP3100"))
            {
                displaySelectedItem(R.id.comp3100);
            }
            else if (courseCode.equalsIgnoreCase("COMP3250"))
            {
                displaySelectedItem(R.id.comp3250);
            }
            else if (courseCode.equalsIgnoreCase("COMP3275"))
            {
                displaySelectedItem(R.id.comp3275);
            }
            else if (courseCode.equalsIgnoreCase("COMP3550"))
            {
                displaySelectedItem(R.id.comp3550);
            }
            else if (courseCode.equalsIgnoreCase("COMP3850"))
            {
                displaySelectedItem(R.id.comp3850);
            }
            else if (courseCode.equalsIgnoreCase("COMP3950"))
            {
                displaySelectedItem(R.id.comp3950);
            }
        }


    }

    @Override
    public void onBackPressed()
    {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.computer_science, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void displaySelectedItem(int itemId)
    {
        Fragment fragment = null;
        Bundle bundle = new Bundle();
        switch (itemId)
        {
            case R.id.homecomp:
                Toast.makeText(getApplicationContext(), "Home Comp", Toast.LENGTH_LONG).show();
                fragment = new COMPCardFragment();
                break;
            case R.id.comp3000:
                fragment = new CompFragment();
                bundle.putString(KEY, "COMP3000");
                fragment.setArguments(bundle);
                break;
            case R.id.comp3100:
                fragment = new CompFragment();
                bundle.putString(KEY, "COMP3100");
                fragment.setArguments(bundle);
                break;
            case R.id.comp3150:
                fragment = new CompFragment();
                bundle.putString(KEY, "COMP3150");
                fragment.setArguments(bundle);
                break;
            case R.id.comp3250:
                fragment = new CompFragment();
                bundle.putString(KEY, "COMP3250");
                fragment.setArguments(bundle);
                break;
            case R.id.comp3275:
                fragment = new CompFragment();
                bundle.putString(KEY, "COMP3275");
                fragment.setArguments(bundle);
                break;
            case R.id.comp3550:
                fragment = new CompFragment();
                bundle.putString(KEY, "COMP3550");
                fragment.setArguments(bundle);
                break;
            case R.id.comp3850:
                fragment = new CompFragment();
                bundle.putString(KEY, "COMP3850");
                fragment.setArguments(bundle);
                break;
            case R.id.comp3950:
                fragment = new CompFragment();
                bundle.putString(KEY, "COMP3950");
                fragment.setArguments(bundle);
                break;
            //add comp 3990

        }

        if (fragment != null)
        {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame, fragment);
            fragmentTransaction.commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        // Handle navigation view item clicks here.
        displaySelectedItem(item.getItemId());
        return true;
    }
}
