package Leeson7.Homework7.Kotlin

class BookwithAuthor (val title : String, private val year : Int, val author: Author) {

    fun getInfo(){
        println("Книга '$title', автор ${author.name}, год $year")
    }

    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        if (other !is BookwithAuthor) return false
        if (other === this) return true
        return this.title == other.title && this.author.name == other.author.name
    }

    override fun hashCode(): Int {
        return title.hashCode() + year
    }
}

