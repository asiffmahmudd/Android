package com.example.grid;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.MenuItem;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buckysButton = (Button)findViewById(R.id.buckysButton);
        buckysButton.setOnClickListener(
            new Button.OnClickListener(){
                public void onClick(View v){
                    TextView text = (TextView)findViewById(R.id.buckysText);
                    text.setText("Good Job");
                }
            }
        );
    }
}
