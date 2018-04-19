package com.mr_abdali.progressbar;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    //
    ProgressBar progressBar;
    Handler handler;
    Runnable runnable;
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // progress bar reference
        progressBar = (ProgressBar) findViewById(R.id.progressBar_id);
        progressBar.setVisibility(View.VISIBLE);

        // Handler
        handler = new Handler();

        // Runnable
        runnable = new Runnable() {
            @Override
            public void run() {
                //
                timer.cancel();
                progressBar.setVisibility(View.GONE);
            }
        };

        // Timer
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // code
                handler.post(runnable);
            }
        },8000,1000);
    }
}
