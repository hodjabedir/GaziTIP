package com.example.gazitip;

public class Soru {
    private String soruMetni;
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private int id;

    public Soru(String Metin) {
        String nokta = new String(".");
        String sıkA= new String("a)");
        String sıkB= new String("b)");
        String sıkC= new String("c)");
        String sıkD= new String("d)");
        String sıkE= new String("e)");
        int noktaNum=Metin.indexOf(nokta);
        int indexA = Metin.indexOf(sıkA);
        int indexB = Metin.indexOf(sıkB);
        int indexC = Metin.indexOf(sıkC);
        int indexD = Metin.indexOf(sıkD);
        int indexE = Metin.indexOf(sıkE);
        this.soruMetni =  Metin.substring(0,indexA);
        this.a = Metin.substring(indexA,indexB);
        this.b = Metin.substring(indexB,indexC);
        this.c = Metin.substring(indexC,indexD);
        this.d = Metin.substring(indexD,indexE);
        this.e = Metin.substring(indexE,Metin.length());
        this.id =Integer.parseInt( Metin.substring(0,noktaNum));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Soru() {
        this.soruMetni = " Metin.substring(0,indexA)";
        this.a = "Metin(indexA,indexB)";
        this.b = "Metin.substring(indexB,indexC)";
        this.c = "Metin.substring(indexC,indexD)";
        this.d =" Metin.substring(indexD,indexE)";
        this.e =" Metin.substring(indexE,Metin.length())";
    }

    public String getSoruMetni() {
        return soruMetni;
    }

    public void setSoruMetni(String soruMetni) {
        this.soruMetni = soruMetni;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }
}
