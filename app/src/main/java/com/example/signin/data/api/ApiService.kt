package com.example.signin.data.api

import com.example.signin.data.dto.DtoPost
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @FormUrlEncoded
    @POST("do/login")
    suspend fun doLogin(): String

    @GET("/posts")
    suspend fun getPosts(): List<DtoPost>

}