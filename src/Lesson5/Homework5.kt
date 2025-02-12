package Lesson5

import java.util.*

fun main() {
    val random = Random()
    val array = IntArray(10)
    for (i in array.indices) {
        array[i] = random.nextInt(10)
    }
    println(array.contentToString())
    val array2 = intArrayOf(1, 2, 3, 9, 9, 3, 2, 1) //Создание падиндромного массива

    maxMinArray(array) //Задание №1
    evenOdd(array) //Задание №2
    reversalArray(array) //Задание №3
    palinromArray(array2) //Задание №4
}

    /*
    Задание №1. Поиск максимального и минимального элемента массива
     */
fun maxMinArray(tempArray: IntArray) {
    println("Задание №1. Поиск максимального и минимального значения.")
    var max = tempArray[0]
    var min = tempArray[0]
    for (i in 1..<tempArray.size) {
        if (tempArray[i] > max) {
            max = tempArray[i]
        } else if (tempArray[i] < min) {
            min = tempArray[i]
        }
    }

    println("Максимальное значение равно $max")
    println("Минимальное значение равно $min")

    for (i in tempArray.indices) {
        if (tempArray[i] == max) {
            println("Индекс макимального элемента $i")
        } else if (tempArray[i] == min) {
            println("Индекс минимального элемента $i")
        }
    }
}


    /*
    Задание №2. Подсчет четных и нечетных чисел массива
     */
fun evenOdd(tempArray: IntArray) {
    println("Задание №2. Подсчет четных и нечетных чисел массива.")
    var even = 0
    var odd = 0
    for (i in tempArray.indices) {
        if (tempArray[i] % 2 == 0) {
            even += 1
        } else {
            odd += 1
        }
    }
    println("Количество четных чисел = $even. Количество нечетных = $odd")
}


    /*
    Задание №3. Напишите программу, которая принимает массив целых чисел и изменяет его порядок
    на обратный. Выведите результат после изменения порядка.
     */
fun reversalArray(tempArray: IntArray) {
    println("Задание №3. Реверс массива.")
    val reversal = IntArray(tempArray.size)
    var num = tempArray.size - 1
    for (i in tempArray.indices) {
        reversal[num] = tempArray[i]
        num--
    }
    println("Обратный массив " + reversal.contentToString())
}

/*
    Задание №4. Проверка на палиндром Напишите программу, которая проверяет,
    является ли массив чисел палиндромом.
     */
fun palinromArray(tempArray: IntArray) {
    println("Задание №4. Является ли массив чисел палиндромом.")
    var revID = tempArray.size - 1
    var result = true
    for (i in tempArray.indices) {
        if (revID < i) {
            break
        } else if (tempArray[i] == tempArray[revID]) {
                revID--
            } else {
                result = false
                break
            }
    }
    if (result) println("Массив палиндром")
    else println("Не палиндром")
}