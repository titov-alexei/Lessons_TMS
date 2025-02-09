package Leeson7.Homework7.Kotlin

import Leeson7.Homework7.Java.Author

class Author(val name : String, private val year: Int) {

    override fun equals(otherAuthor: Any?): Boolean {
        if (otherAuthor == null || otherAuthor !is Author) return false
        if (this::class === otherAuthor) return true

        return this.name.equals(otherAuthor)
    }

    override fun hashCode(): Int {
        return name.hashCode() + year
    }
}