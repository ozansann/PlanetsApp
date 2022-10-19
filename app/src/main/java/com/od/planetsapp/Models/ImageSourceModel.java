package com.od.planetsapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImageSourceModel {
    @SerializedName("img")
    @Expose
    private String img;
    @SerializedName("imgDescription")
    @Expose
    private String imgDescription;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImgDescription() {
        return imgDescription;
    }

    public void setImgDescription(String imgDescription) {
        this.imgDescription = imgDescription;
    }
}
