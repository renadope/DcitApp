package com.dcit_remake.comp3275_group_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Renado_Paria on 4/6/2017 at 2:23 AM for DcitApp.
 */

public class CourseSelectionFragment extends Fragment implements View.OnClickListener
{
    private static final String TAG = "CourseSelectionFragment";

    public CourseSelectionFragment()
    {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: Starts");
        Log.d(TAG, "onCreate: Ends");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.program_fragment, container, false);
        view.findViewById(R.id.compSciButton).setOnClickListener(this);
        view.findViewById(R.id.ITButton).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v)
    {
        int id = v.getId();
        switch (id)
        {
            case R.id.compSciButton:
                startActivity(new Intent(getContext(), ComputerScienceActivity.class));
                break;
            case R.id.ITButton:
                startActivity(new Intent(getContext(), InformationTechnologyActivity.class));
                break;
        }
    }
}
