package com.example.myapplication.Fragments;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.MBackgroundService;
import com.example.myapplication.R;

import java.util.Objects;


public class PageFragment1 extends Fragment {
    private Button btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.page_1, container, false);

        // getActivity().startService(new Intent(getActivity(), IntentService.class));
        assert container != null;
        btn = (Button) rootview.findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "I'm a fragment", Toast.LENGTH_SHORT).show();
                Objects.requireNonNull(getActivity()).startService(new Intent(getActivity(), MBackgroundService.class));
            }
        });
        return rootview;
    }

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleService();
//            }
//
//            public void handleService() {
//                Intent intent = new Intent(getActivity(), IntentService.class);
//                Objects.requireNonNull(getActivity()).startService(intent);
//                Objects.requireNonNull(getActivity()).startService(new Intent(getActivity(), IntentService.class));
//
//            }
//        });
//    }
}

