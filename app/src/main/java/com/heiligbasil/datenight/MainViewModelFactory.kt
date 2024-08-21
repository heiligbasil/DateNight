package com.heiligbasil.datenight

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.heiligbasil.datenight.data.CustomSearchRepository


class MainViewModelFactory(
    private val customSearchRepository: CustomSearchRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(customSearchRepository) as T
    }
}
