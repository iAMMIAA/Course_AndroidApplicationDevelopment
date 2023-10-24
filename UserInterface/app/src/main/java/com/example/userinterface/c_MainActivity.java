package com.example.userinterface;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class c_MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private c_HorizontalAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c_recyclerview);

        recyclerView = findViewById(R.id.c_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        List<c_YourDataModel> dataList = new ArrayList<>();
        dataList.add(new c_YourDataModel("Item 1", "https://hapotravel.com/wp-content/uploads/2023/04/suu-tam-25-hinh-anh-anime-nu-xinh-dep-va-dang-yeu_2.jpg"));
        dataList.add(new c_YourDataModel("Item 2", "https://i0.wp.com/thatnhucuocsong.com.vn/wp-content/uploads/2022/09/anh-anime-nam.jpg?ssl\\u003d1"));
        dataList.add(new c_YourDataModel("Item 3", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQFPdVPi3VkSHj8nd7ARMxDXckXi_Gv-iioWw&usqp=CAU"));

        adapter = new c_HorizontalAdapter(this, dataList);
        recyclerView.setAdapter(adapter);
    }
}
