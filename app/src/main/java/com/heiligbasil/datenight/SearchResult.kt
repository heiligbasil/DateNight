package com.heiligbasil.datenight

import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavType
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
@Parcelize
data class SearchResult(val title: String, val description: String) : Parcelable

val SearchResultNavType = object : NavType<SearchResult>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): SearchResult? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            bundle.getParcelable(key, SearchResult::class.java) as SearchResult
        } else {
            @Suppress("DEPRECATION")
            bundle.getParcelable(key)
        }
    }

    override fun put(bundle: Bundle, key: String, value: SearchResult) {
        bundle.putParcelable(key, value)
    }

    override fun parseValue(value: String): SearchResult {
        return Json.decodeFromString(value)
    }

    override fun serializeAsValue(value: SearchResult): String {
        return Json.encodeToString(value)
    }

    override val name: String
        get() = super.name
}