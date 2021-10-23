package hu.ipko.practforzh;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class FavoriteSeasonProps extends AppCompatActivity {

    private EditText item;
    private ListView list;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> favoritesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_season_props);

        item = findViewById(R.id.etListItem);
        list = findViewById(R.id.lilstBestOfWinter);

        String[] favs = getResources().getStringArray(R.array.favorites);
        favoritesList = new ArrayList<String>(Arrays.asList(favs));
        adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                favoritesList
        );
        list.setAdapter(adapter);
    }

    public void remove(View v){
        if(!item.getText().toString().equals("")){
            for (int i = 0; i < favoritesList.size() - 1; i++) {
                if (favoritesList.get(i).equals(item.getText().toString())){
                    favoritesList.remove(i);
                }
            }
            item.setText("");
            adapter.notifyDataSetChanged();
        }else{
            Toast.makeText(this, "Empty String", Toast.LENGTH_SHORT).show();
        }
    }

    public void add(View v) {
        if (!item.getText().toString().equals("")) {
            favoritesList.add((item.getText().toString()));
            item.setText("");
            adapter.notifyDataSetChanged();
        }else{
            Toast.makeText(this, "Empty String", Toast.LENGTH_SHORT).show();
        }
    }
}