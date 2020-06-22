package com.example.intentexample;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import androidx.annotation.Nullable;

public class BuckysIntentService extends IntentService{

    private static final String TAG = "com.example.intentexample";

    public BuckysIntentService(){
        super("BuckysIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.i(TAG,"The service has started");
    }
}
