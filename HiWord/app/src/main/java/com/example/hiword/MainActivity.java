package com.example.hiword;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.animation.Animator;
import android.animation.ObjectAnimator;

public class MainActivity extends AppCompatActivity {

    private Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("Act: ", "onCreate");

        btn = findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                render();
            }
        });
    }
    public void render(){
        Intent render = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(render);
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

