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
import com.daniel.flux.newspaper.view.activity.NewsListActivity;
import com.nostra13.universalimageloader.core.ImageLoader;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by danielnguyen on 1/18/16.
 */
public class CategoriesListAdapter extends RecyclerView.Adapter<CategoriesListAdapter.CategoryViewHolder> {
    private static final String TAG = CategoriesListAdapter.class.getSimpleName();

    private Context context;

    @Inject
    protected NewsStore newsStore;

    public CategoriesListAdapter(MyApplication myApplication, Context context) {
        this.context = context;
        myApplication.getComponent().inject(this);
    }

    @Override
    public CategoriesListAdapter.CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.holder_category, parent, false);
        CategoryViewHolder viewHolder = new CategoryViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        final News news = this.newsStore.getCategoriesList().get(position);

        holder.titleTextView.setText(news.getListName());
        ImageLoader.getInstance().displayImage(news.getAvatar(), holder.mainImageView);

        holder.categoryCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoriesListAdapter.this.context, NewsListActivity.class);
                CategoriesListAdapter.this.newsStore.setCurrentCategory(news);
                CategoriesListAdapter.this.context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.newsStore.getCategoriesList().size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.holder_category_main_image)
        protected ImageView mainImageView;
        @Bind(R.id.holder_category_title)
        protected TextView titleTextView;
        @Bind(R.id.holder_category_layout)
        protected CardView categoryCardView;

        public CategoryViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}