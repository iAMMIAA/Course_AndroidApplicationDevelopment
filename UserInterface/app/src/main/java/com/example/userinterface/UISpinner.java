package com.example.userinterface;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class UISpinner extends AppCompatActivity {
    private String[] categories = {"The thao", "Am nhac", "Du lich"};
    public Spinner spinner ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_spinner);
        spinner = findViewById(R.id.spinner);
        //Create an Adapter that holds a list of colors
        //Tạo ArrayAdapter và gán cho Spinner:
        //Tạo một ArrayAdapter để liên kết danh sách dữ liệu với Spinner và gán ArrayAdapter cho Spinner. Ví dụ:
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.custom_spinner_dropdown, categories);
        adapter.setDropDownViewResource(R.layout.custom_spinner_dropdown);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedCategory = categories[position];
                // Xử lý khi một mục được chọn
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Xử lý khi không có mục nào được chọn
            }
        });
    }

}
