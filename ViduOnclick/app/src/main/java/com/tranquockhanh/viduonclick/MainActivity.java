package com.tranquockhanh.viduonclick;

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
        editText_Name = findViewById(R.id.editName);
        buttonSayhi = findViewById(R.id.btnHello);
        buttonXinChao = findViewById(R.id.btnXinchao);

    }

    //Viết hàm xử lý sự kiện ở đây

    public void XuLyNoiHello(View v)
    {
        //Bước 1. Tìm điều khiển
        EditText editText_Name= findViewById(R.id.editName);
        //từ đây, ta dùng biến editText_Name để làm việc
        //Bước 2
        // Lấy chuỗi user nhập
        String strName = editText_Name.getText().toString();

        //Xuất theo yêu cầu
        String strThongBao = "Xin chào, tôi là Captain chơi gay đbrr thích ntr thằng đàm";
        Toast.makeText(this,strThongBao,Toast.LENGTH_LONG).show();

    }

    public void XuLyNoiXinchao(View v)
    {
        EditText editText_Name = findViewById(R.id.editName);
        String strName = editText_Name.getText().toString();
        String strThongBao = "Xin chào\n"+strName;
        Toast.makeText(this,strThongBao,Toast.LENGTH_LONG).show();

    }
}