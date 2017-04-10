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

public class InformationTechnologyActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
{
    private static final String KEY = "COURSE_CODE";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_technology);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show(); */
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
            displaySelectedItem(R.id.homeit);
        }
        if (courseCode != null)
        {
            if (courseCode.equalsIgnoreCase("INFO3400"))
            {
                displaySelectedItem(R.id.info3400);
            }
            else if (courseCode.equalsIgnoreCase("INFO3410"))
            {
                displaySelectedItem(R.id.info3410);
            }
            else if (courseCode.equalsIgnoreCase("INFO3415"))
            {
                displaySelectedItem(R.id.info3415);
            }
            else if (courseCode.equalsIgnoreCase("INFO3440"))
            {
                displaySelectedItem(R.id.info3440);
            }
            else if (courseCode.equalsIgnoreCase("INFO3500"))
            {
                displaySelectedItem(R.id.info3500);
            }
//            else if (courseCode.equalsIgnoreCase("INFO3425"))
//            {
//                displaySelectedItem(R.id.info3425);
//            }
            else if (courseCode.equalsIgnoreCase("INFO3435"))
            {
                displaySelectedItem(R.id.info3435);
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
        getMenuInflater().inflate(R.menu.information_technology, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        displaySelectedItem(item.getItemId());
        return true;
    }

    private void displaySelectedItem(int id)
    {
        Fragment fragment = null;
        Bundle bundle = new Bundle();
        switch (id)
        {
            case R.id.homeit:
                fragment = new ITCardFragment();
                break;
            case R.id.info3400:
                fragment = new CompFragment();
                bundle.putString(KEY, "INFO3400");
                fragment.setArguments(bundle);
                break;
            case R.id.info3410:
                fragment = new CompFragment();
                bundle.putString(KEY, "INFO3410");
                fragment.setArguments(bundle);
                break;
            case R.id.info3415:
                fragment = new CompFragment();
                bundle.putString(KEY, "INFO3415");
                fragment.setArguments(bundle);
                break;
//            case R.id.info3425:
//                fragment = new CompFragment();
//                bundle.putString(KEY, "INFO3425");
//                fragment.setArguments(bundle);
//                break;
            case R.id.info3435:
                fragment = new CompFragment();
                bundle.putString(KEY, "INFO3435");
                fragment.setArguments(bundle);
                break;
            case R.id.info3440:
                fragment = new CompFragment();
                bundle.putString(KEY, "INFO3440");
                fragment.setArguments(bundle);
                break;
//            case R.id.info3490:
//                fragment = new CompFragment();
//                bundle.putString(KEY, "INFO3490");
//                fragment.setArguments(bundle);
//                break;
            case R.id.info3500:
                fragment = new CompFragment();
                bundle.putString(KEY, "INFO3500");
                fragment.setArguments(bundle);
                break;

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
}
