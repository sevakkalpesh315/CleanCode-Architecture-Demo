package com.example.data.entity;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by kalpesh on 05/09/2017.
 */

/**
 *  Data layer- Step 1
 *
 *  Create entity class
 */
public class TownshipEntity extends RealmObject{

    @PrimaryKey
    private int id;
    private String name;
    private String imageUrl;
    private String lastUpdated;

    public TownshipEntity(){

    }

    public TownshipEntity(int id, String name, String imageUrl, String lastUpdated) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.lastUpdated = lastUpdated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
