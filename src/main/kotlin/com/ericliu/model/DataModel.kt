package com.ericliu.model

data class Book(var id: String, var title: String, var author: String, var price: Float)
data class ShoppingCart(var id: String, var userid: String, val items: List<ShoppingItem>, var)
data class ShoppingItem(var bookid: String, var qty: Int)
data class User(var id: String, var name: String, var password: String)
