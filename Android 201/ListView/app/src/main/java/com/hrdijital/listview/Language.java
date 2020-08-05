package com.hrdijital.listview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.hrdijital.listview.adapter.LangAdapter;
import com.hrdijital.listview.modal.LangModel;

import java.util.ArrayList;

public class Language extends Fragment {

    public Language() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.language, container, false);
        //TextView close = inflate.findViewById(R.id.close);
        return inflate;
    }

}