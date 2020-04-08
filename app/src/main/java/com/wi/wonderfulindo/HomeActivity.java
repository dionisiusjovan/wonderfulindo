package com.wi.wonderfulindo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements MainAdapter.OnPicClickListener {
   //Button btnSignOut;
   private static final String TAG = "HomeActivity";
    Button btnResto, btnHotel, btnTour, btnProfile;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    RecyclerView recyclerView; //inisialisasi slide bucket list
    ArrayList<MainModel> mainModels;
    MainAdapter mainAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //assign variable
        recyclerView = findViewById(R.id.slideBL);

        //integer array
        Integer[] tempat ={R.drawable.borobudur, R.drawable.gerejaayam,
                R.drawable.gelato1, R.drawable.gudeg2};

        //String array
        String[] namatempat = {"Borobudur Temple", "Gereja Ayam", "Tempo Gelato", "Gudeg Mbah Lindu" };

        //inisialisasi arraylist
        mainModels = new ArrayList<>();
        for (int i=0; i<tempat.length; i++){
            MainModel model = new MainModel(tempat[i], namatempat[i]);
            mainModels.add(model);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                HomeActivity.this,LinearLayoutManager.HORIZONTAL,false
        );
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //inisialisasi MainAdapter
        mainAdapter = new MainAdapter(HomeActivity.this,mainModels, this);
        //set mainpter ke recycler view
        recyclerView.setAdapter(mainAdapter);

        btnProfile = findViewById(R.id.bttnProfile);
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ProfileActivity.class));
            }
        });

        btnResto = findViewById(R.id.bttnFood);
        btnResto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onPicClick(int position) {
        Log.d(TAG, "onPicClick: clicked");
        Intent intent = new Intent(this, GridItemActivity.class);
        intent.putExtra("name", mainModels.get(position).getNamatempat());
        intent.putExtra("image", mainModels.get(position).getTempat());
        startActivity(intent);
    }

    /*Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        */
    }

