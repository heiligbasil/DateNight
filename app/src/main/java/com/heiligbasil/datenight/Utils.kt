package com.heiligbasil.datenight

import android.content.Context
import androidx.annotation.RawRes
import com.heiligbasil.datenight.data.entities.CustomSearchResponse
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.net.URLDecoder
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

object Utils {

    fun Context.readRawResource(@RawRes rawResId: Int): String {
        val rawResource = this.resources.openRawResource(rawResId)
        val bufferedReader = rawResource.bufferedReader()
        return bufferedReader.use { it.readText() }
    }

    @OptIn(ExperimentalSerializationApi::class)
    val jsonStringWithNulls: Json
        get() {
            val format = Json {
                explicitNulls = false
                ignoreUnknownKeys = true
            }
            return format
        }

    fun decodeJsonStringWithNulls(jsonText: String): CustomSearchResponse =
        jsonStringWithNulls.decodeFromString<CustomSearchResponse>(jsonText)

    fun encodeJsonStringWithNulls(text: String): String =
        jsonStringWithNulls.encodeToString(text)

    fun String?.urlEncode(): String =
        URLEncoder.encode(this, StandardCharsets.UTF_8.toString())

    fun String?.urlDecode(): String =
        URLDecoder.decode(this, StandardCharsets.UTF_8.toString())
}
