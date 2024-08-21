package com.heiligbasil.datenight.data

import com.heiligbasil.datenight.data.entities.CustomSearchResponse

interface CustomSearchRepository {
    suspend fun getCustomSearchResults(searchQuery: String): NetworkResult<CustomSearchResponse>
}
