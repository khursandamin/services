package com.example.myapplication.Fragments;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class PageFragment3 extends Fragment {
   private Button btn1;
    Button btn2;
    Switch sw;

    private static final String TAG = "PageFragment3";

    private Handler mainHandler = new Handler();
private volatile boolean stopThread=false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
     ViewGroup rootview=(ViewGroup)inflater.inflate(R.layout.page_3,container,false);

     return rootview;
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn1 = view.findViewById(R.id.button2);
    }

    public void startThread(View view) {
        stopThread=false;

      ExampleRunnable runnable=new ExampleRunnable(10);
      new Thread(runnable).start();
      /*
new Thread(new Runnable() {
    @Override
    public void run() {

    }
}).start();*/
    }
    public void stopThread(View view){
stopThread=true;
        }
        class ExampleThread extends Thread{
        int seconds;
        ExampleThread(int seconds){
            this.seconds=seconds;
        }

            @Override
            public void run() {
                for (int i = 0; i < seconds; i++) {
                    if (stopThread)
                        return;
                    if (i==5){

                     /*

                        Handler threadHandler=new Handler(Looper.getMainLooper());
                        threadHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                btn1.setText("50%");
                            }

                        });


                        btn1.post(new Runnable() {
                            @Override
                            public void run() {
                                btn1.setText("50%");
                            }
                        });*/


                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                btn1.setText("50%");
                            }
                        });

                    }
                    Log.d(TAG, "startThread: " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        class ExampleRunnable implements Runnable{
        int seconds;
        ExampleRunnable(int seconds){
            this.seconds=seconds;
        }
            @Override
            public void run() {

                    for (int i = 0; i < seconds; i++) {
                        Log.d(TAG, "startThread: " + i);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }


            }


        }







