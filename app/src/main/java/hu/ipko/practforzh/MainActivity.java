package hu.ipko.practforzh;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ActivityResultLauncher<Intent> countActivity = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Intent i = result.getData();
                    if (result.getResultCode()==RESULT_OK){
                        String res = i.getStringExtra("res");
                        if(res.equals("2")) Toast.makeText(MainActivity.this, "Number from other screen: "+ res, Toast.LENGTH_LONG).show();
                        if(!res.equals("2")) Toast.makeText(MainActivity.this, "Number from other screen: "+ res + " ???", Toast.LENGTH_LONG).show();
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toFavSeason(View v){
        Intent intent = new Intent(this, FavoriteSeasonAndImage.class);
        startActivity(intent);
    }

    public void toBestOf(View v){
        Intent intent = new Intent(this, FavoriteSeasonProps.class);
        startActivity(intent);
    }

    public void countScreen(View v){
        Intent intent = new Intent(this, CountActivity.class);
        countActivity.launch(intent);
    }

    public void popUp(View v){
        AlertDialog.Builder aBuilder = new AlertDialog.Builder(this);
        String[] quotes= {
                "Keep calm and carry on. — Winston Churchill",
                "The greatest pleasure of life is love. — Euripides",
                "Every moment is a fresh beginning. —T.S. Eliot",
                "Don’t cry because it’s over, smile because it happened. —Dr. Seuss ",
                "There are no mistakes, only opportunities. —Tina Fey"};
        int random = new Random().nextInt(quotes.length);
        aBuilder.setMessage(quotes[random]);
        aBuilder.setNeutralButton("Thanks", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Have a nice day", Toast.LENGTH_SHORT).show();

            }
        });
        aBuilder.show();
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("change","onStart function");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("change","onResume function");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("change","onPause function");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("change","onRestart function");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("change","onStop function");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("change","onDestroy function");
    }
}