package com.wi.wonderfulindo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    Button back,profile;

    //isi resto
    String[] namaResto ={"Mediteranea Restraurant by Kamil", "Tempo Gelato", "Wedang Ronde Mbah Payem","Gudeg Mbah Lindu Sosrowijayan","Wedang Tahu Bu Sukardi","Ingkung Kuali"};
    String[] desResto = {"Mediterranea is more than just a restaurant. This is place where you can enjoy your quality time with family, friend and colluague, accompanying with good and healthy food, also tasty beverage for fine dining experience. We serves Authentic French Traditional Food. Open Every Day 08.30 - 23.00 with affordable price with high quality food. \n For more information, reservation, and delivery services, kindly  contact us through :\n" +
            "\n" +
            "Restaurant phone : 0274 371052 ( 08.00 – 23.00 )\n" +
            "\n" +
            "Office phone : (0274) 422 1213 ( 08.00 - 17.00 )\n" +
            "\n" +
            "WhatsApp : +62817 464 305 ( 08.00 – 17.00 )\n" +
            "\n" +
            "Email : mediterraneabykamil@gmail.com ",
            "Tempo Gelato is a gelato shop originated from Yogyakarta and since the growth of the business has been terrific, they're now having two outlets located in Prawirotaman (first outlet) and followed by the newer Kaliurang outlet. There were 4 available serving sizes: small (IDR 20k), medium (IDR 40k), big (IDR 65k) and x-big (IDR 115k) and additional IDR 5k if you want to have the ice cream served with cone.There are approximately 12 different gelato & sorbet flavors to choose and for ice creams.",
            "A former president’s favourite drink spot in Jogja.Although this will look like a dessert to you, know that local Javanese enjoy it as a comforting roadside drink – colourful but also very sweet; be ready to try something exotic!\n" +
            "Authentic to Java, wedang ronde is made of sweet glutinous rice balls soaked in hot ginger flavoured water, syrup, sprinkled with a few peanuts, and filled with peanut in the rice balls.\n\nOpening hours: Mon-Sat 7pm-12am\n" +
            "Price: Rp.5,000 ",
            "Imagine the century-old Mbah Lindu hunched over her boiling pots, cooking her legendary Gudeg over charcoal, every day for more than 80 years. After which, she would walk for 4 kilometres every morning from her home to this same spot to sell to her local customers and even tourists all over the world who has heard of her.\n" +
                    "Now, you can spot her daughter taking over the reins at her stall, though it is said that Mbah Lindu still cooks the Gudeg herself! The story of Mbah Lindu is an emotional one, but it is amazing to see that the family business is still going strong and making hungry stomachs happy!\nTry their Gudeg for breakfast as it comes with a choice of rice or porridge! The sauce is creamy and spicy, the chicken is soft and falls apart easily as it soaks up the broth while the egg is boiled to perfection!\n\nOpening hours: Mon-Sun 5am-11am\n" +
                    "\nPrice Range: Rp.15,000-20,000 per portion ",
            "Tofu in ginger soup that is sold out in 1.5 hours. Another drink that resembles a dessert – it is served hot and made of soft creamy tofu in ginger water and syrup – very similar to Wedang Ronde, but there are no glutinous rice balls. Sweet, but the mix of texture is enjoyed by everyone!.The drink is usually enjoyed as a body warmer during the rainy season and is enjoyed early morning or at night; get there as early as possible as the stall is only open till sold out (usually within 1.5 hours!). \n\nOpening hours: Mon-Sun 6.30am – until sold out\n" +
                    "Price: Rp.6000. ",
            "Ingkung Kuali is famous among locals for its free range chicken, and you can actually taste the freshness of the poultry! This surprising local eatery is located in Pajangan – commonly known as the culinary centre of Yogyakarta, so you know you can have high expectations on the taste!\n Choose between the original boiled chicken or marinated or even fried chicken – although it looks plain and banal when served, the delicacy will surprise you in taste and flavours as it has been mixed, marinated and cooked for over 4 hours, thus the chicken would have soaked up all spices."};
    int[] imgResto = {R.drawable.mediteranea, R.drawable.gelato2, R.drawable.wedang, R.drawable.gudeg2,R.drawable.tahu, R.drawable.ingkuang};
    String[] latlong = {"-7.818600, 110.364510", "-7.819291, 110.372407", "-7.804399, 110.360965", "-7.791624, 110.364030", "-7.781572, 110.362422", "-7.886704, 110.301637"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);

        final ArrayList<MainModel> restaurantList = new ArrayList<>();
        for (int i = 0; i < imgResto.length; i++){
            MainModel mainModel = new MainModel(imgResto[i], namaResto[i], desResto[i], latlong[i]);
            restaurantList.add(mainModel);
        }

        CustomAdapter customAdapter = new CustomAdapter();
        gridView.setAdapter(customAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), GridItemActivity.class);
                intent.putExtra("name", restaurantList.get(i).getNamatempat());
                intent.putExtra("image", restaurantList.get(i).getTempat());
                intent.putExtra("desc", restaurantList.get(i).getDesctempat());
                intent.putExtra("latlong", restaurantList.get(i).getKoordinat());
                startActivity(intent);
            }
        });

        back = findViewById(R.id.bttnBackAct);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        profile = findViewById(R.id.bttnProfileAct);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
            }
        });
    }


    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return imgResto.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup parent) {
            View view1 = getLayoutInflater().inflate(R.layout.row_data2, null);

            TextView namePlace = view1.findViewById(R.id.txtPlace); //txtPlace dari row data2 xml
            ImageView image = view1.findViewById(R.id.imgPlace);// imgPlace dari rowdata2 xml

            namePlace.setText(namaResto[i]); // buat yg button tour
            image.setImageResource(imgResto[i]);// tour
            return view1;
        }
    }
}
