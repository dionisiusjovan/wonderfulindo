package com.wi.wonderfulindo;

public class MainModel {
    Integer tempat;
    String namatempat;
    String desctempat;
    String koordinat;

    public MainModel(Integer tempat, String namatempat, String desctempat, String koord){
        this.namatempat = namatempat;
        this.tempat = tempat;
        this.desctempat = desctempat;
        this.koordinat = koord;
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

    public String getKoordinat() {
        return koordinat;
    }
}
