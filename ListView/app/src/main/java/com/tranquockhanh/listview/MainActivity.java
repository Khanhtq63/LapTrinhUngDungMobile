package com.tranquockhanh.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Country> dsQuocGia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Chuẩn bị dữ liệu
        dsQuocGia = new ArrayList<Country>();
        Country nation1 = new Country("Vietname","vn",80);
        Country nation2 = new Country("United State","us",100);
        Country nation3 = new Country("Russian","ru",120);
        dsQuocGia.add(nation1);
        dsQuocGia.add(nation2);
        dsQuocGia.add(nation3);
        //Tìm điều khiển
        ListView listViewQG = findViewById(R.id.listViewNATION);
        //Tạo adapter
        CountryAdapter adapter = new CountryAdapter(dsQuocGia,this);
        //Gắn adapter
        listViewQG.setAdapter(adapter);
    }
}