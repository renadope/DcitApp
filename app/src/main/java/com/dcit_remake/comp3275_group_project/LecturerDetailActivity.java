package com.dcit_remake.comp3275_group_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class LecturerDetailActivity extends AppCompatActivity
{
    private static final String TAG = "LecturerDetailActivity";

    private Lecturer mLecturer;
    private CollapsingToolbarLayout mFoldUpBar;
    private TextView mTitle;
    private TextView mPosition;
    private ImageView mPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer_detail);
        initWidgets();
        Intent lecIntent = getIntent();
        mLecturer = (Lecturer) lecIntent.getSerializableExtra("LECTURER");
        Log.d(TAG, "onCreate: lecturer = " + mLecturer.toString());
    }

    private void initWidgets()
    {
        mFoldUpBar = (CollapsingToolbarLayout) findViewById(R.id.collapsingtoolbar);
        mPhoto = (ImageView) findViewById(R.id.dexters_blood_slides);
        mTitle = (TextView) findViewById(R.id.name);
        mPosition = (TextView) findViewById(R.id.position);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null)
        {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setDisplayShowTitleEnabled(false);
        }
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Picasso.with(this)
                .load(mLecturer.getUrlToProfilePicture())
                .error(R.drawable.lgb2_blur)
                .into(mPhoto);
        mTitle.setText(mLecturer.getName());
        mPosition.setText(mLecturer.getPosition());
        mFoldUpBar.setTitleEnabled(false);
    }
}
