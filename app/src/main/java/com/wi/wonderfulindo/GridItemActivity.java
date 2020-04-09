package com.wi.wonderfulindo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GridItemActivity extends AppCompatActivity {
    TextView judul;
    TextView desc;
    ImageView image;
    Button back, maps;
    String latlong = "", nama="";
    private static final String TAG = "GridItemActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: called.");
        setContentView(R.layout.activity_grid_item);

        back = findViewById(R.id.bttnBack);
        maps = findViewById(R.id.bttnMap);

        judul = findViewById(R.id.gridText);
        desc = findViewById(R.id.gridDes);
        image = findViewById(R.id.gridImage);

        Intent intent = getIntent();
        nama = intent.getStringExtra("name");
        judul.setText(nama);
        desc.setText(intent.getStringExtra("desc"));
        image.setImageResource(intent.getIntExtra("image", 0));
        latlong = intent.getStringExtra("latlong");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(GridItemActivity.this, MapActivity.class);
                intent1.putExtra("latlong", latlong);
                intent1.putExtra("placeName", nama);
                startActivity(intent1);
            }
        });

    }
}
