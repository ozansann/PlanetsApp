package com.od.planetsapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class PlanetModel implements Serializable {
    @SerializedName("basicDetails")
    @Expose
    private ArrayList<BasicDetailModel> basicDetails;
    @SerializedName("imgSrc")
    @Expose
    private ArrayList<ImageSourceModel> imgSrc;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("planetOrder")
    @Expose
    private String planetOrder;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("wikiLink")
    @Expose
    private String wikiLink;

    public ArrayList<BasicDetailModel> getBasicDetails() {
        return basicDetails;
    }

    public void setBasicDetails(ArrayList<BasicDetailModel> basicDetails) {
        this.basicDetails = basicDetails;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlanetOrder() {
        return planetOrder;
    }

    public void setPlanetOrder(String planetOrder) {
        this.planetOrder = planetOrder;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getWikiLink() {
        return wikiLink;
    }

    public void setWikiLink(String wikiLink) {
        this.wikiLink = wikiLink;
    }

    public ArrayList<ImageSourceModel> getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(ArrayList<ImageSourceModel> imgSrc) {
        this.imgSrc = imgSrc;
    }
}
