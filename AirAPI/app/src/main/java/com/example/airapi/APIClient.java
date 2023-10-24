package com.example.airapi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//Create a class to configure and create Retrofit Client
//APIClient giống như axios hồi làm Web
public class APIClient {
    private static Retrofit retrofit = null;
    private static String BASE_URL = "https://api.openweathermap.org/";

    public static Retrofit getClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}

