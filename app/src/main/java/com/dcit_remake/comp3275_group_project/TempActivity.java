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
        preReqs.add("COMP 3150");
        ArrayList<String> Topics = new ArrayList<>();
        Topics.add("Discrete and Continuous Systems");
        Topics.add("Discrete-Event System Simulation; Dynamic Allocation and Linked Lists");
        Topics.add("Queuing Models; Steady-State Behavior of Infinite-Population Markovian Models");
        Topics.add("Single-Server Queues with Poisson Arrivals and Unlimited Capacity");
        Topics.add("Mobile Internet Protocol");
        Topics.add("Application Aware and application transparent adaptation");
        Topics.add("Analysis of Simulation Data; Goodness-of-Fit Tests, Chi-Square Test");
        Topics.add("Non-stationary Poisson Process");
        Topics.add("Output Analysis for Terminating Simulations");
        Topics.add("Error Estimation for Steady-State Simulation");
        final Course courseToPush = new Course("Core", "COMP3950", "2323", "Modelling and Simulation", 3, 4, preReqs, Topics,
                "This course covers basic to intermediate techniques for discrete event simulation of common scenarios." +
                        " It draws on concepts from the theory of computation and computer programming. In many real world situations, it is infeasible to develop a precise mathematical model with a closed-form analytic solution for a given problem. Modeling and simulation is a means of coping with this type of problem.",
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
