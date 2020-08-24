package com.hrdijital.multilivedata;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProductModal extends ViewModel {
    private MutableLiveData<Integer> count ;
    public MutableLiveData<Integer> getCount() {
        if (count == null) {
            count = new MutableLiveData<>();
        }
        return count;
    }
}
