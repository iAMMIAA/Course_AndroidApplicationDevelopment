package com.example.aninterface;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class act_uiautocomplete extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uiautocomplete);

        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.autocomplete_country);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>( this, R.layout.)



    }
}
