package com.heiligbasil.datenight.data.entities


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CseImage(
    @SerialName("src")
    val src: String?
)
