package com.heiligbasil.datenight.data

import com.heiligbasil.datenight.data.entities.CustomSearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CustomSearchService {
    @GET("customsearch/v1")
    suspend fun fetchCustomSearchResults(
        @Query("key") apiKey: String,
        @Query("cx") searchEngineId: String,
        @Query("q") searchQuery: String
    ): Response<CustomSearchResponse>
}
