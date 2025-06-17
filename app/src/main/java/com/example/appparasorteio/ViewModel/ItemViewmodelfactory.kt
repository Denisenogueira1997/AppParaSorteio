package com.example.appparasorteio.ViewModel


import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appparasorteio.data.ItemDatabase
import com.example.appparasorteio.data.ItemRepository

class ItemViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ItemViewModel::class.java)) {
            val dao = ItemDatabase.getDatabase(context).itemDao()
            val repository = ItemRepository(dao)
            return ItemViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
