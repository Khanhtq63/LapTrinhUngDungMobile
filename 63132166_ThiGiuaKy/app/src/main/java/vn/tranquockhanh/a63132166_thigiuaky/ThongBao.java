package vn.tranquockhanh.a63132166_thigiuaky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ThongBao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_bao);
        Intent intent = getIntent();
        String chonChu = intent.getStringExtra("chonChu");

        // Hiển thị thông báo
        TextView chuchon=findViewById(R.id.textChonChu);
        chuchon.setText("Chữ đã chọn: " + chonChu);
    }
}