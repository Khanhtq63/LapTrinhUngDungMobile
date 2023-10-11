package com.tranquockhanh.adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> dsBaihat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findControl();
        dsBaihat = new ArrayList<String>();
        dsBaihat.add("Hiphop");
        dsBaihat.add("Bí rảy");
        dsBaihat.add("MTP");
        dsBaihat.add("Bin gi");
        dsBaihat.add("Paris by night");
        //b2 Tạo adapter
        ArrayAdapter<String> adapterQG;
        adapterQG = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                dsBaihat
        );

        autoBAIHAT.setAdapter(adapterQG);
        autoBAIHAT.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String itemChon = adapterBH.getItem(i);
                String itemChon = dsBaihat.get(i);
                String thongBao ="Bạn chọn bài: "+itemChon;
                Toast.makeText(MainActivity.this,thongBao,Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void findControl(){
       autoBAIHAT = findViewById(R.id.Baihat);
    }
    ListView autoBAIHAT;
}