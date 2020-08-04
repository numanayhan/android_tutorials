package com.hrdijital.listview.modal;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hrdijital.listview.R;

public class LangHolder extends RecyclerView.ViewHolder {

   public  TextView name;
    public ImageView ivCheckBox;


    public LangHolder(@NonNull View itemView) {
        super(itemView);
        this.name = (TextView)itemView.findViewById(R.id.name);
        this.ivCheckBox = (ImageView)itemView.findViewById(R.id.check_box);

    }
}
