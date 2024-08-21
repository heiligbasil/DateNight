package com.heiligbasil.datenight.data.entities


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchInformation(
    @SerialName("formattedSearchTime")
    val formattedSearchTime: String?,
    @SerialName("formattedTotalResults")
    val formattedTotalResults: String?,
    @SerialName("searchTime")
    val searchTime: Double?,
    @SerialName("totalResults")
    val totalResults: String?
)
