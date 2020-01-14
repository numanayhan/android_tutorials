package com.tra.androidui.TextComponents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.tra.androidui.R;

public class Text extends AppCompatActivity {

    TextView textViewBackEdit ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        textViewBackEdit=(TextView)findViewById(R.id.textViewBackEdit);

        textViewBackEdit.setText("Text Changed From BackEnd");//Change text by the code with set Text
        textViewBackEdit.setVisibility(View.VISIBLE); //Make the text Visible(View.VISIBLE) or Unvisible (View.GONE)

        textViewBackEdit.setTextColor(getResources().getColor(R.color.yellow)); //Changing text color




    }


}
