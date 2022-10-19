package com.od.planetsapp.Retrofit;

import static com.od.planetsapp.Constants.AppConstants.*;

import com.od.planetsapp.Constants.AppConstants;
import com.od.planetsapp.Models.PlanetModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface ApiRequest {
    @GET("planet/list")
    Call<ArrayList<PlanetModel>> getPlanetList(@Header("X-RapidAPI-Key") String apiKey,
                                               @Header("X-RapidAPI-Host") String apiHost);
    @GET("planet/")
    Call<PlanetModel> getPlanetById(@Header("X-RapidAPI-Key") String apiKey,
                                    @Header("X-RapidAPI-Host") String apiHost,
                                    @Query("id") String id);
}
