package com.tra.androidui.TextComponents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tra.androidui.R;

public class Password extends AppCompatActivity {

    EditText editPassword;
    Button btnValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        init();


        btnValidation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passwordValidation();
            }
        });

    }

    public void init() {
        editPassword = (EditText) findViewById(R.id.passwordID);
        btnValidation = (Button) findViewById(R.id.btnValidationId);
    }

    public void passwordValidation() {
        String validatePassword = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_-])(?=\\S+$).{6,20})";
        String pass = editPassword.getText().toString().trim();

        if (editPassword.getText().toString().isEmpty()) {
            Toast toast = Toast.makeText(Password.this, "Please Enter Password", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            editPassword.requestFocus();

        } else if (pass.matches("")) {
            Toast toast = Toast.makeText(Password.this, "No Spaces Allowed", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            editPassword.requestFocus();

        } else if (!pass.matches(validatePassword)) {
            Toast toast = Toast.makeText(Password.this, "Password must contain at least One Uppercase, One Lowercase, One Number and One Special Character", Toast.LENGTH_LONG); // Password must contain at least One Uppercase, One Lowercase, One Number and One Special Character
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();

            editPassword.requestFocus();

        } else if (editPassword.getText().toString().length() < 6 && editPassword.getText().toString().length() > 20) {

            Toast toast = Toast.makeText(Password.this, "Password must have minimum 6 characters", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();

            editPassword.requestFocus();
        } else {

            Toast toast = Toast.makeText(Password.this, "Password is Correct", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();

        }
    }
}
