package com.tranquockhanh.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView tvUser = (TextView) findViewById(R.id.tvUserName);
        String userName = getIntent().getStringExtra("userName");
        tvUser.setText(userName);
    }


}

