package com.heiligbasil.datenight

import android.util.Log
import androidx.lifecycle.ViewModel
import com.heiligbasil.datenight.Utils.replaceSlashesWithHyphens
import com.heiligbasil.datenight.Utils.urlEncode
import com.heiligbasil.datenight.data.CustomSearchRepository
import com.heiligbasil.datenight.data.NetworkResult
import com.heiligbasil.datenight.data.entities.CustomSearchResponse
import com.heiligbasil.datenight.ui.entities.SearchResult
import com.heiligbasil.datenight.ui.entities.SearchResult.Companion.defaultDescription
import com.heiligbasil.datenight.ui.entities.SearchResult.Companion.defaultTitle
import com.heiligbasil.datenight.ui.entities.sampleResults

class MainViewModel(private val customSearchRepository: CustomSearchRepository) : ViewModel() {

    private var searchResponse = CustomSearchResponse.returnClassWithJustNulls()
    var searchResults = arrayListOf<SearchResult>()

    suspend fun getCustomSearchResults(searchQuery: String) {
        val result = customSearchRepository.getCustomSearchResults(searchQuery = searchQuery)
        when (result) {
            is NetworkResult.Success -> {
                Log.d(this@MainViewModel::class.simpleName, result.data.toString())
                searchResponse = result.data
            }

            is NetworkResult.Error -> {
                Log.e(this@MainViewModel::class.simpleName, result.error)
            }
        }
    }

    fun convertCustomSearchResponseToSearchResultList() {
        var informInLog = "Adding ${searchResponse.items?.count()} items to the list"
        searchResults.clear()
        searchResponse.items?.forEach {
            searchResults.add(
                SearchResult(
                    title = it?.title.replaceSlashesWithHyphens() ?: defaultTitle,
                    description = it?.snippet.replaceSlashesWithHyphens() ?: defaultDescription,
                    actualLink = it?.link?.urlEncode(),
                    displayLink = it?.displayLink?.urlEncode(),
                    imageUrl = it?.pagemap?.cseImage?.get(0)?.src?.urlEncode()
                )
            )
        }
        if (searchResults.isEmpty()) {
            informInLog = "No search results found...adding hardcoded ones"
            searchResults = sampleResults
        }
        Log.d(this@MainViewModel::class.simpleName, informInLog)
    }
}
