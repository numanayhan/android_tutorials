package com.tra.androidui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnTextView, btnButtonView, btnWidgetView, btnContainerView, btnLegacyView, btnLayoutView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btnTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TextViewActivity.class);
                startActivity(intent);
            }
        });
    }

    public void init() {
        btnTextView = (Button) findViewById(R.id.textId);
        btnButtonView = (Button) findViewById(R.id.buttonId);
        btnContainerView = (Button) findViewById(R.id.containersId);
        btnLayoutView = (Button) findViewById(R.id.layoutsId);
        btnWidgetView = (Button) findViewById(R.id.widgetId);
        btnLegacyView = (Button) findViewById(R.id.legacyId);

    }
}
