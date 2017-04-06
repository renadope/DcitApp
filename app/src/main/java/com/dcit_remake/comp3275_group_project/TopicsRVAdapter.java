package com.dcit_remake.comp3275_group_project;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Renado_Paria on 4/6/2017 at 5:49 PM for DcitApp.
 */

class TopicsRVAdapter extends RecyclerView.Adapter<TopicsRVAdapter.TopicsViewHolder>
{
    private List<String> mTopicList;
    private Context mContext;

    public TopicsRVAdapter(List<String> topicList, Context context)
    {
        mTopicList = topicList;
        mContext = context;
    }

    @Override
    public TopicsViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.topics_viewholder, parent, false);
        return new TopicsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TopicsViewHolder holder, int position)
    {
        String topic = mTopicList.get(position);
        holder.mTopic.setText(topic);
    }

    @Override
    public int getItemCount()
    {
        if ((mTopicList != null) && (mTopicList.size() != 0))
        {
            return mTopicList.size();
        }
        else
        {
            return 0;
        }
    }

    void loadTopics(List<String> topics)
    {
        mTopicList = topics;
        notifyDataSetChanged();
    }

    static class TopicsViewHolder extends RecyclerView.ViewHolder
    {
        TextView mTopic;

        public TopicsViewHolder(View itemView)
        {
            super(itemView);
            mTopic = (TextView) itemView.findViewById(R.id.topics);
        }
    }
}
