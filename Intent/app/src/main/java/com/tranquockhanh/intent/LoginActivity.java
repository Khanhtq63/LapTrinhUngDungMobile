package com.tranquockhanh.intent;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void ChuyenSangHome(View v)
    {
        EditText edtUser = (EditText) findViewById(R.id.edtUserName);
        EditText edtPass = (EditText) findViewById(R.id.edtPass);
        EditText edtEmail = (EditText) findViewById(R.id.edtMail);

        String userName = edtUser.getText().toString();
        String userPass = edtPass.getText().toString();
        String userMail = edtEmail.getText().toString();
        if(kiemTra(userName,userPass,userMail)){
            Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
            intent.putExtra("userName",userName);
            startActivity(intent);
        } else {
            Toast.makeText(LoginActivity.this,"Thông tin không chính xác",Toast.LENGTH_SHORT).show();
        }
    }
    private boolean kiemTra(String userName,String password, String email){
        return "tranquockhanh".equals(userName) && "98765432".equals(password) && "khanh.tq.63cntt@ntu.edu.vn".equals(email);
    }
}