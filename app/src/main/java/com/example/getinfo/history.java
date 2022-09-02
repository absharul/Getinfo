package com.example.getinfo;


import android.content.SharedPreferences;
import android.os.Bundle;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class history extends MainActivity{

    RecyclerView mRecyclerview;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutmanager;



    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.hisct);

        loadData();

        mRecyclerview = findViewById(R.id.dp_recy);

        mRecyclerview.setHasFixedSize(true);
        mLayoutmanager = new LinearLayoutManager(this);
        mAdapter = new MainAdapter(mDetails);
        mRecyclerview.setLayoutManager(mLayoutmanager);
        mRecyclerview.setAdapter(mAdapter);

        mDetails.add(en_name);
        mDetails.add(en_number);
        mDetails.add(en_email);



    }
    private void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared prefrences ",MODE_PRIVATE);
        Gson gson = new Gson();
        Object json = sharedPreferences.getString("task list",null);
        Type type = new TypeToken<ArrayList<MainActivity>>() {}.getType();
        mDetails =gson.fromJson((JsonElement) json,type);

        if(mDetails == null){
            mDetails = new ArrayList<>();
        }
    }
}
