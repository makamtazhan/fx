package com.example.fx

import com.google.gson.annotations.SerializedName

data class ApiResponse (
    @SerializedName("ID") var id: String,
    @SerializedName("Country") var Country: String,
    @SerializedName("CountryCode") var CountryCode: String,
    @SerializedName("Province") var Province: String,
    @SerializedName("City") var City: String,
    @SerializedName("CityCode") var CityCode: String,
    @SerializedName("Lat") var Lat: String,
    @SerializedName("Lon") var Lon: String,
    @SerializedName("Confirned") var Confirmed: Int,
    @SerializedName("Deaths") var Deaths: Int,
    @SerializedName("Recovered") var Recovered: Int,
    @SerializedName("Active") var Active: Int,
    @SerializedName("Date") var Date: String
)