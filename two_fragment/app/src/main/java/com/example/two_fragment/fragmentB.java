package com.example.two_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class fragmentB extends Fragment {
    private TextView contentTextView;
    private String selectedItem;
    private boolean shouldUpdateText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        contentTextView = view.findViewById(R.id.textView);

        if (savedInstanceState != null) {
            selectedItem = savedInstanceState.getString("selectedItem");
        }
        shouldUpdateText = true;
        return view;
    }
    public void updateContent(String content) {
        if (contentTextView != null) {
            contentTextView.setText(content);
        }
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // Lưu trạng thái của selectedItem khi xoay màn hình
        String selectedItem = contentTextView.getText().toString();
        outState.putString("selectedItem", selectedItem);
    }
    @Override
    public void onResume() {
        super.onResume();
        if (shouldUpdateText) {
            displayItem(selectedItem);
            shouldUpdateText = false;
        }
    }
    public void displayItem(String item) {
        selectedItem = item;
        // Kiểm tra nếu item là null
        if (item == null) {
            return;
        }
        // Gán nội dung tương ứng với từng item
        String content = "";
        if (item.equals("Item 1")) {
            content = "A";
        } else if (item.equals("Item 2")) {
            content = "B";
        } else if (item.equals("Item 3")) {
            content = "C";
        }

        if (contentTextView != null) {
            contentTextView.setText(content);
        }
    }
}
