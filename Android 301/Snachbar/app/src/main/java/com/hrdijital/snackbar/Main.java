package com.hrdijital.snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class Main extends AppCompatActivity implements View.OnClickListener {

    LinearLayout show;
    AppCompatActivity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        show = findViewById(R.id.show);
        show.setOnClickListener(this);
        activity = Main.this;
    }
    public void showBar(String text){
        Snackbar snack = Snackbar.make(activity.findViewById(R.id.showView), text, Snackbar.LENGTH_SHORT)
                .setBackgroundTint(activity.getResources().getColor(R.color.black))
                .setTextColor(activity.getResources().getColor(R.color.white));
        snack.setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_FADE);
        View view = snack.getView();
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) view.getLayoutParams();
        params.gravity = Gravity.TOP;
        int actionBarHeight = 5;
        TypedValue tv = new TypedValue();
        if (activity.getResources().newTheme().resolveAttribute(R.attr.actionBarSize, tv, true)) {
            actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data, getResources().getDisplayMetrics());
        }
        params.setMargins(actionBarHeight, actionBarHeight, actionBarHeight, 0);
        view.setLayoutParams(params);
        snack.show();
    }

    @Override
    public void onClick(View view) {
        if (view.findViewById(R.id.show) != null){
            showBar("TEST");
        }
    }
}