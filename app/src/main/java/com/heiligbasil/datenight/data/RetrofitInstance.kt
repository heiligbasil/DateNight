package com.heiligbasil.datenight.data

import com.heiligbasil.datenight.BuildConfig
import com.heiligbasil.datenight.Utils.jsonStringWithNulls
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

object RetrofitInstance {
    private const val BASE_URL = "https://www.googleapis.com/"
    private const val APPLICATION_JSON = "application/json"
    const val API_KEY = BuildConfig.API_KEY
    const val SEARCH_ENGINE_ID = BuildConfig.SEARCH_ENGINE_ID

    val api: CustomSearchService by lazy {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)
        val cf = jsonStringWithNulls.asConverterFactory(contentType = APPLICATION_JSON.toMediaType())
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(cf)
            .client(httpClient.build())
            .build()
        retrofit.create(CustomSearchService::class.java)
    }
}
