package com.tranquockhanh.vidubolangnghe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText_Name;

    Button buttonSayhi, buttonXinChao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findControl();
        //cài đặt bộ lắng nghe + xử lý sự kiện cho mỗi nút
        buttonSayhi.setOnClickListener(boLangNgheXinChao);
        buttonXinChao.setOnClickListener(boLangNgheXinChao);
    }

    View.OnClickListener getBoLangNgheXinChao = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String strName = editText_Name.getText().toString();
            String strThongBao = "Xin chào, tôi là Captain chơi gay đbrr thích ntr thằng đàm";
            Toast.makeText(getBaseContext(),strThongBao,Toast.LENGTH_LONG).show();
        }
    };
    View.OnClickListener boLangNgheXinChao = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            String strName = editText_Name.getText().toString();
            String strThongBao = "Xin chào\n"+strName;
            Toast.makeText(getBaseContext(),strThongBao,Toast.LENGTH_LONG).show();
        }
    };

    void findControl(){
        editText_Name = findViewById(R.id.editName);
        buttonSayhi = findViewById(R.id.btnHello);
        buttonXinChao = findViewById(R.id.btnXinchao);
    }
}