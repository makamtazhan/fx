package com.example.fx

import com.google.gson.annotations.SerializedName

data class Country (
    @SerializedName("Country")
    var country: String,
    @SerializedName("Slug")
    var slug: String,
    @SerializedName("ISO2")
    var iso2: String
)