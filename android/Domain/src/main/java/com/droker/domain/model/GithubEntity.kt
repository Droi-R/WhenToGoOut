package com.droker.domain.model

import com.google.gson.annotations.SerializedName


data class GithubEntity(
    @SerializedName("name")
    val name: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("created_at")
    val date: String,
    @SerializedName("html_url")
    val url: String
)
