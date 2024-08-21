package com.heiligbasil.datenight.data

import com.heiligbasil.datenight.data.entities.CustomSearchResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CustomSearchRepositoryImpl(
    private val customSearchService: CustomSearchService
) : CustomSearchRepository {
    override suspend fun getCustomSearchResults(searchQuery: String): NetworkResult<CustomSearchResponse> {
        return withContext(Dispatchers.IO) {
            try {
                val response = customSearchService.fetchCustomSearchResults(
                    searchQuery = searchQuery,
                    apiKey = RetrofitInstance.API_KEY,
                    searchEngineId = RetrofitInstance.SEARCH_ENGINE_ID
                )
                if (response.isSuccessful) {
                    NetworkResult.Success(
                        data = response.body() ?: CustomSearchResponse.returnClassWithJustNulls()
                    )
                } else {
                    NetworkResult.Error(error = response.errorBody().toString())
                }
            } catch (e: Exception) {
                NetworkResult.Error(e.message ?: "Unknown error in getCustomSearchResults()")
            }
        }
    }
}
