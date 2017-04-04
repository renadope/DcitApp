package com.dcit_remake.comp3275_group_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class LandingActivity extends AppCompatActivity {

    private static final String TAG = "LandingActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        Log.d(TAG, "onCreate: Hello");
    }
}
