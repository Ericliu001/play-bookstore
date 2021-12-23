package com.ericliu

import com.ericliu.model.Book

class DataManager {
    private val books = mutableListOf<Book>()

    init {
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

    fun allBooks(): List<Book> {
        return books
    }

    fun updateBook(id: String, book: Book) {
        val bookFound = books.find { it.id == id }
        books.remove(bookFound)
        books.add(book)
    }

    fun newBook(book: Book) {
        books.add(book)
    }

    fun deleteBook(id: String): Book? {
        val bookFound = books.find { it.id == id }
        books.remove(bookFound)
        return bookFound
    }


}