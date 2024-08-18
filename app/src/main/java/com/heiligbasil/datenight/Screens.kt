package com.heiligbasil.datenight

import kotlinx.serialization.Serializable

@Serializable
sealed class Screens {
    @Serializable
    data object Home : Screens()

    @Serializable
    data object Results : Screens()

    @Serializable
    data class Details(val selectedDetails: SearchResult) : Screens()
}
