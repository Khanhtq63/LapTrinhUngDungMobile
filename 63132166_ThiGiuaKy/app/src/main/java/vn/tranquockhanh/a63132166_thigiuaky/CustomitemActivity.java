package vn.tranquockhanh.a63132166_thigiuaky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomitemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customitem);
        Intent intent = getIntent();
        String countryName = intent.getStringExtra("countryName");
        String population = intent.getStringExtra("population");
        String countryFlag = intent.getStringExtra("countryFlag");

        // Hiển thị thông tin chi tiết
        TextView nameTextView = findViewById(R.id.countryNameTextView);
        TextView populationTextView = findViewById(R.id.populationTextView);
        ImageView flagImageView = findViewById(R.id.flagImageView);

        nameTextView.setText("Country: " + countryName);
        populationTextView.setText("Population: " + population);
        int resImageID = getResources().getIdentifier(countryFlag, "mipmap", getPackageName());
        flagImageView.setImageResource(resImageID);
    }
}