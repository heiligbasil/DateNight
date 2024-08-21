package com.heiligbasil.datenight.data.entities


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CustomSearchResponse(
    @SerialName("context")
    val context: Context?,
    @SerialName("items")
    val items: List<Item?>?,
    @SerialName("kind")
    val kind: String?,
    @SerialName("queries")
    val queries: Queries?,
    @SerialName("searchInformation")
    val searchInformation: SearchInformation?,
    @SerialName("url")
    val url: Url?
) {
    companion object {
        fun returnClassWithJustNulls() =
            CustomSearchResponse(
                context = null,
                items = null,
                kind = null,
                queries = null,
                searchInformation = null,
                url = null
            )
    }
}
