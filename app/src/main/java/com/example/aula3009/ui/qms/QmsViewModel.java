package com.example.aula3009.ui.qms;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class QmsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public QmsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is qms fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}