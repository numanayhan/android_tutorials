package com.tra.androidui.TextComponents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.method.DigitsKeyListener;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tra.androidui.R;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Numbers extends AppCompatActivity {

    EditText editNumber, editSigned, editDecimal;
    TextView txtNumber, txtSigned, txtDecimal;
    Button btnValidation;

    DecimalFormat formatCrypto = new DecimalFormat("####.00000000");
    DecimalFormat formatTry = new DecimalFormat("####.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        init();


        btnValidation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validation();

            }
        });


    }

    public void init() {

        editNumber = (EditText) findViewById(R.id.numberId);
        editSigned = (EditText) findViewById(R.id.signedId);
        editDecimal = (EditText) findViewById(R.id.decimalId);

        txtNumber = (TextView) findViewById(R.id.txtNumberId);
        txtSigned = (TextView) findViewById(R.id.txtSignedId);
        txtDecimal = (TextView) findViewById(R.id.txtDecimalId);

        btnValidation = (Button) findViewById(R.id.btnValidationId);


    }

    public void validation() {

        editDecimal.setFilters(new InputFilter[]{
                new DigitsKeyListener(Boolean.FALSE, Boolean.TRUE) {
                    int beforeDecimal = 5, afterDecimal = 8;

                    @Override
                    public CharSequence filter(CharSequence source, int start, int end,
                                               Spanned dest, int dstart, int dend) {
                        String temp = editDecimal.getText() + source.toString();

                        if (temp.equals(".")) {
                            return "0.";
                        } else if (temp.toString().indexOf(".") == -1) {
                            // no decimal point placed yet
                            if (temp.length() > beforeDecimal) {
                                return "";
                            }
                        } else {
                            temp = temp.substring(temp.indexOf(".") + 1);
                            if (temp.length() > afterDecimal) {
                                return "";
                            }
                        }

                        return super.filter(source, start, end, dest, dstart, dend);
                    }
                }
        });

        if (editDecimal.getText().toString().isEmpty()) {

            Toast toast = Toast.makeText(Numbers.this, "You cant leave Decimal Number Empty", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        } else if (editNumber.getText().toString().isEmpty()) {

            Toast toast = Toast.makeText(Numbers.this, "You cant leave Number Empty", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        } else if (editSigned.getText().toString().isEmpty()) {

            Toast toast = Toast.makeText(Numbers.this, "You cant leave Signed Number Empty", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }


    }
}
