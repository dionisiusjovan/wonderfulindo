package com.wi.wonderfulindo;

public class MainModel {
    Integer tempat;
    String namatempat;

    public MainModel(Integer tempat, String namatempat){
        this.namatempat = namatempat;
        this.tempat = tempat;
    }

    public Integer getTempat(){
        return tempat;
    }

    public String getNamatempat(){
        return namatempat;
    }
}
