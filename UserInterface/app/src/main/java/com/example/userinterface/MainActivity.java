package com.example.userinterface;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

////////////////////////////////////////////////////////////////////////////////
//    private String[] colors = {"Red", "Green", "Orange"};
//    private ListView colorListView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        colorListView = findViewById(R.id.colorListView);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.color_item, R.id.colorItems, colors);
//        colorListView.setAdapter((adapter));
//    }
//////////////////////////////////////////////////////////////////////////////////
    private ColorItem[] colorItems = {
            new ColorItem("Đỏ", "#FF0000"),
            new ColorItem("Cam", "#FFA500"),
            new ColorItem("Vàng", "#FFFF00")
    };
    private ListView colorListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorListView = findViewById(R.id.colorListView);
        ArrayAdapter<ColorItem> adapter = new ArrayAdapter<ColorItem>(this, R.layout.color_item, R.id.colorItems, colorItems){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView textView = view.findViewById(R.id.colorItems);
                textView.setBackgroundColor(Color.parseColor(colorItems[position].getBackgroundColor()));
                return view;
            }
        };
        colorListView.setAdapter(adapter);

        colorListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ColorItem selectedColor = colorItems[position];
                String message = "Bạn đã chọn màu: " + selectedColor.getColorName();
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });

//        colorListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                ColorItem selectedColor = colorItems[position];
//                String message = "Ban da chon mau: " + selectedColor.getColorName();
//                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
//                clickItem(position);
//            }
//        });
    }

    //Cach 2:
    // Phương thức clickItem() để hiển thị thông báo Toast khi một mục được chọn
//    private void clickItem(int position) {
//        ColorItem selectedColor = colorItems[position];
//        String message = "Bạn đã chọn màu: " + selectedColor.getColorName();
//        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
//    }
}