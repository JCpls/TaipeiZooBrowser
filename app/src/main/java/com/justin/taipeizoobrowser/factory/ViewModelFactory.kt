package com.justin.taipeizoobrowser.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.justin.taipeizoobrowser.MainViewModel
import com.justin.taipeizoobrowser.data.source.Repository
import com.justin.taipeizoobrowser.home.HomeViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory constructor(
    private val repository: Repository,
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>) =
        with(modelClass) {
            when {
                isAssignableFrom(MainViewModel::class.java) ->
                    MainViewModel(repository)

                isAssignableFrom(HomeViewModel::class.java) ->
                    HomeViewModel(repository)

                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T
}