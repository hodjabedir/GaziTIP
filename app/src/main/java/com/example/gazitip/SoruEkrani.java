package com.example.gazitip;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class SoruEkrani extends AppCompatActivity implements View.OnClickListener {

    TextView soruMetni,secenekA,secenekB,secenekC,secenekD,secenekE;
    ArrayList<Soru> sorular;
    char cevapAnahtariyen[];
    int soruSayisi;
    private AdView mAdView;
    String cevapAnahtari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soru_ekrani);
        Intent soruEkrani = getIntent();
        String gelen = soruEkrani.getStringExtra("sinav");
        Toast.makeText(this,gelen,Toast.LENGTH_SHORT).show();

         mAdView = findViewById(R.id.adView_soru_ekrani);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        soruMetni=findViewById(R.id.soru_metni);
        secenekA = findViewById(R.id.secenekA);
        secenekB = findViewById(R.id.secenekB);
        secenekC = findViewById(R.id.secenekC);
        secenekD = findViewById(R.id.secenekD);
        secenekE = findViewById(R.id.secenekE);


        sorular = new ArrayList<>();
        cevapAnahtariyen = new char[80];
        soruSayisi = 80;

        String cikmissorular = "";
        cikmissorular = dosyaoku(gelen);
        cevapAnahtari = cikmissorular.substring(0,soruSayisi-1);
        cevapAnahtariyen = cikmissorular.substring(0,soruSayisi-1).toCharArray();


        sorularıBul(cikmissorular,soruSayisi);

        soruMetni.setText(sorular.get(0).getSoruMetni());
        secenekA.setText(sorular.get(0).getA());
        secenekB.setText(sorular.get(0).getB());
        secenekC.setText(sorular.get(0).getC());
        secenekD.setText(sorular.get(0).getD());
        secenekE.setText(sorular.get(0).getE());

        secenekA.setOnClickListener(this);
        secenekB.setOnClickListener(this);
        secenekC.setOnClickListener(this);
        secenekD.setOnClickListener(this);
        secenekE.setOnClickListener(this);



    }
    public void showAlert(int dogru){
        AlertDialog.Builder alert = new AlertDialog.Builder(getApplicationContext());
        alert.setMessage(
                "Dogru SAyısı: "+dogru

        );

        alert.show();


    }
    public void showpopup(int dogru){
        showAlert(dogru);
    }
    public void showpopup1(int dogru)
    {
        LayoutInflater layout = LayoutInflater.from(getApplicationContext());
        View tasarim = layout.inflate(R.layout.pop_up,null);

        final TextView textView= tasarim.findViewById(R.id.sss_item_textview);
        textView.setText("10");



        Dialog ad = new Dialog(getApplicationContext());
        ad.setContentView(tasarim);

        ad.show();
    }
    public String dosyaoku(String filename){
        String cikmissorular = "";
        try {
            InputStream is = getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            cikmissorular = new String(buffer);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return cikmissorular;
    }
    public void sorularıBul(String cikmissorular,int soruSayısı){
        int i,k;
        sorular.clear();
        for (i=1;i<soruSayısı+1;i++){
             k= i+1;
            Soru soru = new  Soru(cikmissorular.substring(cikmissorular.indexOf(i+"."),cikmissorular.indexOf(k+".")));
            sorular.add(soru);
        }
    }
    int current = 1;
    @Override
    public void onClick(View v) {
        int dogruBeklemeSuresi=3000,hataliBeklemeSuresi=5000;
        int dogru_sayisi=0,yanlis_sayisi=0;

        switch (v.getId()){
            case (R.id.secenekA):
                if (current == soruSayisi){
                    Intent main = new Intent(SoruEkrani.this,MainActivity.class);
                    startActivity(main);

    }
                else if(cevapAnahtari.substring(current-1,current).equals("a")){
                    dogru_sayisi++;
                    Toast.makeText(getApplicationContext(),"Dogru cevap verdiniz !!",Toast.LENGTH_SHORT).show();
                    secenekA.setBackgroundResource(R.color.green);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            secenekA.setBackgroundResource(R.drawable.button_bg);
                            soruMetni.setText(sorular.get(current).getSoruMetni());
                            secenekA.setText(sorular.get(current).getA());
                            secenekB.setText(sorular.get(current).getB());
                            secenekC.setText(sorular.get(current).getC());
                            secenekD.setText(sorular.get(current).getD());
                            secenekE.setText(sorular.get(current).getE());
                            current++;

                        }
                    },dogruBeklemeSuresi);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Hatalı! Cevap: "+cevapAnahtari.substring(current-1,current).toUpperCase(),Toast.LENGTH_SHORT).show();
                    secenekA.setBackgroundResource(R.color.red);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            secenekA.setBackgroundResource(R.drawable.button_bg);
                            soruMetni.setText(sorular.get(current).getSoruMetni());
                            secenekA.setText(sorular.get(current).getA());
                            secenekB.setText(sorular.get(current).getB());
                            secenekC.setText(sorular.get(current).getC());
                            secenekD.setText(sorular.get(current).getD());
                            secenekE.setText(sorular.get(current).getE());
                            current++;

                        }
                    },hataliBeklemeSuresi);
                }




                break;
            case (R.id.secenekB):
                if (current == soruSayisi){

                    Intent main = new Intent(SoruEkrani.this,MainActivity.class);
                    startActivity(main);
                }
                else if(cevapAnahtari.substring(current-1,current).equals("b")){
                    dogru_sayisi++;
                    Toast.makeText(getApplicationContext(),"Dogru cevap verdiniz !!",Toast.LENGTH_SHORT).show();
                    secenekB.setBackgroundResource(R.color.green);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            secenekB.setBackgroundResource(R.drawable.button_bg);
                            soruMetni.setText(sorular.get(current).getSoruMetni());
                            secenekA.setText(sorular.get(current).getA());
                            secenekB.setText(sorular.get(current).getB());
                            secenekC.setText(sorular.get(current).getC());
                            secenekD.setText(sorular.get(current).getD());
                            secenekE.setText(sorular.get(current).getE());
                            current++;

                        }
                    },dogruBeklemeSuresi);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Hatalı! Cevap: "+cevapAnahtari.substring(current-1,current).toUpperCase(),Toast.LENGTH_SHORT).show();
                    secenekB.setBackgroundResource(R.color.red);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            secenekB.setBackgroundResource(R.drawable.button_bg);
                            soruMetni.setText(sorular.get(current).getSoruMetni());
                            secenekA.setText(sorular.get(current).getA());
                            secenekB.setText(sorular.get(current).getB());
                            secenekC.setText(sorular.get(current).getC());
                            secenekD.setText(sorular.get(current).getD());
                            secenekE.setText(sorular.get(current).getE());
                            current++;

                        }
                    },hataliBeklemeSuresi);
                }


                break;
            case (R.id.secenekC):
                if (current == soruSayisi){
                    Intent main = new Intent(SoruEkrani.this,MainActivity.class);
                    startActivity(main);
                }
                else if(cevapAnahtari.substring(current-1,current).equals("c")){
                    dogru_sayisi++;
                    Toast.makeText(getApplicationContext(),"Dogru cevap verdiniz !!",Toast.LENGTH_SHORT).show();
                    secenekC.setBackgroundResource(R.color.green);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            secenekC.setBackgroundResource(R.drawable.button_bg);
                            soruMetni.setText(sorular.get(current).getSoruMetni());
                            secenekA.setText(sorular.get(current).getA());
                            secenekB.setText(sorular.get(current).getB());
                            secenekC.setText(sorular.get(current).getC());
                            secenekD.setText(sorular.get(current).getD());
                            secenekE.setText(sorular.get(current).getE());
                            current++;

                        }
                    },dogruBeklemeSuresi);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Hatalı! Cevap: "+cevapAnahtari.substring(current-1,current).toUpperCase(),Toast.LENGTH_SHORT).show();
                    secenekC.setBackgroundResource(R.color.red);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            secenekC.setBackgroundResource(R.drawable.button_bg);
                            soruMetni.setText(sorular.get(current).getSoruMetni());
                            secenekA.setText(sorular.get(current).getA());
                            secenekB.setText(sorular.get(current).getB());
                            secenekC.setText(sorular.get(current).getC());
                            secenekD.setText(sorular.get(current).getD());
                            secenekE.setText(sorular.get(current).getE());
                            current++;

                        }
                    },hataliBeklemeSuresi);
                }


                break;
            case (R.id.secenekD):
                if (current == soruSayisi){
                    Intent main = new Intent(SoruEkrani.this,MainActivity.class);
                    startActivity(main);
                }
                else if(cevapAnahtari.substring(current-1,current).equals("d")){
                    dogru_sayisi++;
                    Toast.makeText(getApplicationContext(),"Dogru cevap verdiniz !!",Toast.LENGTH_SHORT).show();
                    secenekD.setBackgroundResource(R.color.green);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            secenekD.setBackgroundResource(R.drawable.button_bg);
                            soruMetni.setText(sorular.get(current).getSoruMetni());
                            secenekA.setText(sorular.get(current).getA());
                            secenekB.setText(sorular.get(current).getB());
                            secenekC.setText(sorular.get(current).getC());
                            secenekD.setText(sorular.get(current).getD());
                            secenekE.setText(sorular.get(current).getE());
                            current++;

                        }
                    },dogruBeklemeSuresi);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Hatalı! Cevap: "+cevapAnahtari.substring(current-1,current).toUpperCase(),Toast.LENGTH_SHORT).show();
                    secenekD.setBackgroundResource(R.color.red);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            secenekD.setBackgroundResource(R.drawable.button_bg);
                            soruMetni.setText(sorular.get(current).getSoruMetni());
                            secenekA.setText(sorular.get(current).getA());
                            secenekB.setText(sorular.get(current).getB());
                            secenekC.setText(sorular.get(current).getC());
                            secenekD.setText(sorular.get(current).getD());
                            secenekE.setText(sorular.get(current).getE());
                            current++;

                        }
                    },hataliBeklemeSuresi);
                }


                break;
            case (R.id.secenekE):
                if (current == soruSayisi){
                    Intent main = new Intent(SoruEkrani.this,MainActivity.class);
                    startActivity(main);
                }
                else if(cevapAnahtari.substring(current-1,current).equals("e")){
                    dogru_sayisi++;
                    Toast.makeText(getApplicationContext(),"Dogru cevap verdiniz !!",Toast.LENGTH_SHORT).show();
                    secenekE.setBackgroundResource(R.color.green);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            secenekE.setBackgroundResource(R.drawable.button_bg);
                            soruMetni.setText(sorular.get(current).getSoruMetni());
                            secenekA.setText(sorular.get(current).getA());
                            secenekB.setText(sorular.get(current).getB());
                            secenekC.setText(sorular.get(current).getC());
                            secenekD.setText(sorular.get(current).getD());
                            secenekE.setText(sorular.get(current).getE());
                            current++;

                        }
                    },dogruBeklemeSuresi);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Hatalı! Cevap: "+cevapAnahtari.substring(current-1,current).toUpperCase(),Toast.LENGTH_SHORT).show();
                    secenekE.setBackgroundResource(R.color.red);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            secenekE.setBackgroundResource(R.drawable.button_bg);
                            soruMetni.setText(sorular.get(current).getSoruMetni());
                            secenekA.setText(sorular.get(current).getA());
                            secenekB.setText(sorular.get(current).getB());
                            secenekC.setText(sorular.get(current).getC());
                            secenekD.setText(sorular.get(current).getD());
                            secenekE.setText(sorular.get(current).getE());
                            current++;

                        }
                    },hataliBeklemeSuresi);
                }


                break;




        }
    }

}

