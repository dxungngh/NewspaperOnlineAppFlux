package com.daniel.flux.newspaper.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.daniel.flux.newspaper.R;
import com.daniel.flux.newspaper.application.MyApplication;
import com.daniel.flux.newspaper.database.model.News;
import com.daniel.flux.newspaper.store.NewsStore;
import com.daniel.flux.newspaper.view.activity.NewsDetailActivity;
import com.nostra13.universalimageloader.core.ImageLoader;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by danielnguyen on 1/18/16.
 */
public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.NewsViewHolder> {
    private Context context;

    @Inject
    protected NewsStore newsStore;

    public NewsListAdapter(MyApplication myApplication, Context context) {
        this.context = context;
        myApplication.getComponent().inject(this);
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.holder_news, parent, false);
        NewsViewHolder viewHolder = new NewsViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        final News news = this.newsStore.getNewsListOfCategory().get(position);

        holder.titleTextView.setText(news.getTitle());
        ImageLoader.getInstance().displayImage(news.getAvatar(), holder.avatarImageView);

        holder.newsCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewsListAdapter.this.context, NewsDetailActivity.class);
                NewsListAdapter.this.newsStore.setCurrentNews(news);
                NewsListAdapter.this.context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.newsStore.getNewsListOfCategory().size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.holder_news_image)
        protected ImageView avatarImageView;
        @Bind(R.id.holder_news_title)
        protected TextView titleTextView;
        @Bind(R.id.holder_news_layout)
        protected CardView newsCardView;

        public NewsViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}