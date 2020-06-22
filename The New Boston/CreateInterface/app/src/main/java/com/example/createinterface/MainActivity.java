package com.example.createinterface;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.graphics.Color;
import android.content.res.Resources;
import android.util.TypedValue;

import java.lang.reflect.Type;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        RelativeLayout layout = new RelativeLayout(this);
        layout.setBackgroundColor(Color.GRAY);

        RelativeLayout.LayoutParams buttonDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        RelativeLayout.LayoutParams userDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        Button button = new Button(this);
        button.setId(1);
        EditText userName = new EditText(this);
        userName.setId(2);

        userDetails.addRule(RelativeLayout.ABOVE, button.getId());
        userDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        userDetails.setMargins(0,0,0,50);

        buttonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonDetails.addRule(RelativeLayout.CENTER_VERTICAL);
        button.setBackgroundColor(Color.CYAN);
        button.setText("Click Me");

        Resources r = getResources();
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,300, r.getDisplayMetrics());
        userName.setWidth(px);

        layout.addView(userName,userDetails);
        layout.addView(button,buttonDetails);
        setContentView(layout);
    }
}
