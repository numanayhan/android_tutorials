package com.hrdijital.listview.modal;

import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.hrdijital.listview.BR;

public class LangModel extends BaseObservable {
    public boolean isSelected;
    public String name;
    public LangModel(boolean isSelected, String name) {
        this.isSelected = isSelected;
        this.name = name;
    }

    public boolean getSelected() {
        return isSelected;
    }
    @Bindable
    public void setSelected(boolean selected) {
        isSelected = selected;
        notifyPropertyChanged(BR.selected);
    }
    @Bindable
    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }
    public String getName() {
        return name;
    }
}
