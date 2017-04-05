package com.dcit_remake.comp3275_group_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class HomepageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
    }

    public void goToIT(View view){
        Intent intent = new Intent(getApplicationContext(), InformationTechnologyActivity.class);
        startActivity(intent);
    }

    public void goToCompSci(View view){
        Intent intent = new Intent(getApplicationContext(), ComputerScienceActivity.class);
        startActivity(intent);
    }
}
