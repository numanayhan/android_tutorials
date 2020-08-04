package com.hrdijital.listview.modal;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LangModal extends ViewModel {

    private MutableLiveData<String> name;

    public void setNameData(String nameData) {
        name.setValue(nameData);

/*
        If you are calling setNameData from a background thread use:
        name.postValue(nameData);
*/
    }

    public MutableLiveData<String> getNameData() {
        if (name == null) {
            name = new MutableLiveData<>();
        }

        return name;
    }
}
