package vn.tranquockhanh.coffeeorderingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Check if the destination is provided
        int destinationId = getIntent().getIntExtra("destination", 0);
        if (destinationId != 0) {
            navigateToDestination(destinationId);
        }
    }
    private void navigateToDestination(int destinationId) {
        NavController navController = Navigation.findNavController(this, R.id.navgraph);
        navController.navigate(destinationId);
    }
}