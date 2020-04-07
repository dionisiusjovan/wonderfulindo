package com.wi.wonderfulindo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GridItemActivity extends AppCompatActivity {
    TextView judul;
    TextView desc;
    ImageView image;
    private static final String TAG = "GridItemActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: called.");
        setContentView(R.layout.activity_grid_item);

        judul = findViewById(R.id.gridText);
        desc = findViewById(R.id.gridDes);
        image = findViewById(R.id.gridImage);

        Intent intent = getIntent();
        judul.setText(intent.getStringExtra("name"));
        desc.setText(intent.getStringExtra("desc"));
        image.setImageResource(intent.getIntExtra("image", 0));

    }
}
