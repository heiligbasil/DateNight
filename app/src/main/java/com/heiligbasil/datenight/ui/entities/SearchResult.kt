package com.heiligbasil.datenight.ui.entities

import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavType
import com.heiligbasil.datenight.R
import com.heiligbasil.datenight.Utils.jsonStringWithNulls
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString

@Serializable
@Parcelize
data class SearchResult(
    val title: String,
    val description: String,
    var actualLink: String?,
    var displayLink: String?,
    var imageUrl: String?
) : Parcelable {

    companion object {
        const val defaultTitle = "Date Night Option"
        const val defaultDescription = "Date Night Details"
        const val defaultUrlEncoded = "https%3A%2F%2Fwww.example.com%2F"
        val defaultImage = R.drawable.default_image

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
                return jsonStringWithNulls.decodeFromString(value)
            }

            override fun serializeAsValue(value: SearchResult): String {
                return jsonStringWithNulls.encodeToString(value)
            }

            override val name: String
                get() = super.name
        }
    }
}
