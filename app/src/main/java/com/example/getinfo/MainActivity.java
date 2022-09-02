package com.example.getinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText en_name,en_number,en_email;
    Button en_button;
    ImageView en_his;

    ArrayList<Object> mDetails;

    RecyclerView mRecyclerview;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutmanager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        en_name = findViewById(R.id.ip_name);
        en_number = findViewById(R.id.ip_number);
        en_email = findViewById(R.id.ip_email);
        en_button = findViewById(R.id.bt_save);


        en_his = findViewById(R.id.ip_history);

        en_his.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,history.class);
            }
        });

        en_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
            private void saveData(){
                SharedPreferences sharedPreferences = getSharedPreferences("shared prefrences ",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                Gson gson = new Gson();
                Object json = gson.toJson(mDetails);
                editor.putString("task list", (String) json);
                editor.apply();
            }

        });

    }


}