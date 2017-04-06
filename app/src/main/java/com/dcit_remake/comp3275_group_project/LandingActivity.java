package com.dcit_remake.comp3275_group_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class LandingActivity extends AppCompatActivity
{

    private static final String TAG = "LandingActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        Log.d(TAG, "onCreate: Test From VCS");
    }

    public void goToHomepage(View view)
    {
        Intent intent = new Intent(getApplicationContext(), RevisedHomePageActivity.class);
        startActivity(intent);
    }
}
