package com.example.fragment_layout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements fragmentA.OnItemSelectedListener {


    private fragmentA fragmentA;
    private fragmentB fragmentB;
    private String selectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentA = new fragmentA();
        fragmentB = new fragmentB();

        // Kiểm tra xem Activity đã được khởi tạo lại sau khi xoay màn hình hay chưa
        if (savedInstanceState == null) {
            // Khi Activity mới được khởi tạo, hiển thị cả hai Fragment
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragment_container_a, fragmentA);
            fragmentTransaction.add(R.id.fragment_container_b, fragmentB);
            fragmentTransaction.commit();
        } else {
            // Khi Activity được khởi tạo lại sau khi xoay màn hình, khôi phục trạng thái của FragmentA và FragmentB
            selectedItem = savedInstanceState.getString("selectedItem");
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragment_container_a, fragmentA);
            fragmentTransaction.add(R.id.fragment_container_b, fragmentB);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onItemSelected(String item) {
        // Khi một mục được chọn trong Fragment A, cập nhật nội dung của Fragment B
        selectedItem = item;
        fragmentB.updateContent(item);

        // Thực hiện FragmentTransaction với back stack
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack(null); // Thêm Fragment vào back stack
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        // Kiểm tra số lượng Fragment trong back stack
        int backStackEntryCount = getSupportFragmentManager().getBackStackEntryCount();
        if (backStackEntryCount > 0) {
            // Nếu có Fragment trong back stack, pop Fragment cuối cùng ra khỏi back stack
            getSupportFragmentManager().popBackStack();
        } else {
            // Nếu không có Fragment trong back stack, thực hiện hành động mặc định (thoát ứng dụng, chẳng hạn)
            super.onBackPressed();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Lưu trạng thái của selectedItem khi xoay màn hình
        outState.putString("selectedItem", selectedItem);
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Kiểm tra xem màn hình đã xoay ngang hay chưa
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // Xoay ngang: Ẩn FragmentA, chỉ hiển thị FragmentB
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.hide(fragmentA);
            fragmentTransaction.show(fragmentB);
            fragmentTransaction.commit();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            // Xoay dọc: Hiển thị cả hai Fragment
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.show(fragmentA);
            fragmentTransaction.show(fragmentB);
            fragmentTransaction.commit();
        }
    }

}