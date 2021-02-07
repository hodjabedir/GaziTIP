package com.example.gazitip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
  Button k1,k2,k3,k4,k5,k6,k7,y2016,y2017,y2018,y2019,d1,d2,d3,d4,d5,d6,sorularagit;
  private String donem="0",yil="0",komite="0";
  private Boolean dosyaVarmi=false;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reklamgoster();

        mAdView = findViewById(R.id.adView_main);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        sorularagit = (Button) findViewById(R.id.sorularagit_btn);

        k1 = (Button)findViewById(R.id.komite1);
        k2 = (Button)findViewById(R.id.komite2);
        k3 = (Button)findViewById(R.id.komite3);
        k4 = (Button)findViewById(R.id.komite4);
        k5 = (Button)findViewById(R.id.komite5);
        k6 = (Button)findViewById(R.id.komite6);
        k7 = (Button)findViewById(R.id.komite7);

        y2016 = (Button)findViewById(R.id.yil2016);
        y2017 = (Button)findViewById(R.id.yil2017);
        y2018 = (Button)findViewById(R.id.yil2018);
        y2019 = (Button)findViewById(R.id.yil2019);

        d1 = (Button)findViewById(R.id.donem1);
        d2 = (Button)findViewById(R.id.donem2);
        d3 = (Button)findViewById(R.id.donem3);
        d4 = (Button)findViewById(R.id.donem4);
        d5 = (Button)findViewById(R.id.donem5);
        d6 = (Button)findViewById(R.id.donem6);



        k1.setOnClickListener(this);
        k2.setOnClickListener(this);
        k3.setOnClickListener(this);
        k4.setOnClickListener(this);
        k5.setOnClickListener(this);
        k6.setOnClickListener(this);
        k7.setOnClickListener(this);

        y2016.setOnClickListener(this);
        y2017.setOnClickListener(this);
        y2018.setOnClickListener(this);
        y2019.setOnClickListener(this);

        d1.setOnClickListener(this);
        d2.setOnClickListener(this);
        d3.setOnClickListener(this);
        d4.setOnClickListener(this);
        d5.setOnClickListener(this);
        d6.setOnClickListener(this);

        sorularagit.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        dosyaoku(("d"+donem+"k"+komite+"y"+yil));
        switch (v.getId()){
            case (R.id.donem1):
                donem="1";
                d1.setBackgroundResource(R.drawable.ic_done);
                d2.setBackgroundResource(R.drawable.button_background);
                d3.setBackgroundResource(R.drawable.button_background);
                d4.setBackgroundResource(R.drawable.button_background);
                d5.setBackgroundResource(R.drawable.button_background);
                d6.setBackgroundResource(R.drawable.button_background);
                break;
            case (R.id.donem2):
                donem="2";
                d2.setBackgroundResource(R.drawable.ic_done);
                d1.setBackgroundResource(R.drawable.button_background);
                d3.setBackgroundResource(R.drawable.button_background);
                d4.setBackgroundResource(R.drawable.button_background);
                d5.setBackgroundResource(R.drawable.button_background);
                d6.setBackgroundResource(R.drawable.button_background);
                break;
            case (R.id.donem3):
                donem="3";
                d3.setBackgroundResource(R.drawable.ic_done);
                d2.setBackgroundResource(R.drawable.button_background);
                d1.setBackgroundResource(R.drawable.button_background);
                d4.setBackgroundResource(R.drawable.button_background);
                d5.setBackgroundResource(R.drawable.button_background);
                d6.setBackgroundResource(R.drawable.button_background);
                break;
            case (R.id.donem4):
                donem="4";
                d4.setBackgroundResource(R.drawable.ic_done);
                d2.setBackgroundResource(R.drawable.button_background);
                d3.setBackgroundResource(R.drawable.button_background);
                d1.setBackgroundResource(R.drawable.button_background);
                d5.setBackgroundResource(R.drawable.button_background);
                d6.setBackgroundResource(R.drawable.button_background);
                break;
            case (R.id.donem5):
                donem="5";
                d5.setBackgroundResource(R.drawable.ic_done);
                d2.setBackgroundResource(R.drawable.button_background);
                d3.setBackgroundResource(R.drawable.button_background);
                d4.setBackgroundResource(R.drawable.button_background);
                d1.setBackgroundResource(R.drawable.button_background);
                d6.setBackgroundResource(R.drawable.button_background);
                break;
            case (R.id.donem6):
                donem="6";
                d6.setBackgroundResource(R.drawable.ic_done);
                d2.setBackgroundResource(R.drawable.button_background);
                d3.setBackgroundResource(R.drawable.button_background);
                d4.setBackgroundResource(R.drawable.button_background);
                d5.setBackgroundResource(R.drawable.button_background);
                d1.setBackgroundResource(R.drawable.button_background);
                break;
            case (R.id.komite1):
                komite="1";
                k1.setBackgroundResource(R.drawable.ic_done);
                k2.setBackgroundResource(R.drawable.button_background);
                k3.setBackgroundResource(R.drawable.button_background);
                k4.setBackgroundResource(R.drawable.button_background);
                k5.setBackgroundResource(R.drawable.button_background);
                k6.setBackgroundResource(R.drawable.button_background);
                k7.setBackgroundResource(R.drawable.button_background);
                break;
            case (R.id.komite2):
                komite="2";
                k2.setBackgroundResource(R.drawable.ic_done);
                k1.setBackgroundResource(R.drawable.button_background);
                k3.setBackgroundResource(R.drawable.button_background);
                k4.setBackgroundResource(R.drawable.button_background);
                k5.setBackgroundResource(R.drawable.button_background);
                k6.setBackgroundResource(R.drawable.button_background);
                k7.setBackgroundResource(R.drawable.button_background);
                break;
            case (R.id.komite3):
                komite="3";
                k3.setBackgroundResource(R.drawable.ic_done);
                k2.setBackgroundResource(R.drawable.button_background);
                k1.setBackgroundResource(R.drawable.button_background);
                k4.setBackgroundResource(R.drawable.button_background);
                k5.setBackgroundResource(R.drawable.button_background);
                k6.setBackgroundResource(R.drawable.button_background);
                k7.setBackgroundResource(R.drawable.button_background);
                break;
            case (R.id.komite4):
                komite="4";
                k4.setBackgroundResource(R.drawable.ic_done);
                k2.setBackgroundResource(R.drawable.button_background);
                k3.setBackgroundResource(R.drawable.button_background);
                k1.setBackgroundResource(R.drawable.button_background);
                k5.setBackgroundResource(R.drawable.button_background);
                k6.setBackgroundResource(R.drawable.button_background);
                k7.setBackgroundResource(R.drawable.button_background);
                break;
            case (R.id.komite5):
                komite="5";
                k5.setBackgroundResource(R.drawable.ic_done);
                k2.setBackgroundResource(R.drawable.button_background);
                k3.setBackgroundResource(R.drawable.button_background);
                k4.setBackgroundResource(R.drawable.button_background);
                k1.setBackgroundResource(R.drawable.button_background);
                k6.setBackgroundResource(R.drawable.button_background);
                k7.setBackgroundResource(R.drawable.button_background);
                break;
            case (R.id.komite6):
                komite="6";
                k6.setBackgroundResource(R.drawable.ic_done);
                k2.setBackgroundResource(R.drawable.button_background);
                k3.setBackgroundResource(R.drawable.button_background);
                k4.setBackgroundResource(R.drawable.button_background);
                k5.setBackgroundResource(R.drawable.button_background);
                k1.setBackgroundResource(R.drawable.button_background);
                k7.setBackgroundResource(R.drawable.button_background);
                break;
            case (R.id.komite7):
                komite="7";
                k7.setBackgroundResource(R.drawable.ic_done);
                k2.setBackgroundResource(R.drawable.button_background);
                k3.setBackgroundResource(R.drawable.button_background);
                k4.setBackgroundResource(R.drawable.button_background);
                k5.setBackgroundResource(R.drawable.button_background);
                k6.setBackgroundResource(R.drawable.button_background);
                k1.setBackgroundResource(R.drawable.button_background);
                break;
            case (R.id.yil2016):
                yil="2016";
                y2016.setBackgroundResource(R.drawable.ic_done);
                y2017.setBackgroundResource(R.drawable.button_background);
                y2018.setBackgroundResource(R.drawable.button_background);
                y2019.setBackgroundResource(R.drawable.button_background);
                break;
            case (R.id.yil2017):
                yil="2017";
                y2017.setBackgroundResource(R.drawable.ic_done);
                y2016.setBackgroundResource(R.drawable.button_background);
                y2018.setBackgroundResource(R.drawable.button_background);
                y2019.setBackgroundResource(R.drawable.button_background);

                break;
            case (R.id.yil2018):
                yil="2018";
                y2018.setBackgroundResource(R.drawable.ic_done);
                y2017.setBackgroundResource(R.drawable.button_background);
                y2016.setBackgroundResource(R.drawable.button_background);
                y2019.setBackgroundResource(R.drawable.button_background);

                break;
            case (R.id.yil2019):
                yil="2019";
                y2019.setBackgroundResource(R.drawable.ic_done);
                y2017.setBackgroundResource(R.drawable.button_background);
                y2018.setBackgroundResource(R.drawable.button_background);
                y2016.setBackgroundResource(R.drawable.button_background);

                break;


            case (R.id.sorularagit_btn):
                if (yil.equals("0") || donem.equals("0") || komite.equals("0")){
                    Toast.makeText(getApplicationContext(),"Lütfen geçerli secim Yapınız !",Toast.LENGTH_SHORT).show();
                }
                else if( !dosyaVarmi){
                    Toast.makeText(getApplicationContext(),"Yakında erişime açılacak",Toast.LENGTH_LONG).show();
                }
                else
                    {
                        reklamgoster();
                Intent soruEkrani = new Intent(MainActivity.this,SoruEkrani.class);
                soruEkrani.putExtra("sinav","d"+donem+"k"+komite+"y"+yil);
                startActivity(soruEkrani);}
                break;
        }

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
            dosyaVarmi = true;
        } catch (IOException e) {
            e.printStackTrace();
            dosyaVarmi=false;

        }
        return cikmissorular;
    }
    public void reklamgoster(){
        mInterstitialAd = new InterstitialAd(getApplicationContext());
        mInterstitialAd.setAdUnitId("ca-app-pub-7739380766735309/2786428400"); //test için olan id değiştirilecek unutma
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                mInterstitialAd.show();
                super.onAdLoaded();
            }
        });
    }


}
