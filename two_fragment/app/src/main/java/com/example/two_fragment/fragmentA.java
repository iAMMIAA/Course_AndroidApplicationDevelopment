package com.example.two_fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class fragmentA extends Fragment {

    private ListView listView;
    private OnItemSelectedListener listener;

    public interface OnItemSelectedListener {
        void onItemSelected(String item);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnItemSelectedListener) {
            listener = (OnItemSelectedListener) context;
        } else {
            throw new ClassCastException(context.toString() + " must implement FragmentA.OnItemSelectedListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);

        listView = view.findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireActivity(), android.R.layout.simple_list_item_1, getData());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String selectedItem = adapter.getItem(position);
                listener.onItemSelected(selectedItem);
            }
        });
        return view;
    }

    private String[] getData() {
        return new String[]{"Item 1", "Item 2", "Item 3"};
    }


//////////////////////////////////////////////
//    public void onItemSelected(String item) {
//        fragmentB fragmentB = (fragmentB) requireActivity().getSupportFragmentManager().findFragmentById(R.id.fragment_container_a);
//
//        if (fragmentB != null) {
//            if (fragmentB.getIsFirstItemClick()) {
//                fragmentB.resetContent();
//                fragmentB.setFirstItemClick(false);
//            }
//            fragmentB.updateContent(item);
//        } else {
//            fragmentB = new fragmentB();
//            Bundle args = new Bundle();
//            args.putString("selectedItem", item);
//            fragmentB.setArguments(args);
//
//            FragmentTransaction fragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
////            fragmentTransaction.replace(R.id.fragmentContainer, fragmentB);
//            fragmentTransaction.addToBackStack(null);
//            fragmentTransaction.commit();
//        }
//    }
}


//
//    @Override
//    public void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//        // Lưu trạng thái của FragmentA vào Bundle
//        outState.putInt("selectedPosition", selectedPosition);
//    }



//xu ly xoay
//    Trong phương thức onItemSelected(),
//    chúng ta trước tiên kiểm tra xem FragmentB
//    đã được tạo hay chưa bằng cách tìm fragment với
//    ID R.id.fragmentB. Nếu fragment đã tồn tại, chúng ta
//        gọi updateContent() trên fragmentB để cập nhật nội dung.
//        Nếu fragment chưa tồn tại, chúng ta tạo một instance mới
//        của FragmentB, đặt tham số selectedItem vào bundle và thực
//        hiện việc thay thế FragmentA bằng FragmentB.
//
//        Bằng cách này, khi xoay màn hình và lần nhấn đầu tiên trên
//        item, các nội dung đã hiển thị trên FragmentB sẽ bị xóa và
//        được thay thế bằng nội dung mới.