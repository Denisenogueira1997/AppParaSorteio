package com.example.appparasorteio.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appparasorteio.model.Item
import com.example.appparasorteio.data.ItemRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ItemViewModel(private val repository: ItemRepository) : ViewModel() {

    private val _items = MutableStateFlow<List<Item>>(emptyList())
    val items: StateFlow<List<Item>> = _items

    private val _sorteado = MutableStateFlow<Item?>(null)
    val sorteado: StateFlow<Item?> = _sorteado

    init {
        carregarItens()
    }

    private fun carregarItens() {
        viewModelScope.launch {
            _items.value = repository.getAll()
        }
    }

    fun adicionarItem(nome: String) {
        viewModelScope.launch {
            val novoItem = Item(nome = nome)
            repository.insert(novoItem)
            carregarItens()
        }
    }

    fun removerItem(item: Item) {
        viewModelScope.launch {
            repository.remover(item)
            carregarItens()
        }
    }

    fun sortearItem() {
        viewModelScope.launch {
            val lista = repository.getAll()
            _sorteado.value = lista.randomOrNull()
        }
    }
}


