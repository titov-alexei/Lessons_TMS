package Lesson13

fun main() {
    scopeApplyInPerson()  //Задача 1. Создайте объект класса Person с полем name, используя apply.
    scopeRunInBook()    //Задача 2. Создать объект класса Book и вывести информацию о нем, используя run.
    powInListMap() //Задача 3. Используя map, создайте новый список строк, где каждая строка — это строковое представление квадратов чисел из списка.
    filterListEven() //Задача 4. Используя filter, создайте новый список, содержащий только четные числа
    sequentionalFiltering() //Задача 5: Используя asSequence, выполните последовательную фильтрацию
    generatePowSequence() //Задача 6: Используя sequenceOf, создайте последовательность, содержащую квадратные числа от 1 до 5.
    println(inlined(4,12) { a, b -> a + b } ) //Задача 7: Создайте функцию inline, которая принимает два числа и выполняет операцию сложения через лямбду.
    vowelsToString(); //Задача 8: Создайте расширение для типа String, которое возвращает количество гласных в строке.
    extForList() //Задача 9: Напишите расширение для List<Int>, которое возвращает среднее значение.
    extForInt() //Задача 10: Напишите расширение для типа Int, которое возвращает true если четное и false если нечетное
}

    /*
   Задача 1. Создайте объект класса Person с полем name, используя apply.
   Затем выведите имя через let
    */
    fun scopeApplyInPerson() {
        println("Задача 1. Создайте объект класса Person с полем name, используя apply.\n" +
                "Затем выведите имя через let")
        val people = listOf(
            Person().apply { name = "Bob" },
            Person(),
            Person().apply { name = "Alex"}
        )

        for (i in people) {
            i.name?.let { println(it) }
        }
    }

/*
Задача 2: Напишите код, который создает объект класса Book и выводит
информацию о нем, используя run.
 */
fun scopeRunInBook() {
    val book = Book().run {
        title = "First book"
        year = 2025
        author = "Author"
        println("$title ($year) - $author")
    }
}

/*
Задача 3: Используя map, создайте новый список строк, где каждая строка — это
строковое представление квадратов чисел из списка.
 */
fun powInListMap() {
    println("Задача 3: Используя map, создайте новый список строк, где каждая строка — это\n" +
            "строковое представление квадратов чисел из списка.")
    val list : List<Int> = listOf(1, 2, 3, 4, 5, 6)
    println("List: $list")
    val newList : List<String> = list.map {
        val i = it * it
        i.toString()
    }
    println("New List: $newList")
}

/*
Задача 4: Используя filter, создайте новый список, содержащий только четные
числа из исходного списка.
 */
fun filterListEven() {
    println("Задача 4: Используя filter, создайте новый список, содержащий только четные \n" +
            "числа из исходного списка.")

    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println("Not filtered: $list")
    val filtList = list.filter {
        it % 2 == 0
    }
    println("Filtered list: $filtList")
}

/*
Задача 5: Используя asSequence, выполните последовательную фильтрацию и
возведение в квадрат для списка четных чисел, но только после того как вы
преобразуете его в Sequence.
 */
fun sequentionalFiltering() {
    println("Задача 5: Используя asSequence, выполните последовательную фильтрацию")
    val list = listOf(1, 2, 3, 4, 5)
    println(list)
    val sequence = list.asSequence().filter {
        it % 2 == 0
    }.map {
        println(it * it)
    }.toList()
    sequence.toList()

}

/*
Задача 6: Используя sequenceOf, создайте последовательность, содержащую квадратные числа от 1 до 5.
 */
fun generatePowSequence() {
    println("Задача 6: Используя sequenceOf, создайте последовательность, содержащую квадратные числа от 1 до 5.")
    val list = sequenceOf(1, 2, 3, 4, 5).map {
        it * it
    }.toList()

    println(list)
}

/*
Задача 7: Создайте функцию inline, которая принимает два числа и выполняет
операцию сложения через лямбду.
 */
inline fun inlined(a: Int, b: Int, operation: (Int, Int) -> Int) : Int {
    println("Задача 7. Создайте функцию inline, которая принимает два числа и выполняет\n" +
            "операцию сложения через лямбду")
    return operation(a, b)
}


/*
Задача 8: Создайте расширение для типа String, которое возвращает количество гласных в строке.
 */
fun vowelsToString() {
    println("Задача 8: Создайте расширение для типа String, которое возвращает количество гласных в строке.")
    val str = "Hi, my name is Alex!"
    println("$str\nNumber of vowels = " + str.numberOfVowels())
}

fun String.numberOfVowels() : Int {
    val vowels = "aeioyu"
    return this.count { it.lowercase() in vowels }
}

/*
Задача 9: Напишите расширение для List<Int>, которое возвращает среднее значение.
 */
fun extForList() {
    println("Задача 9: Напишите расширение для List<Int>, которое возвращает среднее значение.")
    val list = listOf(2, 2, 3, 4, 5)
    println("First list: $list")
    println(list.isAverage())
}

fun List<Int>.isAverage() : Double {
    return this.sum()/size.toDouble()
}


/*
Задача 10: Напишите расширение для типа Int, которое возвращает true, если
число четное, и false, если нечетное.
 */
fun extForInt() {
    println("Задача 10: Напишите расширение для типа Int, которое возвращает true, если\n" +
            "число четное, и false, если нечетное.")
    val num = 11
    println("Number $num is even? ${num.isEven()}")
}

fun Int.isEven(): Boolean {
    return this % 2 == 0
}