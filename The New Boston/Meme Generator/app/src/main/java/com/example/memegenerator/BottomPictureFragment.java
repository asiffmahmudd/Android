package com.example.memegenerator;

import android.os.Bundle;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.widget.TextView;

public class BottomPictureFragment extends Fragment {

    private static TextView txtTop;
    private static TextView txtBottom;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_picture_fragment, container, false);
        txtTop = (TextView)view.findViewById(R.id.topMemeText);
        txtBottom = (TextView)view.findViewById(R.id.bottomMemeText);
        return view;
    }

    public void setMemeText(String top, String bottom){
        txtTop.setText(top);
        txtBottom.setText(bottom);
    }
}
