package com.example.nextfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private boolean display_frm = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void openFragment(View view){
        FragmentManager frm_manager = getSupportFragmentManager();
        FragmentTransaction frm_trans = frm_manager.beginTransaction();

        if(display_frm){
            fragment fragment  = (fragment) frm_manager.findFragmentById(R.id.fragment_container);
            frm_trans.remove(fragment );
            display_frm = false;
        } else {
            fragment frm = new fragment();
            frm_trans.add(R.id.fragment_container, frm);
            display_frm = true;
        }
        frm_trans.commit();
    }
}