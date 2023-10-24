package com.example.userinterface;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class c_HorizontalAdapter extends RecyclerView.Adapter<c_HorizontalAdapter.ViewHolder> {
    private List<c_YourDataModel> dataList;
    private Context context;
    private int[] itemColors; // Mảng chứa màu nền cho mỗi item

    public c_HorizontalAdapter(Context context, List<c_YourDataModel> dataList) {
        this.context = context;
        this.dataList = dataList;

        // Khởi tạo mảng màu nền với các giá trị tùy chọn
        itemColors = new int[]{
                Color.RED,
                Color.GREEN,
                Color.BLUE,
                Color.YELLOW
        };
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.c_item_horizontal, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        c_YourDataModel data = dataList.get(position);
        holder.textView.setText(data.getTitle());
        Glide.with(context).load(data.getImageUrl()).into(holder.imageView);

        // Thiết lập màu nền cho item dựa trên vị trí
        int color = itemColors[position % itemColors.length];
        holder.colorView.setBackgroundColor(color);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        View colorView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
            colorView = itemView.findViewById(R.id.colorView);
        }
    }
}
