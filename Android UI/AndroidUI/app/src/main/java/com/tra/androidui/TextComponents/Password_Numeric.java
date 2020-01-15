package com.tra.androidui.TextComponents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tra.androidui.R;

public class Password_Numeric extends AppCompatActivity {

    EditText passwordNumeric;
    Button btnValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password__numeric);

        init();

        btnValidation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validation();

            }
        });

    }


    public void init() {

        passwordNumeric = (EditText) findViewById(R.id.passwordNumericId);
        btnValidation = (Button) findViewById(R.id.btnValidationId);

    }

    public void validation() {

        String pass = passwordNumeric.getText().toString().trim();

        if (passwordNumeric.getText().toString().isEmpty()) {
            Toast toast = Toast.makeText(Password_Numeric.this, "Please Enter Password", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            passwordNumeric.requestFocus();


        } else if (passwordNumeric.getText().toString().length() < 6) {

            Toast toast = Toast.makeText(Password_Numeric.this, "Password must have 6 numbers", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();

            passwordNumeric.requestFocus();
        } else if (passwordNumeric.getText().toString().length() == 6) {
            Toast toast = Toast.makeText(Password_Numeric.this, "Password typo is true", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }

    }
}
