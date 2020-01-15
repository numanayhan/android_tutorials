package com.tra.androidui.TextComponents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.tra.androidui.R;

public class PlainText extends AppCompatActivity {

    EditText editTextBackEnd;
    TextView textView;
    String name;
    TextInputLayout input_layout_edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plain_text);

        init();

        // this method looks after the focus is changed to another edit text and it sets editText text to textView
        editTextBackEnd.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    editTextBackEnd.setCursorVisible(true);
                    input_layout_edit.setBackground(getDrawable(R.drawable.backgrounddark));
                } else if (!hasFocus) {
                    name = editTextBackEnd.getText().toString();// get text from edittext
                    textView.setText(name);//set String to TextView
                    editTextBackEnd.setCursorVisible(false);
                    input_layout_edit.setBackground(getDrawable(R.drawable.backgroundedit));
                }

            }
        });


    }

    public void init(){

        input_layout_edit=(TextInputLayout)findViewById(R.id.input_layout_email);

        editTextBackEnd = (EditText) findViewById(R.id.editTextBackEndId);
        textView = (TextView) findViewById(R.id.textView123);
    }
}
