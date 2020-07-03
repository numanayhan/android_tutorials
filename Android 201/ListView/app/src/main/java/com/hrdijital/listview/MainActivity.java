package com.hrdijital.listview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.hrdijital.listview.adapter.LangAdapter;
import com.hrdijital.listview.databinding.ActivityMainBinding;
import com.hrdijital.listview.modal.LangHolder;
import com.hrdijital.listview.modal.LangModal;
import com.hrdijital.listview.modal.LangModel;

import java.util.ArrayList;

import androidx.lifecycle.ViewModelProviders;
public class MainActivity extends AppCompatActivity {
    ListView listView;
    LangAdapter  adapter ;
    ArrayList<LangModel> langs ;

    ActivityMainBinding activityMainBinding;
    LangModal langModel;
    private Observer<String> nameObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        langModel = ViewModelProviders.of(this).get(LangModal.class);
        nameObserver = new Observer<String>() {
            @Override
            public void onChanged(String name) {
                Log.d(name, "onChanged: ");
            }
        };

        TextView changeLang = (TextView)findViewById(R.id.change);
        changeLang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuShow();
            }
        });

        langModel.getNameData().observe(this, nameObserver);
    }
    public static int dp2px(Context context, float dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpVal,
                context.getResources().getDisplayMetrics());
    }
    public void menuShow(){


        final Dialog bottomDialog = new Dialog(this, R.style.Theme_AppCompat_DayNight_Dialog);
        final View contentView = LayoutInflater.from(this).inflate(R.layout.language, null);
        bottomDialog.setContentView(contentView);
        listView = (ListView)contentView.findViewById(R.id.listview);
        langModel = ViewModelProviders.of(this).get(LangModal.class);

        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) contentView.getLayoutParams();
        params.width = getResources().getDisplayMetrics().widthPixels - dp2px(this, 0f);


        int height = (int)(getResources().getDisplayMetrics().heightPixels*0.50);
        params.topMargin= dp2px(this,  height);
        contentView.setLayoutParams(params);
        bottomDialog.getWindow().setGravity(Gravity.BOTTOM);
        bottomDialog.setCanceledOnTouchOutside(true);
        bottomDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        final Window window = bottomDialog.getWindow();

        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setGravity(Gravity.CENTER);
        bottomDialog.show();

        TextView close = contentView.findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomDialog.dismiss();
            }
        });

        langs = new ArrayList<>();
        langs.add(new LangModel(true, "Türkçe"));
        langs.add(new LangModel(false, "İngilizce"));
        langs.add(new LangModel(false, "Japonca"));
        langs.add(new LangModel(false, "Latince"));

        adapter = new LangAdapter(this, langs);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                LangModel model = langs.get(i);
                for (LangModel pair : langs) {
                    if (pair.getSelected()){
                        pair.setSelected(false);
                        langs.set(i, model);
                    }
                    if (model.getName().equals(pair.getName())){
                        if (model.getSelected()){
                            pair.setSelected(false);
                            langs.set(i, model);
                        }else if (!model.getSelected()){
                            pair.setSelected(true);
                            langs.set(i, model);
                        }
                    }
                }
                langModel.getNameData().setValue(model.getName());
                adapter.updateRecords(langs);
                reloadAllData();
            }
        });
    }
    private void reloadAllData(){
        adapter.notifyDataSetChanged();
        listView.invalidateViews();
        listView.refreshDrawableState();
    }
}