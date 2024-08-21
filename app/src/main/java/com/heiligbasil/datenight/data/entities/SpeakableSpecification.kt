package com.heiligbasil.datenight.data.entities


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SpeakableSpecification(
    @SerialName("cssselector")
    val cssSelector: String?
)
