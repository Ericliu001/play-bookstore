package com.ericliu

import com.ericliu.model.Book
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.books() {
    val dataManager = DataManager()
    route("/book") {
        get("/") {
            call.respond(dataManager.allBooks())
        }

        post("/{id}") {
            val id = call.parameters.get("id")
            val book = call.receive(Book::class)

            id?.let {
                dataManager.updateBook(id, book)
            }
            call.respondText { "The book has been updated $book" }
        }

        put("/") {
            val book = call.receive(Book::class)
            dataManager.newBook(book)
            call.respond(book)
        }

        delete("/{id}") {
            val id = call.parameters["id"]
            id?.let {
                dataManager.deleteBook(id)
            }
        }
    }

}