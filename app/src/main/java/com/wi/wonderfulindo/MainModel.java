package com.wi.wonderfulindo;

public class MainModel {
    Integer tempat;
    String namatempat;
    String desctempat;
    String[] latlong;

    public MainModel(Integer tempat, String namatempat, String desctempat){
        this.namatempat = namatempat;
        this.tempat = tempat;
        this.desctempat = desctempat;
    }

    public Integer getTempat(){
        return tempat;
    }

    public String getNamatempat(){
        return namatempat;
    }

    public String getDesctempat() {
        return desctempat;
    }
}
