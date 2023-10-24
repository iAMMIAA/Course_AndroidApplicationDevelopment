package com.example.myapplicationl;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView result;
    private Button random;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("Act: ", "onCreate");
        result = findViewById(R.id.tv_result);
        random = findViewById(R.id.btn_random);

        random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    // Tạo một số ngẫu nhiên và hiển thị lên TextView
                    Random random = new Random();
                    int randomNumber = random.nextInt(100) + 1; // Tạo số ngẫu nhiên từ 1 đến 100
                    result.setText(" " + randomNumber);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.v("Act: ", "onStart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.v("Act: ", "onResume");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.v("Act: ", "onPause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.v("Act: ", "onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("Act: ", "onDestroy");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("Act: ", "onRestart");
    }
}