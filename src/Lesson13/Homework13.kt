package Lesson13

import java.util.Arrays
import java.util.Properties

fun main() {
    sumList() //Задача 1. Напишите функцию, которая принимает список целых чисел и возвращает их сумму
    listPeople() //Задача 2. Напишите программу, которая получает список людей, фильтрует только тех, кто старше 18 лет
    listNumbers() //Задача 3: Создайте список чисел от 1 до 1,000,000, отфильтруйте четные числа...
}

/*
Задача 1: Напишите функцию, которая принимает список целых чисел и
возвращает их сумму. Используйте лямбду в качестве параметра для
определения операции. (Reduce)
 */
fun sumList() {
    println("Задача 1: Напишите функцию, которая принимает список целых чисел и возвращает их сумму")
    val list = listOf(1, 2, 3, 4, 5, 6)
    println("List: $list")
    println("Sum list: " + sumIntList(list))
}

fun sumIntList(tempList : List<Int>): Int {
    return tempList.reduce {a, b -> a + b}
}

/*
Задача 2: Напишите программу, которая получает список людей, фильтрует
только тех, кто старше 18 лет, затем сортирует их по возрасту в порядке
убывания и выводит на экран с помощью apply и let. (sortedByDescending)
 */
class People(var name : String, var age : Int)

fun listPeople() {
    println("Задача 2. Напишите программу, которая получает список людей, фильтрует только тех, кто старше 18 лет")
    val list : List<People> = listOf(
        People("Alex", 33),
        People("Bob", 18),
        People("Steave", 23),
        People("Jack", 15),
        People("Jim", 19)
    )
    filterPeople(list)

}

fun filterPeople(tempList: List<People>) {
    tempList.asSequence().filter {
        it.age >= 18
    }.sortedByDescending {
        it.age
    }.apply {
        forEach {
            it.let {
                println("People ${it.name}, age ${it.age} ")
            }
        }
    }
}

/*
Задача 3: Создайте список чисел от 1 до 1,000,000, отфильтруйте четные числа,
затем возведите их в квадрат и посчитайте сумму всех этих чисел. Сделайте это с
использованием asSequence для ленивой обработки.
 */
fun listNumbers() {
    println("Задача 3. Создайте список чисел от 1 до 1,000,000, отфильтруйте четные числа...")
    val sum = (1..1_000_000).asSequence().filter {
        it % 2 == 0
    }.map {
        it.toLong() * it
    }.sum()

    println("Сумма четных чисел равна $sum")
}

