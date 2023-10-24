package com.example.myapplicationl;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class rollthedice extends AppCompatActivity {

    private ImageView diceImageView;
    private Button rollButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rollthedice);

        diceImageView = findViewById(R.id.img_dice);
        rollButton = findViewById(R.id.btn_roll);

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Tạo một số ngẫu nhiên từ 1 đến 6
                Random random = new Random();
                int randomNumber = random.nextInt(6) + 1; // Số từ 1 đến 6

                // Hiển thị hình ảnh tương ứng với số xúc xắc
                int drawableResource = getResources().getIdentifier("dice_" + randomNumber, "drawable", getPackageName());
                diceImageView.setImageResource(drawableResource);
            }
        });
    }
}