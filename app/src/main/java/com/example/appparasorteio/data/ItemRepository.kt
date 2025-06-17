package com.example.appparasorteio.data

import com.example.appparasorteio.model.Item

class ItemRepository(private val dao: ItemDao) {
    suspend fun insert(item: Item) = dao.insert(item)
    suspend fun getAll(): List<Item> = dao.getAll()
    suspend fun remover(item: Item)= dao.delete(item)
    }


