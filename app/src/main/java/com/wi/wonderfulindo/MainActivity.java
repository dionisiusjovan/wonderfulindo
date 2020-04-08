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
            "Authentic to Java, wedang ronde is made of sweet glutinous rice balls soaked in hot ginger flavoured water, syrup, sprinkled with a few peanuts, and filled with peanut in the rice balls. Opening hours: Mon-Sat 7pm-12am\n" +
            "Price: Rp.5,000 ",
            "Imagine the century-old Mbah Lindu hunched over her boiling pots, cooking her legendary Gudeg over charcoal, every day for more than 80 years. After which, she would walk for 4 kilometres every morning from her home to this same spot to sell to her local customers and even tourists all over the world who has heard of her.\n" +
                    "Now, you can spot her daughter taking over the reins at her stall, though it is said that Mbah Lindu still cooks the Gudeg herself! The story of Mbah Lindu is an emotional one, but it is amazing to see that the family business is still going strong and making hungry stomachs happy!\n Try their Gudeg for breakfast as it comes with a choice of rice or porridge! The sauce is creamy and spicy, the chicken is soft and falls apart easily as it soaks up the broth while the egg is boiled to perfection!\nOpening hours: Mon-Sun 5am-11am\n" +
                    "Price Range: Rp.15,000-20,000 per portion ",
            "Tofu in ginger soup that is sold out in 1.5 hours. Another drink that resembles a dessert – it is served hot and made of soft creamy tofu in ginger water and syrup – very similar to Wedang Ronde, but there are no glutinous rice balls. Sweet, but the mix of texture is enjoyed by everyone!.The drink is usually enjoyed as a body warmer during the rainy season and is enjoyed early morning or at night; get there as early as possible as the stall is only open till sold out (usually within 1.5 hours!). \n  Opening hours: Mon-Sun 6.30am – until sold out\n" +
                    "Price: Rp.6000. ",
            "Ingkung Kuali is famous among locals for its free range chicken, and you can actually taste the freshness of the poultry! This surprising local eatery is located in Pajangan – commonly known as the culinary centre of Yogyakarta, so you know you can have high expectations on the taste!\n Choose between the original boiled chicken or marinated or even fried chicken – although it looks plain and banal when served, the delicacy will surprise you in taste and flavours as it has been mixed, marinated and cooked for over 4 hours, thus the chicken would have soaked up all spices."};
    int[] imgResto = {R.drawable.mediteranea, R.drawable.gelato2, R.drawable.wedang, R.drawable.gudeg2,R.drawable.tahu, R.drawable.ingkuang};

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
    int[] imgHotel={R.drawable.hotel, R.drawable.hotel2,R.drawable.hotel3, R.drawable.hotel4, R.drawable.hotel5};

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

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), GridItemActivity.class);
                intent.putExtra("name", namaResto[i]);
                intent.putExtra("image", imgResto[i]);
                intent.putExtra("desc", desResto[i]);
                startActivity(intent);
            }
        });

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
