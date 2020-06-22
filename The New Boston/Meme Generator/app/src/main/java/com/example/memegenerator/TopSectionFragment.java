package com.example.memegenerator;

import android.os.Bundle;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;

public class TopSectionFragment  extends  Fragment{
    private static EditText etTopTextInput;
    private static EditText etBottomTextInput;

    TopSectionListener activityCommander;

    public interface TopSectionListener{
        public void createMeme(String top, String bottom);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            activityCommander = (TopSectionListener) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_section_fragment, container, false);

        etTopTextInput = (EditText)view. findViewById(R.id.topTextInput);
        etBottomTextInput = (EditText)view.findViewById(R.id.bottomTextInput);

        final Button button = (Button)view.findViewById(R.id.button);

        button.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        buttonClicked(v);
                    }
                }
        );

        return view;
    }

    //Calls this when button clicked
    public void buttonClicked(View view){
        activityCommander.createMeme(etTopTextInput.getText().toString(), etBottomTextInput.getText().toString());
    }
}
