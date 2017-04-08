package com.dcit_remake.comp3275_group_project;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LecturerDetailActivity extends AppCompatActivity implements View.OnClickListener
{
    private static final String TAG = "LecturerDetailActivity";

    private Lecturer mLecturer;
    private CollapsingToolbarLayout mFoldUpBar;
    private TextView mTitle;
    private TextView mEmail;
    private TextView mPosition;
    private ImageView mPhoto;
    private TextView mPhone;

    private Button mEmailButton;
    private Button mSMSButton;

    private TopicsRVAdapter mHawaii;
    private TopicsRVAdapter mInchest;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer_detail);
        initWidgets();
        educationRecyclerViewSetUp();
        interestRecyclerViewSetUp();
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
        mEmail = (TextView) findViewById(R.id.email);
        mPhone = (TextView) findViewById(R.id.phone);
        mEmailButton = (Button) findViewById(R.id.emailbutton);
        mSMSButton = (Button) findViewById(R.id.smsbuton);

        mEmailButton.setOnClickListener(this);
        mSMSButton.setOnClickListener(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null)
        {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setDisplayShowTitleEnabled(false);
        }
    }

    private void educationRecyclerViewSetUp()
    {
        RecyclerView rv = (RecyclerView) findViewById(R.id.edurv);
        rv.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rv.getContext(), linearLayoutManager.getOrientation());
        rv.addItemDecoration(dividerItemDecoration);
        mHawaii = new TopicsRVAdapter(new ArrayList<String>(), getApplicationContext());
        rv.setAdapter(mHawaii);
    }

    private void interestRecyclerViewSetUp()
    {
        RecyclerView rv = (RecyclerView) findViewById(R.id.intrv);
        rv.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rv.getContext(), linearLayoutManager.getOrientation());
        rv.addItemDecoration(dividerItemDecoration);
        mInchest = new TopicsRVAdapter(new ArrayList<String>(), getApplicationContext());
        rv.setAdapter(mInchest);
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
        mHawaii.loadTopics(mLecturer.getEducation());
        mInchest.loadTopics(mLecturer.getAreasOfInterest());
        mEmail.setText(mLecturer.getEmail());
        mPhone.setText(mLecturer.getOfficecontact() + ", Extension: " + mLecturer.getContactextension());
    }

    @Override
    public void onClick(View v)
    {
        int id = v.getId();
        switch (id)
        {
            case R.id.emailbutton:
                Log.d(TAG, "onClick: email button Clicked");
                emailIntent();
                break;
            case R.id.smsbuton:
                Log.d(TAG, "onClick: sms Button Clicked");
                smsIntent();
                break;
        }
    }

    private void emailIntent()
    {
        String recipient[] = new String[1];
        recipient[0] = mLecturer.getEmail();
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, recipient);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Type Your Subject Here");
        if (intent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(intent);
        }
    }

    private void smsIntent()
    {
        Log.d(TAG, "smsIntent: " + mLecturer.getSmsContact());
//        Intent smsIntent = new Intent(Intent.ACTION_VIEW);
//        smsIntent.setType("vnd.android-dir/mms-sms");
//        smsIntent.putExtra("address", mLecturer.getSmsContact());
//        smsIntent.putExtra("sms_body", "Type Message Here");
//        startActivity(smsIntent);
//        Intent intent = new Intent(Intent.ACTION_MAIN);
//        intent.addCategory(Intent.CATEGORY_APP_MESSAGING);
//        startActivity(intent);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:")); // This ensures only SMS apps respond
        intent.putExtra("sms_body", "Message");
        intent.putExtra("address", mLecturer.getSmsContact());
        if (intent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(intent);
        }
    }
}
