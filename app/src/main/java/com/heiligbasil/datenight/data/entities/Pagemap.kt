package com.heiligbasil.datenight.data.entities


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Pagemap(
    @SerialName("cse_image")
    val cseImage: List<CseImage?>?,
    @SerialName("cse_thumbnail")
    val cseThumbnail: List<CseThumbnail?>?,
    @SerialName("document")
    val document: List<Document?>?,
    @SerialName("hatomfeed")
    val hatomFeed: List<HatomFeed?>?,
    @SerialName("hcard")
    val hcard: List<Hcard?>?,
    @SerialName("listitem")
    val listItem: List<ListItem?>?,
    @SerialName("metatags")
    val metaTags: List<MetaTag?>?,
    @SerialName("speakablespecification")
    val speakableSpecification: List<SpeakableSpecification?>?,
    @SerialName("thumbnail")
    val thumbnail: List<Thumbnail?>?
)
