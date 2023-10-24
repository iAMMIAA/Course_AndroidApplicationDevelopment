package com.example.fragment_layout;

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
        shouldUpdateText = true; // Khi được tạo lại, đặt shouldUpdateText thành true để cập nhật nội dung khi onResume() được gọi
        return view;
    }
    public void updateContent(String content) {
        // Cập nhật nội dung của Fragment B dựa trên mục được chọn từ Fragment A
        if (contentTextView != null) {
            contentTextView.setText(content);
        }

        // Xóa trạng thái trước đó khi có item mới được chọn
//        selectedItem = null;

    }
    //ghi đè phương thức onSaveInstanceState() để lưu trạng thái của FragmentB:
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
            // Đánh dấu rằng nội dung đã được cập nhật và không cần phải cập nhật lại khi onResume() được gọi lần sau
        }
    }
    public void displayItem(String item) {
        selectedItem = item;
        if (contentTextView != null) {
            contentTextView.setText(item);
        }
    }



    /////////////////////////////////
//
//    private boolean isFirstItemClick = true;
//    public boolean getIsFirstItemClick()
//    {
//        return true;
//    }
//
//    public void resetContent() {
//        if (contentTextView != null) {
//            contentTextView.setText("");
//        }
//    }
//
//    public void setFirstItemClick(boolean isFirstItemClick) {
//        this.isFirstItemClick = isFirstItemClick;
//    }
}
