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
 * Created by Renado_Paria on 4/6/2017 at 11:59 PM for DcitApp.
 */

public class NewsFragment extends Fragment implements ValueEventListener
{
    private static final String TAG = "NewsFragment";
    private NewsAdapter mNewsAdapter;

    public NewsFragment()
    {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: starts");
        DatabaseReference dbref = FirebaseDatabase.getInstance().getReference().child("NEWS");
        Query jQuery = dbref.orderByChild("title");
        jQuery.addValueEventListener(this);

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
        mNewsAdapter = new NewsAdapter(new ArrayList<News>(), getContext());
        recyclerView.setAdapter(mNewsAdapter);
        return recyclerView;
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot)
    {
        ArrayList<News> newsList = new ArrayList<>();
        News news;
        for (DataSnapshot snapData : dataSnapshot.getChildren())
        {
            String title = snapData.child("title").getValue().toString();
            String urlToImage = snapData.child("urlToImage").getValue().toString();
            String content = snapData.child("content").getValue().toString();

            news = new News(title, urlToImage, content);
            Log.d(TAG, "onDataChange: news obj= " + news.toString());
            newsList.add(news);
        }
        mNewsAdapter.loadNewData(newsList);
        Log.d(TAG, "onDataChange: SIZE OF NEWS LIST = " + newsList.size());
        Log.d(TAG, "onDataChange: ARRAY LIST CONTENTS = " + newsList.toString());
    }

    @Override
    public void onCancelled(DatabaseError databaseError)
    {

    }
}
