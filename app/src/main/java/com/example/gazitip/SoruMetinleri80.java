package com.example.gazitip;

public class SoruMetinleri80 {
    private String test;
    private int donem;
    private int komite;
    private int yil;

    public SoruMetinleri80() {
    }

    public SoruMetinleri80(String test, int donem, int komite, int yil) {
        this.test = test;
        this.donem = donem;
        this.komite = komite;
        this.yil = yil;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public int getDonem() {
        return donem;
    }

    public void setDonem(int donem) {
        this.donem = donem;
    }

    public int getKomite() {
        return komite;
    }

    public void setKomite(int komite) {
        this.komite = komite;
    }

    public int getYil() {
        return yil;
    }

    public void setYil(int yil) {
        this.yil = yil;
    }
}
