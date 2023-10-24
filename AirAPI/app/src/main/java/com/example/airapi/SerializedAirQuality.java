
//Tạo lớp AirQualityResponse để đại diện cho dữ liệu chất lượng không khí trả
//về từ API. Pha đảm bảo ràằng lớp này phản ánh được cấu trúc dữ liệu JSON
//bạn đã cung cấp. Ví dụ:
//Các class con của Serialized bao gồm:
//AirQualityData
//Main
//Cooridinates
//Components


package com.example.airapi;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.SerializedIr;
import retrofit2.http.Query;

public class SerializedAirQuality {
    @SerializedName ("coord")
    private Coordinates coordinates;
    public Coordinates getCoordinates(){

        return coordinates;
    }
    @SerializedName("list")
    private List<AirQualityData> airQualityList;

    public List<AirQualityData> getAirQualityList() {

        return airQualityList;
    }


}


