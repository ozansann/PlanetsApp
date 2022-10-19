package com.od.planetsapp.ViewModel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.od.planetsapp.Models.PlanetModel;
import com.od.planetsapp.Repository.PlanetRepository;
import java.util.ArrayList;

public class PlanetViewModel extends AndroidViewModel {
    private PlanetRepository planetResponse;
    private LiveData<ArrayList<PlanetModel>> planetResponseLiveData;

    public PlanetViewModel(@NonNull Application application) {
        super(application);
        planetResponse = new PlanetRepository();
        this.planetResponseLiveData = planetResponse.getPlanetList();
    }

    public LiveData<ArrayList<PlanetModel>> getPlanetListResponseLiveData() {
        return planetResponseLiveData;
    }
}
