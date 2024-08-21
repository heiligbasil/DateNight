package com.heiligbasil.datenight.data.entities


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Hcard(
    @SerialName("fn")
    val fn: String?,
    @SerialName("url")
    val url: String?,
    @SerialName("url_text")
    val urlText: String?
)
