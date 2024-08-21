package com.heiligbasil.datenight.data.entities


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Document(
    @SerialName("author")
    val author: String?,
    @SerialName("date")
    val date: String?,
    @SerialName("date-day")
    val dateDay: String?,
    @SerialName("date-month")
    val dateMonth: String?,
    @SerialName("date-year")
    val dateYear: String?,
    @SerialName("description")
    val description: String?,
    @SerialName("slug")
    val slug: String?,
    @SerialName("title")
    val title: String?,
    @SerialName("topic")
    val topic: String?
)
