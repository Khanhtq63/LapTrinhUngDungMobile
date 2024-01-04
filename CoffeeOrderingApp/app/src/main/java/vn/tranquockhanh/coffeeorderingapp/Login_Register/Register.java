package vn.tranquockhanh.coffeeorderingapp.Login_Register;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

import android.widget.Toast;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;


import vn.tranquockhanh.coffeeorderingapp.MainActivity;
import vn.tranquockhanh.coffeeorderingapp.databinding.ActivityRegisterBinding;

import vn.tranquockhanh.coffeeorderingapp.R;

public class Register extends AppCompatActivity {

    private EditText emailTextView, passwordTextView;
    private Button Btn;
    private ProgressBar progressbar;

    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // Sử dụng firebase authentication
        mAuth = FirebaseAuth.getInstance();
        emailTextView = findViewById(R.id.email);
        passwordTextView = findViewById(R.id.passwd);
        Btn = findViewById(R.id.btnregister);
        progressbar = findViewById(R.id.progressbar);

        // Tạo OnClickListener cho register
        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                registerNewUser();
            }
        });

    }

    private void registerNewUser()
    {

        progressbar.setVisibility(View.VISIBLE);
        String email, password;
        email = emailTextView.getText().toString();
        password = passwordTextView.getText().toString();

        // Hàm điền thông tin thông báo nếu như chưa điền vào
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Hãy điền email của bạn", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Hãy điền mật khẩu của bạn", Toast.LENGTH_LONG).show();
            return;
        }

        // Tạo tài khoản mới
        mAuth
                .createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(Task<AuthResult> task)
                    {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Đăng ký thành công", Toast.LENGTH_LONG).show();

                            // Ẩn thanh progress
                            progressbar.setVisibility(View.GONE);

                            // nếu đã đăng ký thành công tự động chuyển qua login activity
                            Intent intent = new Intent(Register.this, MainActivity.class);
                            startActivity(intent);
                        }
                        else {

                            // Đăng kí thất bại
                            Toast.makeText(getApplicationContext(), "Đăng ký thất bại" + " Hãy thử lại", Toast.LENGTH_LONG).show();
                            // Ẩn thanh progress
                            progressbar.setVisibility(View.GONE);
                        }
                    }
                });
    }
}
