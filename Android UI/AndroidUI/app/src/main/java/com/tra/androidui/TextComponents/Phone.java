package com.tra.androidui.TextComponents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tra.androidui.R;

public class Phone extends AppCompatActivity {

    EditText editPhone;
    Button btnValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

        init();

        btnValidation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validation();
            }
        });

    }

    public void init() {

        editPhone = (EditText) findViewById(R.id.editPhone);
        btnValidation = (Button) findViewById(R.id.btnValidationId);

    }

    public void validation() {

        String MobilePattern = "[0-9]{10}";

        if (editPhone.getText().toString().isEmpty()) {
            Toast toast = Toast.makeText(Phone.this, "Enter Phone Number", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        } else if (editPhone.getText().toString().matches(MobilePattern)) {

            Toast toast = Toast.makeText(Phone.this, "Phone Number Is Valid", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();


        } else if (!editPhone.getText().toString().matches(MobilePattern)) {

            Toast toast = Toast.makeText(Phone.this, "Please enter valid 10 digit phone number", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();

            editPhone.requestFocus();
        }


    }
}
