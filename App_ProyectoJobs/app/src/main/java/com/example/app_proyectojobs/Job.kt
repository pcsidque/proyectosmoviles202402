package com.example.app_proyectojobs
import com.google.gson.annotations.SerializedName

class Job (
    @SerializedName("title")
    val title: String,

    @SerializedName("company")
    val company: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("company_logo")
    val companyLogo: String
)