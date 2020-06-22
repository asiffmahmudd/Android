package com.example.boundservice;

import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.os.IBinder;
import android.content.Intent;
import android.content.Context;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import com.example.boundservice.MyService.MyLocaleBinder;

public class MainActivity extends AppCompatActivity {

    MyService buckysService;
    boolean isBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = new Intent(this, MyService.class);
        bindService(i,buckysConnection, Context.BIND_AUTO_CREATE);
    }

    public void showTime(View view){
        String currentTime = buckysService.getCurrentTime();
        TextView buckysText = (TextView)findViewById(R.id.buckysText);
        buckysText.setText(currentTime);
    }

    private ServiceConnection buckysConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyLocaleBinder binder = (MyLocaleBinder) service;
            buckysService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };
}
