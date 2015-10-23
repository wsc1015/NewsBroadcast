package com.example.kevin.newsbroadcast;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Kevin on 10/7/2015.
 */
public class NewsAdapter extends BaseAdapter {

    private Context context;
    List<News> newsList;

    public NewsAdapter(Context context, List<News> newsList){
        this.context = context;
        this.newsList = newsList;
    }

    @Override
    public int getCount() {
        return newsList.size();
    }

    @Override
    public News getItem(int position) {
        return newsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.news_item, null);
        }
        TextView tvTitle = (TextView)convertView.findViewById(R.id.tvTitle);
        TextView tvDesc = (TextView)convertView.findViewById(R.id.tvDesc);
        TextView tvTime = (TextView)convertView.findViewById(R.id.tvTime);
        ImageView ivPic = (ImageView)convertView.findViewById(R.id.ivPic);

        News news = newsList.get(position);
        tvTitle.setText(news.getTitle());
        tvDesc.setText(news.getDescription());
        tvTime.setText(news.getTime());

        String pic_url = news.getPic_url();
        HttpUtils.setPicBitmap(ivPic, pic_url);
        return convertView;
    }
}
