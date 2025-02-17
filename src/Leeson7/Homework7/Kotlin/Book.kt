package Leeson7.Homework7.Kotlin

class Book (val title : String, val author : String, private val year : Int ) {

    fun getInfo(){
        println("Книга '$title', автор $author, год $year")
    }

    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        if (other !is Book) return false
        if (other === this) return true
        return this.title == other.title && this.author == other.author
    }

    override fun hashCode(): Int {
        return title.hashCode() + year
    }

    override fun toString(): String {
        return "Title: $title, author: $author, year: $year"
    }
}

