package hu.ipko.practforzh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CountActivity extends AppCompatActivity {

    private EditText result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);

        result = findViewById(R.id.edResuult);
    }

    public void goBack(View v){
        if(!result.getText().toString().equals("")){
            Intent i = new Intent(this, MainActivity.class);
            i.putExtra("res",result.getText().toString());
            setResult(RESULT_OK,i);
            finish();
        }else{
            Toast.makeText(this, "You must have an answer", Toast.LENGTH_SHORT).show();
        }
    }

    /**
    //save in case of flip screen
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("number",result.getText().toString());
    }
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String temp = savedInstanceState.getString("number");
        result.setText(temp);
    }
    */
}