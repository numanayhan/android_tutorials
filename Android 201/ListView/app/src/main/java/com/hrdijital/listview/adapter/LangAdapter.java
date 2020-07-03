package com.hrdijital.listview.adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.hrdijital.listview.BR;
import com.hrdijital.listview.R;
import com.hrdijital.listview.modal.LangHolder;
import com.hrdijital.listview.modal.LangModel;

import java.util.List;


public class LangAdapter extends BaseAdapter {

    Activity activity;
    List<LangModel> langs;
    LayoutInflater inflater;

    public LangAdapter(Activity activity, List<LangModel> langs) {
        this.activity = activity;
        this.langs = langs;
        inflater = activity.getLayoutInflater();
    }
    @Override
    public int getCount() {
        return langs.size();
    }
    @Override
    public Object getItem(int i) {
        return i;
    }
    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LangHolder holder = null;
        if (view == null) {
            view = inflater.inflate(R.layout.item, viewGroup, false);
            holder = new LangHolder(view);
            holder.name = (TextView) view.findViewById(R.id.name);
            holder.ivCheckBox = (ImageView) view.findViewById(R.id.check_box);
            view.setTag(holder);
        } else {
            holder = (LangHolder) view.getTag();
        }
        LangModel model = langs.get(i);
        holder.name.setText(model.getName());
        if (model.getSelected()) {
            holder.ivCheckBox.setVisibility(View.VISIBLE);
            holder.ivCheckBox.setBackgroundResource(R.drawable.ic_check);
        } else {
            holder.ivCheckBox.setVisibility(View.GONE);
        }
        return view;
    }
    public void updateRecords(List<LangModel> langs) {
        this.langs = langs;
        notifyDataSetChanged();
    }
}