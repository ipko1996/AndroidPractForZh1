package hu.ipko.practforzh;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class FavoriteSeasonHoliday extends AppCompatActivity {

    private TextView tvPlace, tvCount, tvSum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_season_holiday);

        Intent intent = getIntent();
        String place = intent.getStringExtra("place");
        int price = intent.getIntExtra("price",0);
        String count = intent.getStringExtra("count");

        tvPlace = findViewById(R.id.tvPlace);
        tvCount = findViewById(R.id.tvCount);
        tvSum = findViewById(R.id.tvSum);

        tvPlace.setText(place);
        tvCount.setText(count + " Person");

        int sum = price * Integer.parseInt(count);
        tvSum.setText("$" + String.valueOf((sum)));
    }
}