package com.tranquockhanh.tinhbmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText heightEditText;
    private EditText weightEditText;
    private TextView resultTextView;
    private TextView statusTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heightEditText = findViewById(R.id.btnH);
        weightEditText = findViewById(R.id.btnW);
        resultTextView = findViewById(R.id.result);
        statusTextView = findViewById(R.id.status);

        Button calculateButton = findViewById(R.id.button);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String heightStr = heightEditText.getText().toString();
        String weightStr = weightEditText.getText().toString();

        if (!heightStr.isEmpty() && !weightStr.isEmpty()) {
            float height = Float.parseFloat(heightStr);
            float weight = Float.parseFloat(weightStr);

            float bmi = calculateBMIValue(height, weight);
            String status = interpretBMI(bmi);

            resultTextView.setText(getString(R.string.bmi_result, bmi));
            statusTextView.setText(getString(R.string.bmi_status, status));
        } else {
            resultTextView.setText("");
            statusTextView.setText(getString(R.string.enter_height_weight));
        }
    }

    private float calculateBMIValue(float height, float weight) {
        return (weight / (height * height)) * 10000; //
    }

    private String interpretBMI(float bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 24.9) {
            return "Normal Weight";
        } else if (bmi < 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}