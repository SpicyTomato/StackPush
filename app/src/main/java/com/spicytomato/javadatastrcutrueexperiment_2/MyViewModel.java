package com.spicytomato.javadatastrcutrueexperiment_2;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;

public class MyViewModel extends AndroidViewModel {

    private SavedStateHandle handle;

    private final static String STACK_HEAD = "stack_head";

    public MyViewModel(@NonNull Application application,SavedStateHandle handle) {
        super(application);
        if(handle.contains(STACK_HEAD)){
            handle.set(STACK_HEAD,new Stack<>());
        }
        this.handle = handle;
    }


    public MutableLiveData<Stack> getStackHead(){
        return handle.getLiveData(STACK_HEAD);
    }


}
