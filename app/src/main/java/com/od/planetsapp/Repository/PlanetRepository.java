package com.od.planetsapp.Repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.od.planetsapp.Constants.AppConstants;
import com.od.planetsapp.Models.PlanetModel;
import com.od.planetsapp.Retrofit.ApiRequest;
import com.od.planetsapp.Retrofit.RetrofitRequest;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlanetRepository {
    private final ApiRequest request;
    public PlanetRepository() {
        request = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }
    public LiveData<ArrayList<PlanetModel>> getPlanetList() {
        final MutableLiveData<ArrayList<PlanetModel>> data = new MutableLiveData<>();
        request.getPlanetList(AppConstants.API_KEY,AppConstants.API_HOST)
                .enqueue(new Callback<ArrayList<PlanetModel>>() {
                    @Override
                    public void onResponse(@NonNull Call<ArrayList<PlanetModel>> call,
                                           @NonNull Response<ArrayList<PlanetModel>> response) {
                        if (response.body() != null) {
                            data.setValue(response.body());
                        } else{
                            data.setValue(null);
                        }
                    }
                    @Override
                    public void onFailure(@NonNull Call<ArrayList<PlanetModel>> call, @NonNull Throwable t) {
                        data.setValue(null);

                    }
                });
        return data;
    }
    public LiveData<PlanetModel> getPlanetById(String Id) {
        final MutableLiveData<PlanetModel> data = new MutableLiveData<>();
        request.getPlanetById(AppConstants.API_KEY,AppConstants.API_HOST,Id)
                .enqueue(new Callback<PlanetModel>() {
                    @Override
                    public void onResponse(@NonNull Call<PlanetModel> call,
                                           @NonNull Response<PlanetModel> response) {
                        if (response.body() != null) {
                            data.setValue(response.body());
                        } else{
                            data.setValue(null);
                        }
                    }
                    @Override
                    public void onFailure(@NonNull Call<PlanetModel> call, @NonNull Throwable t) {
                        data.setValue(null);

                    }
                });
        return data;
    }
}
