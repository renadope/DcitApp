package com.dcit_remake.comp3275_group_project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class TempActivity extends AppCompatActivity
{
    private static final String TAG = "TempActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);

        final DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("COURSES");
        ArrayList<String> preReqs = new ArrayList<>();
        preReqs.add("INFO 2400");
        preReqs.add("INFO 2420");
        ArrayList<String> Topics = new ArrayList<>();
        Topics.add("Assessing project feasibility");
        Topics.add("Methods of investigation.");
        Topics.add("Project planning");
        Topics.add("Project management methodology");
        Topics.add("E-commerce marketing strategies");
        Topics.add("Select and implement an appropriate project on some topic in IT. This may include design and implementation of a computer application.");

        final Course courseToPush = new Course("Core", "INFO3490", "2323", "Project", 3, 4, preReqs, Topics,
                "This course provides broad coverage of e-commerce systems. It covers the various e-commerce business models and e-commerce payment systems.",
                "Put Lecturer Name Here", "Put His ID here");
        findViewById(R.id.pushtofirebase).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dbRef.push().setValue(courseToPush);
            }
        });
    }
}
