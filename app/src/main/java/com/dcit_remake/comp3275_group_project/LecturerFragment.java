package com.dcit_remake.comp3275_group_project;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by Renado_Paria on 4/7/2017 at 5:53 PM for DcitApp.
 */

public class LecturerFragment extends Fragment implements ValueEventListener
{
    private static final String TAG = "LecturerFragment";
    private LecturerAdapter mLecAdapt;

    public LecturerFragment()
    {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: starts");
        DatabaseReference dbref = FirebaseDatabase.getInstance().getReference().child("LECTURERS");
        dbref.addValueEventListener(this);
        Log.d(TAG, "onCreate: ref " + dbref.toString());
        Log.d(TAG, "onCreate: ends");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.recycler_vue, container, false);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManger = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManger);
        mLecAdapt = new LecturerAdapter(new ArrayList<Lecturer>(), getContext());
        recyclerView.setAdapter(mLecAdapt);
        return recyclerView;
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot)
    {
        Log.d(TAG, "onDataChange: " + dataSnapshot.toString());
        Lecturer leckchurer = null;
        GenericTypeIndicator<ArrayList<String>> arrayListGenericTypeIndicator
                = new GenericTypeIndicator<ArrayList<String>>()
        {
        };
        String name = null;
        String academicRole = null;
        String contactExtenstion = null;
        String email = null;
        String position = null;
        String rooom = null;
        String smsContact = null;
        String urlToProfilePicture = null;
        ArrayList<String> areasOfInterest = null;
        ArrayList<String> education = null;

        ArrayList<Lecturer> loademupguys = new ArrayList<>();
        for (DataSnapshot snapshot : dataSnapshot.getChildren())
        {
            name = snapshot.child("name").getValue().toString();
            academicRole = snapshot.child("academicRole").getValue().toString();
            contactExtenstion = snapshot.child("contactextension").getValue().toString();
            email = snapshot.child("email").getValue().toString();
            position = snapshot.child("position").getValue().toString();
            rooom = snapshot.child("room").getValue().toString();
            urlToProfilePicture = snapshot.child("urlToProfilePicture").getValue().toString();
            smsContact = snapshot.child("smsContact").getValue().toString();
            areasOfInterest = snapshot.child("areasOfInterest").getValue(arrayListGenericTypeIndicator);
            education = snapshot.child("education").getValue(arrayListGenericTypeIndicator);
            Log.d(TAG, "onDataChange: NAME = " + name);
            Log.d(TAG, "onDataChange: academic Role= " + academicRole);
            Log.d(TAG, "onDataChange: extension = " + contactExtenstion);
            Log.d(TAG, "onDataChange: email = " + email);
            Log.d(TAG, "onDataChange: postion = " + position);
            Log.d(TAG, "onDataChange: room =" + rooom);
            Log.d(TAG, "onDataChange: smscontact = " + smsContact);
            Log.d(TAG, "onDataChange: url = " + urlToProfilePicture);
            Log.d(TAG, "onDataChange: aread of interest = " + areasOfInterest);
            Log.d(TAG, "onDataChange: education = " + education);
            leckchurer = new Lecturer(name, position, education, academicRole, areasOfInterest, contactExtenstion, smsContact, rooom, email, urlToProfilePicture);
            loademupguys.add(leckchurer);
        }
        mLecAdapt.loadData(loademupguys);
    }

    @Override
    public void onCancelled(DatabaseError databaseError)
    {

    }
}
