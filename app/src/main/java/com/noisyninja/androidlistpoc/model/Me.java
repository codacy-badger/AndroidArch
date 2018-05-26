package com.noisyninja.androidlistpoc.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@Entity(tableName = "me")
public class Me {

    @PrimaryKey(autoGenerate = true)
    @Expose
    @ColumnInfo(name = "userId")
    private int userId;

    @NonNull
    @TypeConverters(DataConverter.class)
    @SerializedName("name")
    @Expose
    private Name name;
    @TypeConverters(DataConverter.class)
    @SerializedName("picture")
    @Expose
    private Picture picture;
    @Expose
    @ColumnInfo(name = "page")
    private int page;

    public Me(@NonNull Name name) {
        this.name = name;
    }

    @NonNull
    public Name getName() {
        return name;
    }

    public void setName(@NonNull Name name) {
        this.name = name;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
