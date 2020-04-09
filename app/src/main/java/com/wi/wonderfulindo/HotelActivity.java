package com.wi.wonderfulindo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HotelActivity extends AppCompatActivity {

    GridView gridView;

    //isi hotel
    String[] namaHotel ={"The Phoenix Hotel Yogyakarta","Lafayette Boutique Hotel", "Hyatt Regency Yogyakarta","Sheraton Mustika Yogyakarta Resort & Spa", "The 1O1 Yogyakarta Tugu Hotel"};
    String[] desHotel = {"Holiday like a Royal! \n If there is one place you can choose with your eyes closed, prepare to be treated like royalty at the Phoenix Hotel – M Gallery by Sofitel. Both locals and travellers would recommend this, and for a very good reason.A colonial landmark with stunning visuals, the hotel’s atmosphere alone would transport you to a princely European era where you can marvel at classic statues and take a stroll along the grand corridors. Classy interiors offer a swanky all-comforts-included stay with a touch of Indonesian royalty.Rates: From USD $57 (approximately IDR 757,530)\n" +
            "Address: Jalan Jenderal Sudirman No. 9, Yogyakarta City Center, Yogyakarta, Indonesia, 55233\n" +
            "Contact:  (+62)274/566617",
            "Live Your Parisian Dream! \nThis boutique hotel could easily be one of the top-class hotels you would duck into along an upscale street in Paris – but it’s right here in Jogja!The striking white building gives you an impression of a classy A-list hotel. Enter and you’ll be surprised by an elegant lobby with tall windows draped with graceful curtains, gothic chandeliers and sofas.\nRates: From USD $71 (approximately IDR 944,939)\n" +
                    "Address: l Ring Road Utara, No 409 – Desa Manggung, Catur Tunggal, 55281 Yogyakarta\n" +
                    "Contact:  +62 274 – 2924777",
            "In Manicured Gardens and Luxury. \n You stay can’t get grander than at the Hyatt Regency Yogyakarta Hotel. The sprawling property definitely has all-you-can-ask-for facilities, with a scenic beauty that will steal your heart. The 5-star hotel goes all out when it comes to luxury and comfort with its grand and spacious rooms. If you opt for a more luxurious room, you can even have your own private balcony where you can relish the fresh air and greenery. \n Rates: From USD $53 (approximately IDR 704,370)\n" +
                    "Address: Jalan Palagan Tentara Pelajar, Yogyakarta\n" +
                    "Contact:  +62 274 869123",
            "Watch Mount Merapi in Water Paradise.You will be taken aback by the palatial appearance of Sheraton Mustika Yogyakarta Resort and Spa, at prices that are so easy on your pocket.\n" +
                    "With fancy fountains, water cascades and gorgeous patios, this can be your very own palace grounds during your stay in Yogyakarta.\n As you unwind, you’ll get a peek into Jogja’s history as you enjoy the indoor and outdoor pools, which are designed to resemble the Taman Sari Water Castle ruins. \n Rate: From USD $68 (approximately IDR 903,720), Lagoon Access Rooms from $102 (approximately IDR 1,357,110)\n" +
                    "Address: JL Laksda Adisucipto KM 8.7 Yogyakarta 55282, Indonesia\n" +
                    "Contact:  (62)(274) 488588 ",
            "For the Trendy Fashionistas! \n The chic and trendy 1O1 Yogyakarta Tugu Hotel promises a very hip and happening accommodation on your Yogyakarta journey.\n" +
                    "If modish and flashy is your style, the hotel is perfect for your holiday. You’ll stay in rooms that are done in a very à la mode fashion, with chic wall murals and furnishings.  And where better to fill your Instagram feed with style-icon moments than at the contemporary in-house cafes? You’ll love to take a refreshing dip in the infinity swimming pool with modern design too  \nRates: From USD $60 (approximately IDR 798,300). Deluxe Pool Access rooms from USD $78 (approximately IDR 1,037,790)\n" +
                    "Address: Jalan Margoutomo No.103 (Mangkubumi), Yogyakarta 55232 – Indonesia\n" +
                    "Contact:  +62 274 2920101 "};
    int[] imgHotel={R.drawable.hotel1, R.drawable.hotel2,R.drawable.hotel3, R.drawable.hotel4, R.drawable.hotel5};
    String[] latlong = {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);

        HotelActivity.CustomAdapter customAdapter = new HotelActivity.CustomAdapter();
        gridView.setAdapter(customAdapter);



        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), GridItemActivity.class);
                intent.putExtra("name", namaHotel[i]);
                intent.putExtra("image", imgHotel[i]);
                intent.putExtra("desc", desHotel[i]);
                startActivity(intent);
            }
        });
    }


    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return imgHotel.length;
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


            namePlace.setText(namaHotel[i]); // buat yg button tour
            image.setImageResource(imgHotel[i]);// tour
            return view1;
        }
    }





}
