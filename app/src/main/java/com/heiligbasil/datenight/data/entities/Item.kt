package com.heiligbasil.datenight.data.entities


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Item(
    @SerialName("displayLink")
    val displayLink: String?,
    @SerialName("formattedUrl")
    val formattedUrl: String?,
    @SerialName("htmlFormattedUrl")
    val htmlFormattedUrl: String?,
    @SerialName("htmlSnippet")
    val htmlSnippet: String?,
    @SerialName("htmlTitle")
    val htmlTitle: String?,
    @SerialName("kind")
    val kind: String?,
    @SerialName("link")
    val link: String?,
    @SerialName("pagemap")
    val pagemap: Pagemap?,
    @SerialName("snippet")
    val snippet: String?,
    @SerialName("title")
    val title: String?
)
