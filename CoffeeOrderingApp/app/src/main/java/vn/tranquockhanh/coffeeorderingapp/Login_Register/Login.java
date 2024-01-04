package vn.tranquockhanh.coffeeorderingapp.Login_Register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import vn.tranquockhanh.coffeeorderingapp.AllCoffeeListFragment;
import vn.tranquockhanh.coffeeorderingapp.MainActivity;
import vn.tranquockhanh.coffeeorderingapp.R;

public class Login extends AppCompatActivity {

    private EditText emailTextView, passwordTextView;
    private Button Btn;
    private ProgressBar progressbar;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        emailTextView = findViewById(R.id.email);
        passwordTextView = findViewById(R.id.password);
        Btn = findViewById(R.id.login);
        progressbar = findViewById(R.id.progressBar);


        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                loginUserAccount();
            }
        });
    }
    private void loginUserAccount()
    {


        progressbar.setVisibility(View.VISIBLE);
        String email, password;
        email = emailTextView.getText().toString();
        password = passwordTextView.getText().toString();


        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Hãy điền email của bạn", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Hãy điền mật khẩu của bạn", Toast.LENGTH_LONG).show();
            return;
        }


        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(
                        new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(
                                    Task<AuthResult> task)
                            {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(),
                                                    "Đăng nhập thành công",
                                                    Toast.LENGTH_LONG)
                                            .show();
                                    progressbar.setVisibility(View.GONE);
//                                    Intent intent = new Intent(Login.this, AllCoffeeListFragment.class);
//                                    intent.putExtra("destination", R.id.allCoffeeListFragment);
//                                    startActivity(intent);
//                                    finish();
                                    if (Login.this.getParent() instanceof MainActivity) {
                                        MainActivity mainActivity = (MainActivity) Login.this.getParent();
                                        mainActivity.loadFragment(new AllCoffeeListFragment());

                                        finish();
                                    } else {
                                        // Nếu getParent() không phải là MainActivity, thì chuyển qua MainActivity
                                        Intent intent = new Intent(Login.this, MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }

                                else {
                                    Toast.makeText(getApplicationContext(), "Đăng nhập thất bại", Toast.LENGTH_LONG).show();
                                    progressbar.setVisibility(View.GONE);
                                }
                            }
                        });
    }

    public void RegisterPage(View v){
        Intent PageReg = new Intent(this, Register.class);
        startActivity(PageReg);
    }


}