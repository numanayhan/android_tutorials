package com.tra.androidui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tra.androidui.TextComponents.Email;
import com.tra.androidui.TextComponents.Numbers;
import com.tra.androidui.TextComponents.Password;
import com.tra.androidui.TextComponents.Password_Numeric;
import com.tra.androidui.TextComponents.Phone;
import com.tra.androidui.TextComponents.PlainText;
import com.tra.androidui.TextComponents.Text;

public class TextViewActivity extends AppCompatActivity {


    Button btnTextView, btnPlainText, btnPassword, btnPassNumeric, btnEmail, btnPhone, btnNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);

        init();

        btnTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TextViewActivity.this, Text.class);

                startActivity(intent);
            }
        });

        btnPlainText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TextViewActivity.this, PlainText.class);

                startActivity(intent);
            }
        });

        btnPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TextViewActivity.this, Password.class);

                startActivity(intent);
            }
        });

        btnPassNumeric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TextViewActivity.this, Password_Numeric.class);

                startActivity(intent);
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TextViewActivity.this, Email.class);

                startActivity(intent);
            }
        });

        btnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TextViewActivity.this, Phone.class);

                startActivity(intent);
            }
        });

        btnNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TextViewActivity.this, Numbers.class);

                startActivity(intent);
            }
        });


    }

    public void init() {
        btnTextView = (Button) findViewById(R.id.textViewId);
        btnPlainText = (Button) findViewById(R.id.plainTextViewId);
        btnPassword = (Button) findViewById(R.id.passwordViewId);
        btnPassNumeric = (Button) findViewById(R.id.passNumericViewId);
        btnEmail = (Button) findViewById(R.id.emailViewId);
        btnPhone = (Button) findViewById(R.id.phoneViewId);
        btnNumbers = (Button)findViewById(R.id.btnNumberId);

    }
}
