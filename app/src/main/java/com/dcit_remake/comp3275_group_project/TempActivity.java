package com.dcit_remake.comp3275_group_project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TempActivity extends AppCompatActivity
{
    private static final String TAG = "TempActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);

//        final DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("COURSES");
//        ArrayList<String> preReqs = new ArrayList<>();
//        preReqs.add("INFO 2400");
//        preReqs.add("INFO 2420");
//        ArrayList<String> Topics = new ArrayList<>();
//        Topics.add("Assessing project feasibility");
//        Topics.add("Methods of investigation.");
//        Topics.add("Project planning");
//        Topics.add("Project management methodology");
//        Topics.add("E-commerce marketing strategies");
//        Topics.add("Select and implement an appropriate project on some topic in IT. This may include design and implementation of a computer application.");
//
//        final Course courseToPush = new Course("Core", "INFO3490", "2323", "Project", 3, 4, preReqs, Topics,
//                "This course provides broad coverage of e-commerce systems. It covers the various e-commerce business models and e-commerce payment systems.",
//                "Put Lecturer Name Here", "Put His ID here");
       final News news = new News("Christian John Has Broken History Records As The SportJunkie Website has become a BlockBuster Success",
                "http://az616578.vo.msecnd.net/files/2016/06/10/636011804533596877279417241_o-SUCCESS-facebook-3.jpg","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam a quam at lacus convallis scelerisque non at odio. Suspendisse non congue urna. Etiam molestie elementum venenatis. Integer lacinia finibus justo, non cursus quam ullamcorper at. Phasellus vitae ex massa. Etiam pretium nunc nibh, at luctus ex volutpat vel. Phasellus lacinia massa fringilla, molestie elit ut, ornare nisl. Sed auctor risus urna, eu sagittis elit tristique at. Phasellus malesuada nec leo non feugiat. Duis et pulvinar tortor. Donec nec vestibulum ligula, a malesuada risus.\n" +
                "\n" +
                "Phasellus gravida rhoncus suscipit. Sed bibendum rutrum purus quis sollicitudin. Aliquam lacus erat, malesuada a varius non, viverra vel nibh. Proin ut vestibulum tellus. Sed suscipit finibus enim non bibendum. Etiam enim ex, malesuada sed mattis quis, cursus vitae risus. In posuere ex ut felis pharetra varius. Aliquam dictum molestie urna, at sollicitudin mauris posuere et. Aliquam efficitur malesuada felis, a fringilla turpis euismod sed. Donec vel ornare ex. Sed finibus leo mauris, non finibus odio dignissim sit amet.");

        final DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("NEWS");
        findViewById(R.id.pushtofirebase).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dbRef.push().setValue(news);
            }
        });
    }
}
