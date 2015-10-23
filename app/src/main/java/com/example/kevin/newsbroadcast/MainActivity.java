package com.example.kevin.newsbroadcast;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView lvNews;
    private NewsAdapter adapter;
    private List<News> newsList;

    public static final String GET_NEWS_URL = "http://192.168.1.3/NewsDemo/getNewsJSON.php";
    private Handler getNewsHandler = new Handler(){
        public void handleMessage(Message msg){
            String jsonData = (String) msg.obj;
            //System.out.println(jsonData);
            try{
                JSONArray jsonArray = new JSONArray(jsonData);
                for(int i = 0; i < jsonArray.length(); i++){
                    JSONObject object = jsonArray.getJSONObject(i);
                    String title = object.getString("title");
                    String description = object.getString("description");
                    String time = object.getString("time");
                    String content_url = object.getString("content_url");
                    String pic_url = object.getString("pic_url");
                    newsList.add(new News(title, description, time, content_url, pic_url));
                }
                adapter.notifyDataSetChanged();
            }catch (Exception e){
                e.printStackTrace();
            }
        };
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvNews = (ListView)findViewById(R.id.lvNews);
        newsList = new ArrayList<News>();
        adapter = new NewsAdapter(this, newsList);

        lvNews.setAdapter(adapter);
        lvNews.setOnItemClickListener(this);

        HttpUtils.getNewsJSON(GET_NEWS_URL, getNewsHandler);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        News news = newsList.get(position);
        Intent intent = new Intent(this, BrowseNewsActivity.class);
        intent.putExtra("content_url", news.getContent_url());
        startActivity(intent);
    }
}
