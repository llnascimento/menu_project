package com.example.aula3009.ui.curso;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CursoViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public CursoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Análise e Desenvolvimento de Sistemas");
    }

    public LiveData<String> getText() {
        return mText;
    }
}