package com.heiligbasil.datenight.data.entities


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ListItem(
    @SerialName("item")
    val item: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("position")
    val position: String?
)
