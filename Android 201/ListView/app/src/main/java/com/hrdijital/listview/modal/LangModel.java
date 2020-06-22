package com.hrdijital.listview.modal;

public class LangModel {
    boolean isSelected;
    String name;
    public LangModel(boolean isSelected, String name) {
        this.isSelected = isSelected;
        this.name = name;
    }

    public boolean getSelected() {
        return isSelected;
    }
    public void setSelected(boolean selected) {
        isSelected = selected;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
