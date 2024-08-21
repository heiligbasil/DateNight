package com.heiligbasil.datenight.data.entities


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Queries(
    @SerialName("nextPage")
    val nextPage: List<NextPage?>?,
    @SerialName("request")
    val request: List<Request?>?
)
