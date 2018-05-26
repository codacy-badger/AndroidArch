package com.noisyninja.androidlistpoc.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Name(@field:SerializedName("first")
           @field:Expose
           var first: String?) {

    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("last")
    @Expose
    var last: String? = null

}
