package com.ericliu

import com.ericliu.model.Book

class DataManager {
    private val books = mutableListOf<Book>()

    fun init() {
        books.add(Book(gimmeId(), "How to grow apples", "Mr Appleton", 100.0f))
        books.add(Book(gimmeId(), "How to grow Oranges", "Mr Felix", 10.0f))
        books.add(Book(gimmeId(), "How to grow Lemons", "Mr Omer", 123.0f))
        books.add(Book(gimmeId(), "How to grow Pears", "Mr Brandon", 300.0f))
        books.add(Book(gimmeId(), "How to grow Pineapples", "Mr Andrew", 1034.0f))
        books.add(Book(gimmeId(), "How to grow Coconuts", "Mr Frank", 4.0f))
    }

    fun gimmeId(): String {
        return books.size.toString()
    }


}