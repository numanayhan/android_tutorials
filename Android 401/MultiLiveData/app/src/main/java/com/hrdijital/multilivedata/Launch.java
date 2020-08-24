package com.hrdijital.multilivedata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.facebook.shimmer.ShimmerFrameLayout;

public class Launch extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity( new Intent(Launch.this,MultiLiveMain.class));

            }
        }, 1500);
    }


}