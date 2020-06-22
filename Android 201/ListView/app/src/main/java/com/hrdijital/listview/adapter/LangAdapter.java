package com.hrdijital.listview.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hrdijital.listview.R;
import com.hrdijital.listview.modal.LangModel;

import java.util.List;


public class LangAdapter extends BaseAdapter {

    Activity activity;
    List<LangModel> langs;
    LayoutInflater inflater;
    public LangAdapter(Activity activity) {
        this.activity = activity;
    }

    public LangAdapter(Activity activity, List<LangModel> langs) {
        this.activity   = activity;
        this.langs      = langs;

        inflater        = activity.getLayoutInflater();
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

        ViewHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.item, viewGroup, false);
            holder = new ViewHolder();
            holder.tvName = (TextView)view.findViewById(R.id.tv_name);
            holder.ivCheckBox = (ImageView) view.findViewById(R.id.iv_check_box);
            view.setTag(holder);
        }else{
            holder = (ViewHolder)view.getTag();
        }
        LangModel model = langs.get(i);

        holder.tvName.setText(model.getName());

        if (model.getSelected()){

            holder.ivCheckBox.setVisibility(View.VISIBLE);
            holder.ivCheckBox.setBackgroundResource(R.drawable.ic_check);
        }
        else{
            holder.ivCheckBox.setVisibility(View.GONE);
        }
        return view;
    }

    public void updateRecords(List<LangModel>  langs){
        this.langs = langs;
        notifyDataSetChanged();
    }
    class ViewHolder{
        TextView tvName;
        ImageView ivCheckBox;

    }
}