package com.dcit_remake.comp3275_group_project;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by Renado_Paria on 4/6/2017 at 2:35 PM for DcitApp.
 */

public class CompFragment extends Fragment implements ValueEventListener
{
    private static final String TAG = "CompFragment";
    private static final String KEY = "COURSE_CODE";

    private TextView mCourseTitle;
    private TextView mCourseName;
    private TextView mLevelNumber;
    private TextView mCourseCredits;
    private TextView mCourseType;
    private TextView mCourseDescription;
    private TextView mSemOffered;
    private TopicsRVAdapter mTopicsRVAdapter;

    public CompFragment()
    {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: Starts");
        String courseCode = getArguments().getString(KEY);
        DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("COURSES");
        Query jQuery = dbRef.orderByChild("courseCode").equalTo(courseCode);
        jQuery.addValueEventListener(this);
        Log.d(TAG, "onCreate: course code: " + courseCode);
        Log.d(TAG, "onCreate: Ends");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.comp_fragment, container, false);
        initWidgets(view);
        return view;
    }

    private void initWidgets(View view)
    {
        mCourseTitle = (TextView) view.findViewById(R.id.courseCode);
        mCourseName = (TextView) view.findViewById(R.id.CourseName);
        mLevelNumber = (TextView) view.findViewById(R.id.actualLevelNumber);
        mCourseCredits = (TextView) view.findViewById(R.id.coursecredits);
        mCourseType = (TextView) view.findViewById(R.id.coursetype);
        mCourseDescription = (TextView) view.findViewById(R.id.courseDesc);
        mSemOffered = (TextView) view.findViewById(R.id.semesterOffered);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.topicsrecyclerview);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        mTopicsRVAdapter = new TopicsRVAdapter(new ArrayList<String>(), getContext());
        recyclerView.setAdapter(mTopicsRVAdapter);
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot)
    {
        Log.d(TAG, "onDataChange: ");
        String courseCode = null;
        String courseDescription = null;
        String courseName = null;
        Long credits = null;
        Long level = null;
        String semester = null;
        String type = null;
        //Log.d(TAG, "onDataChange: data = " + dataSnapshot.toString());
//        Course courseData = dataSnapshot.getValue(Course.class);
        GenericTypeIndicator<ArrayList<String>> arrayListTypeIndicator = new GenericTypeIndicator<ArrayList<String>>()
        {
        };
        ArrayList<String> topics = null;
        ArrayList<String> preReqs;
        for (DataSnapshot snapData : dataSnapshot.getChildren())
        {
            courseCode = snapData.child("courseCode").getValue().toString();
            courseDescription = snapData.child("courseDescription").getValue().toString();
            courseName = snapData.child("courseName").getValue().toString();
            credits = (Long) snapData.child("credits").getValue();
            level = (Long) snapData.child("level").getValue();
            topics = snapData.child("topics").getValue(arrayListTypeIndicator);
            preReqs = snapData.child("preRequsites").getValue(arrayListTypeIndicator);
            semester = snapData.child("semeseter").getValue().toString();
            type = snapData.child("type").getValue().toString();
            Log.d(TAG, "onDataChange: code: " + courseCode);
            Log.d(TAG, "onDataChange: course Desc: " + courseDescription);
            Log.d(TAG, "onDataChange: course Name: " + courseName);
            Log.d(TAG, "onDataChange: Number OF Credits " + credits.toString());
            Log.d(TAG, "onDataChange: level= " + level.toString());
            Log.d(TAG, "onDataChange: topics = " + topics.toString());
            Log.d(TAG, "onDataChange: pre reqs = " + preReqs.toString());
            Log.d(TAG, "onDataChange: semester = " + semester);
            Log.d(TAG, "onDataChange: type = " + type);

        }
        mCourseTitle.setText(courseCode);
        mCourseName.setText(courseName);
        mLevelNumber.setText(level.toString());
        mCourseCredits.setText(credits.toString());
        mCourseType.setText(type);
        mCourseDescription.setText(courseDescription);
        mSemOffered.setText(getString(R.string.semoffer) + semester);
        mTopicsRVAdapter.loadTopics(topics);
    }

    @Override
    public void onCancelled(DatabaseError databaseError)
    {

    }
}
