package com.dcit_remake.comp3275_group_project;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Renado_Paria on 4/7/2017 at 5:58 PM for DcitApp.
 */

class LecturerAdapter extends RecyclerView.Adapter<LecturerAdapter.LecturerViewHolder>
{
    private List<Lecturer> mLecturerList;
    private Context mContext;

    LecturerAdapter(List<Lecturer> lecturerList, Context context)
    {
        mLecturerList = lecturerList;
        mContext = context;
    }

    @Override
    public LecturerViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lecturer_vue, parent, false);
        return new LecturerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LecturerViewHolder holder, int position)
    {
        final Lecturer lecturer = mLecturerList.get(position);
        Picasso.with(mContext)
                .load(lecturer.getUrlToProfilePicture())
                .error(R.drawable.lgb2_blur)
                .into(holder.mPicture);
        holder.mRoomNumber.setText(lecturer.getRoom());
        holder.mName.setText(lecturer.getName());
        holder.mPosition.setText(lecturer.getPosition());

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener()
        {
            @Override
            public boolean onLongClick(View v)
            {
                Intent intent = new Intent(mContext, LecturerDetailActivity.class);
                intent.putExtra("LECTURER", lecturer);
                mContext.startActivity(intent);
                return true;
            }
        });
    }

    @Override
    public int getItemCount()
    {
        if ((mLecturerList.size() != 0) && (mLecturerList != null))
        {
            return mLecturerList.size();
        }
        else
        {
            return 0;
        }
    }

    void loadData(List<Lecturer> lecturers)
    {
        mLecturerList = lecturers;
        notifyDataSetChanged();
    }

    static class LecturerViewHolder extends RecyclerView.ViewHolder
    {
        ImageView mPicture;
        TextView mName;
        TextView mPosition;
        TextView mRoomNumber;

        LecturerViewHolder(View itemView)
        {
            super(itemView);
            mPicture = (ImageView) itemView.findViewById(R.id.related_image_view);
            mName = (TextView) itemView.findViewById(R.id.lecturertitle);
            mPosition = (TextView) itemView.findViewById(R.id.position);
            mRoomNumber = (TextView) itemView.findViewById(R.id.roomnum);
        }
    }
}
