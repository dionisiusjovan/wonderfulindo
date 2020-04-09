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

        String[] desctempat = {"Located on the island of Java, the magnificent Borobudur temple is the world’s biggest Buddhist monument, an ancient site widely considered to be one of the world’s seven wonders. The temple sits majestically on a hilltop overlooking lush green fields and distant hills. Built in the 9th century during the reign of the Syailendra dynasty, the temple’s design in Gupta architecture reflects India's influence on the region, yet there are enough indigenous scenes and elements incorporated to make Borobudur uniquely Indonesian.It covers an enormous area, measuring 123 x 123 meters. The monument is a marvel of design, decorated with 2,672 relief panels and 504 Buddha statues. The architecture and stonework of this temple has no equal. And it was built without using any kind of cement or mortar! The structure is like a set of massive interlocking Lego blocks held together without any glue.",
                "Most of the travelers who visit Setumbu hill for watching sunrise did not realize there is unique building close to Setumbu hill. Yes, local people call it “Gereja Ayam”, means Chicken church in English.\n" +
                "A christian “Daniel Alamsjah” design the church as pigeon form at first in 1992. He put a crown on the top of the head. But, local people had different view. It more looks like chicken than dove. Then, it become famous as ‘chicken church’.\n" +
                "Today, the church no longer use as a church. But, as a “House of Praying” of many religions. Also as an alternative for watching sunrise.\n It's located About 45 minutes – 1 hour to north from downtown Yogyakarta or about 8-10 minutes or 2.5 km from Borobudur temple. This place are close to MAINSTREAM site in YOGYAKARTA Such as BOROBUDUR, SETUMBU HILL & RAFTING ELO RIVER.", "Tempo Gelato is a gelato shop originated from Yogyakarta and since the growth of the business has been terrific, they're now having two outlets located in Prawirotaman (first outlet) and followed by the newer Kaliurang outlet. There were 4 available serving sizes: small (IDR 20k), medium (IDR 40k), big (IDR 65k) and x-big (IDR 115k) and additional IDR 5k if you want to have the ice cream served with cone.There are approximately 12 different gelato & sorbet flavors to choose and for ice creams.", "Imagine the century-old Mbah Lindu hunched over her boiling pots, cooking her legendary Gudeg over charcoal, every day for more than 80 years. After which, she would walk for 4 kilometres every morning from her home to this same spot to sell to her local customers and even tourists all over the world who has heard of her.\n" +
                "Now, you can spot her daughter taking over the reins at her stall, though it is said that Mbah Lindu still cooks the Gudeg herself! The story of Mbah Lindu is an emotional one, but it is amazing to see that the family business is still going strong and making hungry stomachs happy!\\nTry their Gudeg for breakfast as it comes with a choice of rice or porridge! The sauce is creamy and spicy, the chicken is soft and falls apart easily as it soaks up the broth while the egg is boiled to perfection!\nOpening hours: Mon-Sun 5am-11am\n" +
                "\nPrice Range: Rp.15,000-20,000 per portion." };

        String[] latlong = {"-7.607735,110.204441", "-7.605704,110.1782953", "-7.819291, 110.372407", "-7.791624, 110.364030"};

        //inisialisasi arraylist
        mainModels = new ArrayList<>();
        for (int i=0; i<tempat.length; i++){
            MainModel model = new MainModel(tempat[i], namatempat[i], desctempat[i], latlong[i]);
            mainModels.add(model);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                HomeActivity.this,LinearLayoutManager.HORIZONTAL,false
        );
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //inisialisasi MainAdapter
        mainAdapter = new MainAdapter(HomeActivity.this,mainModels, this);
        //set mainadapter ke recycler view
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

        btnHotel = findViewById(R.id.bttnHotel);
        btnHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, HotelActivity.class));
            }
        });

        btnTour = findViewById(R.id.bttnTour);
        btnTour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, TourActivity.class));
            }
        });
    }

    @Override
    public void onPicClick(int position) {
        Log.d(TAG, "onPicClick: clicked");
        Intent intent = new Intent(this, GridItemActivity.class);
        intent.putExtra("name", mainModels.get(position).getNamatempat());
        intent.putExtra("image", mainModels.get(position).getTempat());
        intent.putExtra("desc", mainModels.get(position).getDesctempat());
        intent.putExtra("latlong", mainModels.get(position).getKoordinat());
        startActivity(intent);
    }

    }

