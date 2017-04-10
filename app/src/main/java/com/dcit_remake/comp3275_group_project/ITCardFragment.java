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
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by Renado_Paria on 4/10/2017 at 12:45 AM for DcitApp.
 */

public class ITCardFragment extends Fragment implements ValueEventListener
{
    private static final String TAG = "ITCardFragment";
    private CoursesRVAdapter courseAdapter;

    public ITCardFragment()
    {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("COURSES");
        Query query = databaseReference.orderByChild("degree").equalTo("IT");
        query.addValueEventListener(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.recycler_vue, container, false);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManger = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManger);
        courseAdapter = new CoursesRVAdapter(new ArrayList<Course>(), getContext());
        recyclerView.setAdapter(courseAdapter);
        return recyclerView;
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot)
    {
        Log.d(TAG, "onDataChange: data = " + dataSnapshot.toString());
        ArrayList<Course> courses = new ArrayList<>();
        for (DataSnapshot snapData : dataSnapshot.getChildren())
        {
            Course course = snapData.getValue(Course.class);
            courses.add(course);
        }
        courseAdapter.loadCourses(courses);
    }

    @Override
    public void onCancelled(DatabaseError databaseError)
    {

    }
}
