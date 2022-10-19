package com.od.planetsapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BasicDetailModel {
    @SerializedName("mass")
    @Expose
    private String mass;
    @SerializedName("volume")
    @Expose
    private String volume;

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }
}
