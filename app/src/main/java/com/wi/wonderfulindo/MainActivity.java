package com.wi.wonderfulindo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    GridView gridView;

    //isi si tour
    String[] namaTour = {"Borobudur Temple", "Prambanan Temple", "Malioboro Street", "Ratu Boko Temple", "Parangtritis Beach"};
    String[] desTour ={"Located on the island of Java, the magnificent Borobudur temple is the world’s biggest Buddhist monument, an ancient site widely considered to be one of the world’s seven wonders. The temple sits majestically on a hilltop overlooking lush green fields and distant hills. Built in the 9th century during the reign of the Syailendra dynasty, the temple’s design in Gupta architecture reflects India's influence on the region, yet there are enough indigenous scenes and elements incorporated to make Borobudur uniquely Indonesian.It covers an enormous area, measuring 123 x 123 meters. The monument is a marvel of design, decorated with 2,672 relief panels and 504 Buddha statues. The architecture and stonework of this temple has no equal. And it was built without using any kind of cement or mortar! The structure is like a set of massive interlocking Lego blocks held together without any glue.",
    "Prambanan Temple was built in the ninth century. Soaring 47 meters into the sky with all of its alluring ornaments, the beauty of this Hindu temple is beyond compare. It is located 17 km to the west of the center of Jogja and can easily be visited by bus.'Legend says that a princess was cursed and turned into a statue standing inside Prambanan Temple.' He told me the complete story without being asked.",
    "One of the main tourist attractions in Yogyakarta is Jalan Malioboro as a name of the street that become a iconic of Yogyakarta city. Malioboro situated in the downtown which an icon and also the busiest business district in the area. The street is alive 24 hours a day and extends for 1 km from North to South with historical Dutch colonial-era architecture, new modern building architecture mixed in with the Chinese and contemporary commercial districts. \n" +
        "\n" +
        "Best way to explore the streets are by foot, just within walking distance from Stasiun Tugu (Tugu Railway Station) until southern end a junction, known as Nol Kilometer (Zero Kilometers). Another option is hiring a becak (pedicab) or the ubiquitous four-wheeled horse-drawn carts called “andong”.",
    "Ratu Boko is Located about 3 km south of Prambanan. Ratu Boko is situated atop of a hill ± 195.97 m above sea level. Ratu Boko is not a temple, but a remains of a palace. Ratu Baka is often called Kraton Ratu Boko. Legend said that Ratu Boko once a palace for Ratu Boko, the father of Lara Jonggrang. Ratu Boko is built during the 8th century AD by the Buddhist Syailendra Dynasty, but then the Hindu Mataram kings took over the place. This take over makes Kraton Ratu Boko is full of Hindu and Buddhist references.A stele was found in Ratu Boko dated 792 AD named Prasasti Abhayagiriwihara. This Stele signs that the Ratu Boko was built by Rakai Panangkaran. Prasasti Abhayagiriwihara is written with Pranagari font, a font used by many Buddhist Steles. In the Stele was mentioned Raja Tejapurnama Panangkarana, which is another name for Rakai Panangkaran",
    "A Romantic Sunset View at Parangtritis.Parangtritis Beach is only 27 km from the center of Jogja City and is famous for its romantic sunset views. Riding a horse cart along Parangtritis Beach in the afternoon will be a sweet memory.Parangtritis is located 27 km south of Yogyakarta and easily accessible by public transportation that operate up to 17:00pm as well as private vehicles. The afternoon before sunset is the best time to visit this most popular beach in Yogyakarta. But if you arrive sooner, it will not hurt for going up to Tebing Gembirawati (Gembirawati cliffs) behind this beach. From there, we can see the whole area of Parangtritis Beach, southern sea, up to the horizon."};
    int[] imgTour = {R.drawable.borobudur4, R.drawable.prambanan,R.drawable.malioboro, R.drawable.ratu, R.drawable.beach1};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);

        CustomAdapter customAdapter = new CustomAdapter();
        gridView.setAdapter(customAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), GridItemActivity.class);
                intent.putExtra("name", namaTour[i]);
                intent.putExtra("image", imgTour[i]);
                intent.putExtra("desc", desTour[i]);
                startActivity(intent);
            }
        });

    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return imgTour.length; // kalo button tour yg di pencet
            //return imgResto.length; //kalo button resto
            //return imgHotel.length; //kalo button hotel

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


            namePlace.setText(namaTour[i]); // buat yg button tour
            image.setImageResource(imgTour[i]);// tour
            return view1;
        }
    }
}
