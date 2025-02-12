package Leeson7.Homework7.Kotlin

import java.util.*

fun main() {
    val random: Random = Random()
    val array: IntArray = IntArray(10)
    for (i in array.indices)
    {
        array[i] = random.nextInt(10)
    }

    println("Первоначальный массив" + array.contentToString())

    searchTargetSum(array) //Задание №1 по массивам. Найти все пары с заданной суммой.
    zeroEnd(array) //Задание №2 по массивам. Перестановка нулей в конец
    anagramArray() //Задание №3 по массивам. Проверка на перестановку (анаграмма массива)
    maxSum(array, 4) //Задание №4 по массивам. Максимальная сумма подмассива фиксированной длины
}

fun searchTargetSum(tempArray: IntArray) {
    println("\n------------\nЗадание №1 по массивам. Найти все пары с заданной суммой.\nВведите число (сумму):")

    val scanner = Scanner(System.`in`)
    val targetSum = scanner.nextInt()
    var count = 0

    for (i in tempArray.indices) {
        for (j in i + 1..<tempArray.size) {
            if (tempArray[i] + tempArray[j] == targetSum) {
                println("(" + tempArray[i] + " , " + tempArray[j] + ")")
                count++
            }
        }
    }
    println("Количество пар чисел сумма которых равна $targetSum: $count")
}

fun zeroEnd(tempArray: IntArray) {
    println("\n------------\nЗадание №2 по массивам. Перестановка нулей в конец.")

    var buffer = 0
    for (i in 0..<tempArray.size - 1) {
        for (j in i + 1..<tempArray.size) {
            if (tempArray[i] == 0) {
                buffer = tempArray[j]
                tempArray[j] = tempArray[i]
                tempArray[i] = buffer
            }
        }
    }

    println("Массив с нулями в конце " + tempArray.contentToString())
}

fun anagramArray() {
    println("\n------------\nЗадание №3 по массивам. Проверка на перестановку (анаграмма массива).")

    val array1 = intArrayOf(5, 3, 0, 3, 1)
    val array2 = intArrayOf(3, 1, 3, 0, 5)
    val countArray1 = IntArray(array1.size + 1)
    val countArray2 = IntArray(array2.size + 1)
    var result = true

    for (i in array1.indices) {
        countArray1[array1[i]]++ //Считаем сколько раз число повторялось в массиве1
        countArray2[array2[i]]++ //Считаем сколько раз число повторялось в массиве2
    }

    for (i in countArray1.indices) {
        if (countArray1[i] != countArray2[i]) result = false
    }

    println("Повторений чисел в массиве array1: " + countArray1.contentToString())
    println("Повторений чисел в массиве array2: " + countArray2.contentToString())
    println("Результат: " + (if (result) "Анаграмма" else "Не анаграмма"))
}

fun maxSum(tempArray: IntArray, k: Int) {
    println("\n------------\nЗадание №4 по массивам. Максимальная сумма подмассива фиксированной длины")

    if (tempArray.size < k) {
        println("Некорректно введены данные")
    } else {
        var sumK = 0
        for (i in 0..<k) {
            sumK += tempArray[i]
        }
        println("Сумма первых $k чисел равна $sumK")
        var maxSumK = sumK
        for (i in k..<tempArray.size) {
            sumK += tempArray[i] - tempArray[i - k]
            if (sumK > maxSumK) maxSumK = sumK
        }

        println("Самая большая сумма подмассива размером $k равна $maxSumK")
    }
}
