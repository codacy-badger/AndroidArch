package com.noisyninja.androidlistpoc.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MeResponse {

    @SerializedName("results")
    @Expose
    private List<Me> people = null;
    @SerializedName("info")
    @Expose
    private Info info;

    public List<Me> getPeople() {
        return people;
    }

    public void setPeople(List<Me> people) {
        this.people = people;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

}
