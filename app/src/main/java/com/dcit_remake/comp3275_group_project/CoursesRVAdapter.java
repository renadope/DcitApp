package com.dcit_remake.comp3275_group_project;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Renado_Paria on 4/10/2017 at 12:12 AM for DcitApp.
 */

public class CoursesRVAdapter extends RecyclerView.Adapter<CoursesRVAdapter.CourseCardViewHolder>
{
    private List<Course> mCoursesList;
    private Context mContext;

    public CoursesRVAdapter(List<Course> coursesList, Context context)
    {
        mCoursesList = coursesList;
        mContext = context;
    }

    @Override
    public CourseCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new CourseCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CourseCardViewHolder holder, int position)
    {
        final Course course = mCoursesList.get(position);
        holder.mCourseCode.setText(course.getCourseCode());
        holder.mCourseDegree.setText(course.getDegree());
        holder.courseImage.setImageResource(R.drawable.lgb2_blur);

        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (course.getDegree().equalsIgnoreCase("COMP"))
                {
                    Intent intent = new Intent(mContext, ComputerScienceActivity.class);
                    intent.putExtra("CODE", course.getCourseCode());
                    mContext.startActivity(intent);
                }
                else if (course.getDegree().equalsIgnoreCase("IT"))
                {
                    Intent intent2 = new Intent(mContext, InformationTechnologyActivity.class);
                    intent2.putExtra("CODE", course.getCourseCode());
                    mContext.startActivity(intent2);
                }
            }
        });
    }

    @Override
    public int getItemCount()
    {
        if ((mCoursesList.size() != 0) && (mCoursesList != null))
        {
            return mCoursesList.size();
        }
        else
        {
            return 0;
        }
    }

    void loadCourses(List<Course> list)
    {
        mCoursesList = list;
        notifyDataSetChanged();
    }

    static class CourseCardViewHolder extends RecyclerView.ViewHolder
    {
        ImageView courseImage;
        TextView mCourseDegree;
        TextView mCourseCode;

        public CourseCardViewHolder(View itemView)
        {
            super(itemView);
            courseImage = (ImageView) itemView.findViewById(R.id.card_image);
            mCourseCode = (TextView) itemView.findViewById(R.id.card_title);
            mCourseDegree = (TextView) itemView.findViewById(R.id.card_category);

        }
    }
}
