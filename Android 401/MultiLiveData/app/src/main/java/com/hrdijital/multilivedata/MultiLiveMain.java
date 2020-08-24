package com.hrdijital.multilivedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MultiLiveMain extends AppCompatActivity implements View.OnClickListener {

    TextView show_products, pieceText;
    AppCompatActivity activity;
    ProductModal productModal;
    Observer<Integer> productObserver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        activity = MultiLiveMain.this;
        show_products = findViewById(R.id.show_products);
        show_products.setOnClickListener(this);
        pieceText = findViewById(R.id.pieceText);
        productModal = ViewModelProviders.of(activity).get(ProductModal.class);
        productModal.getCount().setValue(0);
        productObserver = new Observer<Integer>() {
            @Override
            public void onChanged(Integer name) {
                if (name != 0){
                    pieceText.setText(name.toString());
                }

            }
        };
        productModal.getCount().observe(activity, productObserver);
    }

    @Override
    public void onClick(View view) {
        if (view.findViewById(R.id.show_products) != null) {
            showProduct();
        }
    }

    private void showProduct() {

        final Dialog bottomDialog = new Dialog(activity, R.style.BottomDialog);
        View contentView = LayoutInflater.from(activity).inflate(R.layout.products, null);
        bottomDialog.setContentView(contentView);
        ImageView productAdd = contentView.findViewById(R.id.p_add);
        ImageView productRemove = contentView.findViewById(R.id.p_remove);
        final TextView productPiece = contentView.findViewById(R.id.p_piece);

        productAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (productModal.getCount().getValue() != null) {
                    if (productModal.getCount().getValue() > 5) {
                        Snackbar.make(view, R.string.max_count, Snackbar.LENGTH_SHORT).show();
                    } else {
                        productModal.getCount().setValue(+1);
                        String count = productModal.getCount().getValue().toString();
                        productPiece.setText(count);
                    }
                }
            }
        });
        productRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (productModal.getCount().getValue() != null) {
                    if (productModal.getCount().getValue() == 0) {
                        Snackbar.make(view, R.string.min_count, Snackbar.LENGTH_SHORT).show();
                    } else {
                        productModal.getCount().setValue(-1);
                        String count = productModal.getCount().getValue().toString();
                        productPiece.setText(count);
                    }
                }
            }
        });
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) contentView.getLayoutParams();
        params.bottomMargin = 0;
        contentView.setLayoutParams(params);
        bottomDialog.getWindow().setGravity(Gravity.BOTTOM);
        bottomDialog.setCanceledOnTouchOutside(true);
        bottomDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        bottomDialog.getWindow().setWindowAnimations(R.style.BottomDialog_Animation);
        final Window window = bottomDialog.getWindow();

        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setGravity(Gravity.BOTTOM);
        bottomDialog.show();

        ImageView close = contentView.findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomDialog.dismiss();
            }
        });
    }
}