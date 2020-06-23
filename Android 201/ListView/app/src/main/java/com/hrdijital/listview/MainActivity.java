package com.hrdijital.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.hrdijital.listview.adapter.LangAdapter;
import com.hrdijital.listview.modal.LangModel;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ListView listView;
    LangAdapter adapter = null;
    ArrayList<LangModel> langs = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);
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
                adapter.updateRecords(langs);
                reloadAllData();
            }
        });
    }
    private void reloadAllData(){
        adapter.notifyDataSetChanged();
        adapter.notifyDataSetInvalidated();
        listView.invalidateViews();
        listView.refreshDrawableState();
    }
}