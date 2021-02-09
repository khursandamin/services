package com.example.myapplication.Fragments;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.MyForegroundService;
import com.example.myapplication.R;

public class PageFragment2 extends Fragment {
    private Button btn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
     ViewGroup rootview=(ViewGroup)inflater.inflate(R.layout.page_2,container,false);



     Intent intent= new Intent(getActivity(),MyForegroundService.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
           getActivity(). startForegroundService(new Intent(getActivity(),MyForegroundService.class));
        }
        else {
getActivity().startService(new Intent(getActivity(),MyForegroundService.class));
        }
     return rootview;





    }


}
