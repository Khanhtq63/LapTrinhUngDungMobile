package vn.tranquockhanh.a63132166_thigiuaky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        }

        public void BaiTap1(View v)
        {
            Intent Baitap = new Intent(this,activityBai1.class);
            startActivity(Baitap);
        }

    public void BaiTap2(View v)
    {
        Intent Baitap = new Intent(this,activityBai2.class);
        startActivity(Baitap);
    }

    public void BaiTap3(View v)
    {
        Intent Baitap = new Intent(this,activityBai3.class);
        startActivity(Baitap);
    }

    public void BaiTap4(View v)
    {
        Intent Baitap = new Intent(this,activityBai4.class);
        startActivity(Baitap);
    }

}