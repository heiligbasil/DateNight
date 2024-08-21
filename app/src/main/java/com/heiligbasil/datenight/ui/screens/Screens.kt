package com.heiligbasil.datenight.ui.screens

import com.heiligbasil.datenight.ui.entities.SearchResult
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
