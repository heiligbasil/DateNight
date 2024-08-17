package com.heiligbasil.datenight

import kotlinx.serialization.Serializable

sealed class Screens {
    @Serializable
    object Home

    @Serializable
    object Results

    @Serializable
    object Details
}
