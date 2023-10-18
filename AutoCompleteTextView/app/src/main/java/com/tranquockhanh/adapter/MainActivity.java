package com.tranquockhanh.adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> dsQuocGia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //b0
        findControl();
        //b1 Chuẩn bị nguồn dữ liệu, cất vào biến
        dsQuocGia = new ArrayList<String>();
        dsQuocGia.add("VietNam");
        dsQuocGia.add("England");
        dsQuocGia.add("American");
        dsQuocGia.add("China");
        dsQuocGia.add("Paris");
        //b2 Tạo adapter
        ArrayAdapter<String> adapterQG;
        adapterQG = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_dropdown_item_1line,
        dsQuocGia
        );
        autoQUOCGIA.setAdapter(adapterQG);
    }

    public void findControl()
    {
        autoQUOCGIA = findViewById(R.id.autoCompletetextQUOCGIA);
    }
    AutoCompleteTextView autoQUOCGIA;
}