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

public class NewsDetailActivity extends AppCompatActivity
{
    private static final String TAG = "NewsDetailActivity";
    private CollapsingToolbarLayout mFoldUpBar;
    private TextView mTitle;
    private TextView mArticleData;
    private ImageView mPhoto;

    private News mNews;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        Intent newsIntent = getIntent();
        mNews = (News) newsIntent.getSerializableExtra("NEWS");
        Log.d(TAG, "onCreate: news Obj =  " + mNews.toString());
        initWidgets();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null)
        {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void initWidgets()
    {
        mFoldUpBar = (CollapsingToolbarLayout) findViewById(R.id.collapsingtoolbar);
        mPhoto = (ImageView) findViewById(R.id.dexters_blood_slides);
        mTitle = (TextView) findViewById(R.id.title);
        mArticleData = (TextView) findViewById(R.id.articleData);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        mFoldUpBar.setTitle("DCIT");
        Picasso.with(this)
                .load(mNews.getUrlToImage())
                .error(R.drawable.lgb2_blur)
                .into(mPhoto);
        mTitle.setText(mNews.getTitle());
        mArticleData.setText(mNews.getContent());
    }
}
