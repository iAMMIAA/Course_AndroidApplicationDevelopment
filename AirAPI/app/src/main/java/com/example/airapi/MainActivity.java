package com.example.airapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String API_KEY = "18b34d9fc44c1ba20f3d185a19145cbc";
    public TextView contentAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        double latitude = 50;
        double longitude = 50;
        contentAPI = findViewById(R.id.contentAPI);

        //Thực hiện gọi API
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<SerializedAirQuality> call = apiInterface.getAirQuality(latitude, longitude, API_KEY);
        call.enqueue(new Callback<SerializedAirQuality>() {
            @Override
            public void onResponse(Call<SerializedAirQuality> call, Response<SerializedAirQuality> response) {
                if(response.isSuccessful())
                {
                    SerializedAirQuality airQualityResponse = response.body();
                    Main mainData = airQualityResponse.getAirQualityList().get(0).getMain();
                    Components componentsData = airQualityResponse.getAirQualityList().get(0).getComponents();
                    double latitude = mainData.getLat();
                    double o3 = componentsData.getO3();
                    contentAPI.setText("Lat: " + latitude + " |O3: " + o3);
                    Log.v("API CALL: ", "Call API successful: " + " Lat: " + latitude + " |O3: " + o3);
                } else {
                    //Xử lý lỗi khi gọi API
                    Log.e("API CALL: ", "API call failed" + response.code());
                }
            }

            @Override
            public void onFailure(Call<SerializedAirQuality> call, Throwable t) {
                //Xử lý lỗi khi gọi API
                Log.e("API CALL: ", "API Call failed: " + t.getMessage());
            }
        });


    }
}