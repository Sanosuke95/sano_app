package fr.sanosuke.sano_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

import fr.sanosuke.sano_app.activity.MoviesActivity;
import fr.sanosuke.sano_app.activity.MusicActivity;
import fr.sanosuke.sano_app.activity.ScanActivity;
import fr.sanosuke.sano_app.activity.SettingsActivity;
import fr.sanosuke.sano_app.adapter.GridAdapter;
import fr.sanosuke.sano_app.model.GridModel;

public class MainActivity extends AppCompatActivity {

    private static final String GRID_LOG = "GridLog";
    GridView gridView;
    String[] menuView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        menuView = res.getStringArray(R.array.menu);

        gridView = findViewById(R.id.home_gridView);
        ArrayList<GridModel> gridModelArrayList = new ArrayList<>();

        for (String i : menuView) {
            switch (i) {
                case "movies":
                    gridModelArrayList.add(new GridModel(i, R.drawable.movie));
                    break;
                case "music":
                    gridModelArrayList.add(new GridModel(i, R.drawable.music));
                    break;
                case "scan":
                    gridModelArrayList.add(new GridModel(i, R.drawable.image));
                    break;
                case "settings":
                    gridModelArrayList.add(new GridModel(i, R.drawable.settings));
                    break;
                default:
                    Log.i(GRID_LOG, "NOt element selected in gridView");
            }
        }

        GridAdapter gridAdapter = new GridAdapter(this, gridModelArrayList);
        gridView.setAdapter(gridAdapter);

        gridView.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(MainActivity.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
            String item = ((TextView) view.findViewById(R.id.card_title)).getText().toString();
            switch (item) {
                case "movies":
                    changeActivity(MoviesActivity.class);
                    break;
                case "music":
                    changeActivity(MusicActivity.class);
                    break;
                case "scan":
                    changeActivity(ScanActivity.class);
                    break;
                case "settings":
                    changeActivity(SettingsActivity.class);
                    break;
                default:
                    Log.i(GRID_LOG, "not icons clicked");
            }
        });
    }

    public <T> void changeActivity(Class<T> c) {
        Intent intent = new Intent(this, c);
        startActivities(new Intent[]{intent});
    }
}