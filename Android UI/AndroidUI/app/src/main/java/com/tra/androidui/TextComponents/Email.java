package com.tra.androidui.TextComponents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tra.androidui.R;

public class Email extends AppCompatActivity {

    EditText editEmail;
    Button btnValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        init();

        btnValidation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validation();
            }
        });
    }

    public void init() {

        editEmail=(EditText)findViewById(R.id.emailId);
        btnValidation=(Button)findViewById(R.id.btnValidationId);

    }

    public void validation() {

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(editEmail.getText().toString().isEmpty()) {

            Toast toast = Toast.makeText(Email.this, "Enter Email Address", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            editEmail.requestFocus();
        }else {
            if (editEmail.getText().toString().trim().matches(emailPattern) && editEmail.length() > 0 ) {
                Toast toast = Toast.makeText(Email.this, "Valid Email Address", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();

             } else {
                Toast toast = Toast.makeText(Email.this, "Invalid Email Address", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();

                editEmail.requestFocus();
            }
        }

    }

}
