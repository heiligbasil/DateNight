package com.heiligbasil.datenight.data.entities


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NextPage(
    @SerialName("count")
    val count: Int?,
    @SerialName("cx")
    val cx: String?,
    @SerialName("inputEncoding")
    val inputEncoding: String?,
    @SerialName("outputEncoding")
    val outputEncoding: String?,
    @SerialName("safe")
    val safe: String?,
    @SerialName("searchTerms")
    val searchTerms: String?,
    @SerialName("startIndex")
    val startIndex: Int?,
    @SerialName("title")
    val title: String?,
    @SerialName("totalResults")
    val totalResults: String?
)
