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

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
   //Button btnSignOut;
    Button btnResto, btnHotel, btnTour;
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
        mainAdapter = new MainAdapter(HomeActivity.this,mainModels);
        //set mainpter ke recycler view
        recyclerView.setAdapter(mainAdapter);
    }

    /*Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnResto = findViewById(R.id.bttnFood);
        btnResto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        })*/


        /*btnSignOut = findViewById(R.id.btnLogout);
        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent);
            }*/
        //});
    }

