package com.example.myapplication;

import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

public class MBackgroundService extends android.app.IntentService {
    private final static String TAG= " com.example.myapplication";
    public MBackgroundService() {
        super("IntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.e("TAG", "onHandleIntent: service has started");


    }
}
