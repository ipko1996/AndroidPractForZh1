package hu.ipko.practforzh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class FavoriteSeasonAndImage extends AppCompatActivity {

    private final int FIRST = 59;
    private final int SECOND  = 49;
    private final int THIRD = 69;

    private int chosenNumber;

    private ImageView ivFavoriteSeason;
    private Switch switchWebsite;
    private EditText etPeopleNumber;
    private RadioGroup rgPlaces;
    private RadioButton rbFirst, rbSecond, rbThird;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_season_and_image);

        ivFavoriteSeason = findViewById(R.id.ivFavoriteSeason);
        switchWebsite = findViewById(R.id.switchWebsite);
        rgPlaces = findViewById(R.id.rgPlaces);
        rbFirst = findViewById(R.id.radioButton1);
        rbSecond = findViewById(R.id.radioButton2);
        rbThird = findViewById(R.id.radioButton3);
        etPeopleNumber = findViewById(R.id.etPeopleNumber);

        setAnimation();
        setCheckAction();
        setRadio();
        setButton();
    }




    public void buy(View v){
        //nothing selected OR no info from people number
        if(rgPlaces.getCheckedRadioButtonId() == -1 || etPeopleNumber.getText().toString().isEmpty()){
            Toast.makeText(this, "Please, provide the necessary information!", Toast.LENGTH_SHORT).show();
        }else{
            Intent i = new Intent(this, FavoriteSeasonHoliday.class);

            String place = "";
            int checkedButton = rgPlaces.getCheckedRadioButtonId();
            RadioButton radioButton = (RadioButton) findViewById(checkedButton);
            place = radioButton.getText().toString();

            i.putExtra("place",place);
            i.putExtra("price",chosenNumber);
            i.putExtra("count",etPeopleNumber.getText().toString());
            startActivity(i);
        }
    }

    private void setButton() {
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy(view);
            }
        });
    }

    private void setRadio() {
        rgPlaces.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int checkedButton = radioGroup.getCheckedRadioButtonId();
                if(checkedButton == rbFirst.getId()) chosenNumber = FIRST;
                if(checkedButton == rbSecond.getId()) chosenNumber = SECOND;
                if(checkedButton == rbThird.getId()) chosenNumber = THIRD;
            }
        });
    }

    private void setCheckAction() {
        switchWebsite.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Intent webIntent = new Intent(Intent.ACTION_VIEW);
                webIntent.setData(Uri.parse("https://www.weather.gov/safety/winter"));
                startActivity(webIntent);

                compoundButton.setChecked(false);
            }
        });
    }

    private void setAnimation() {
        Animation flipAnimation = AnimationUtils.
                loadAnimation(this,R.anim.flip);
        ivFavoriteSeason.startAnimation(flipAnimation);
    }
}