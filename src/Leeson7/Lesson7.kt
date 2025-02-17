package Leeson7

import Leeson7.Homework7.Kotlin.Author
import Leeson7.Homework7.Kotlin.Book
import Leeson7.Homework7.Kotlin.BookwithAuthor
import Leeson7.Homework7.Kotlin.Month

fun main() {

    //Задание №1 на котлин. Реализовать класс Book
    val book1 = Book("Книга1", "Пушкин", 1830)
    val book2 = Book("Книга1", "Пушкин", 1833)
    val book3= Book("Книга2", "Пушкин", 1830)

    println(book1.toString())
    println(book2.toString())
    println(book3.toString())

    println("Результат book1 и book2: ${book1 == book2}")
    println("Результат book1 и book3: ${book1 == book3}")

    //Задание №2. Создать ENUM Month и метод isWinter
    isWinter()

    //Задание №3. Композиция классов и equals
    createAuthor()

}

fun isWinter() {
    println("Задание №2. Создать ENUM Month и метод isWinter\nВведите название месяца")
    val tempMonth = readln()
    val result = (tempMonth.uppercase() == Month.DECEMBER.name || tempMonth.lowercase() == Month.DECEMBER.value ||
            tempMonth.uppercase() == Month.JANUARY.name || tempMonth.lowercase() == Month.JANUARY.value ||
            tempMonth.uppercase() == Month.FEBRUARY.name || tempMonth.lowercase() == Month.FEBRUARY.value)

    println("Месяц зимний? $result")
}

fun createAuthor(){
    println("Задание №3. Композиция классов и equals")
    val bookWithAuthor1 = BookwithAuthor("Книга1", 1830, Author("Пушкин", 1780))
    val bookWithAuthor2 = BookwithAuthor("Книга1", 1833, Author("Пушкин", 1799))
    val bookWithAuthor3= BookwithAuthor("Книга2", 1830, Author("Пушкин", 1798))
    println(bookWithAuthor1.toString())
    println(bookWithAuthor2.toString())
    println(bookWithAuthor3.toString())
    println("Результат book1 и book2: ${bookWithAuthor1.equals(bookWithAuthor2)}") //equals эквивалентно ==
    println("Результат book1 и book3: ${bookWithAuthor1 == bookWithAuthor3}")
}