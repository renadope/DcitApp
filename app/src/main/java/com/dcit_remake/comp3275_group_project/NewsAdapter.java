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
 * Created by Renado_Paria on 4/7/2017 at 12:01 AM for DcitApp.
 */

class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder>
{
    private List<News> mNewsList;
    private Context mContext;

    NewsAdapter(List<News> newsList, Context context)
    {
        mNewsList = newsList;
        mContext = context;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View vue = LayoutInflater.from(parent.getContext()).inflate(R.layout.newsview, parent, false);
        return new NewsViewHolder(vue);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position)
    {
        final News news = mNewsList.get(position);
        Picasso.with(mContext)
                .load(news.getUrlToImage())
                .error(R.drawable.lgb2_blur)
                .into(holder.mPictora);
        holder.title.setText(news.getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                goToActualArticle(news);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener()
        {
            @Override
            public boolean onLongClick(View v)
            {
                sharedIntent();
                return true;
            }
        });
    }

    private void sharedIntent()
    {
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT, "DCIT News Page: " + "https://sta.uwi.edu/fst/dcit/news.asp");
        shareIntent.setType("text/plain");
        mContext.startActivity(Intent.createChooser(shareIntent, "Share With.."));
    }

    private void goToActualArticle(News news)
    {
        Intent intent = new Intent(mContext, NewsDetailActivity.class);
        intent.putExtra("NEWS", news);
        mContext.startActivity(intent);
    }

    @Override
    public int getItemCount()
    {
        if ((mNewsList.size() != 0) && (mNewsList != null))
        {
            return mNewsList.size();
        }
        else
        {
            return 0;
        }
    }

    void loadNewData(List<News> newsList)
    {
        mNewsList = newsList;
        notifyDataSetChanged();
    }

    static class NewsViewHolder extends RecyclerView.ViewHolder
    {
        ImageView mPictora;
        TextView title;

        public NewsViewHolder(View itemView)
        {
            super(itemView);

            mPictora = (ImageView) itemView.findViewById(R.id.card_image);
            title = (TextView) itemView.findViewById(R.id.card_title);
        }
    }
}
