package com.example.nh.recyclerview;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Item> items;


    String link = "https://www.simplifiedcoding.net/demos/marvel/";
    URL url;
    InputStream inputStream;
    String result, result2;
    HttpURLConnection urlConnection;
    StringBuffer buffer2 = new StringBuffer();
    String name;
    String team;
    String createdby;
    String firstappearance;
    String bio;
    String image1;
    StringBuffer buffer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycle);

        items = new ArrayList<>();
        new MyTask().execute();




    }

    public class MyTask extends AsyncTask<String, Void, ArrayList<Item>> {
        @Override
        protected ArrayList<Item> doInBackground(String... strings) {
            try {
                url = new URL(link);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }


            try {
                urlConnection = (HttpURLConnection) url.openConnection();

                urlConnection.setConnectTimeout(15000);
                urlConnection.setReadTimeout(15000);
                urlConnection.setRequestMethod("GET");
                inputStream = urlConnection.getInputStream();
                int responseCode = urlConnection.getResponseCode();
                int c = 0;

                buffer = new StringBuffer();
                if (responseCode == HttpURLConnection.HTTP_OK) {

                    while ((c = inputStream.read()) != -1) {
                        buffer.append((char) c);
                    }
                }
                result=buffer.toString();

                JSONArray array = new JSONArray(result);
                for (int i = 0; i < array.length(); i++) {
                    JSONObject object = array.getJSONObject(i);
                    String name = object.getString("name");
                    String team = object.getString("team");
                    String bio=object.getString("bio");
                    String imgUrl=object.getString("imageurl");
                    String author=object.getString("createdby");
                    String firstappearance=object.getString("firstappearance");
                    items.add(new Item(name, team,author, firstappearance,bio,imgUrl));

                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }

            result=buffer.toString();

            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return items;

            }

        @Override
        protected void onPostExecute(ArrayList<Item> items) {
            super.onPostExecute(items);
            ItemsAdapter adapter = new ItemsAdapter(MainActivity.this, items);
            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            recyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL));
            recyclerView.setAdapter(adapter);
        }
    }
}