import java.util.Arrays;
import java.util.Random;

public class Homework5 {

    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
        }
        System.out.println(Arrays.toString(array));
        int[] array2 = {1, 2, 3, 9, 9, 3, 2, 1};
        maxMinArray(array); //Задание №1
        evenOdd(array); //Задание №2
        reversalArray(array); //Задание №3
        palinromArray(array2); //Задание №4
    }

    /*
    Задание №1. Поиск максимального и минимального элемента массива
     */
    public static void maxMinArray(int[] tempArray) {
        System.out.println("Задание №1. Поиск максимального и минимального значения.");
        int max = tempArray[0];
        int min = tempArray[0];
        StringBuilder maxIndex = new StringBuilder();
        StringBuilder minIndex = new StringBuilder();
        maxIndex.append(tempArray[0]);
        minIndex.append(tempArray[0]);
        for (int i = 1; i < tempArray.length; i++) {
            if (tempArray[i] > max) {
                max = tempArray[i];
                maxIndex.setLength(0);
                maxIndex.append(i).append(' ');
            } else if (tempArray[i] == max) {
                maxIndex.append(i).append(' ');
            } else if (tempArray[i] < min) {
                min = tempArray[i];
                minIndex.setLength(0);
                minIndex.append(i).append(' ');
            } else if (tempArray[i] == min) {
                minIndex.append(i).append(' ');
            }
        }

        System.out.println("Максимальное значение равно " + max + ". Индексы " + maxIndex);
        System.out.println("Минимальное значение равно " + min  + ". Индексы " + minIndex);
    }


    /*
    Задание №2. Подсчет четных и нечетных чисел массива
     */
    public static void evenOdd(int[] tempArray) {
        System.out.println("Задание №2. Подсчет четных и нечетных чисел массива.");
        int even = 0;
        int odd = 0;
        for (int i = 0; i < tempArray.length; i++) {
            if (tempArray[i] % 2 == 0) {
                even += 1;
            } else {
                odd += 1;
            }
        }
        System.out.println("Количество четных чисел = " + even + ". Количество нечетных = " + odd);

    }

    /*
    Задание №3. Напишите программу, которая принимает массив целых чисел и изменяет его порядок
    на обратный. Выведите результат после изменения порядка.
     */

    public static void reversalArray(int[] tempArray) {
        System.out.println("Задание №3. Реверс массива.");
        int[] reversal = new int[tempArray.length];
        int num = tempArray.length - 1;
        for (int i = 0; i < tempArray.length; i++) {
            reversal[num] = tempArray[i];
            num--;
        }
        System.out.println("Обратный массив " + Arrays.toString(reversal));
    }

    /*
    Задание №4. Проверка на палиндром Напишите программу, которая проверяет,
    является ли массив чисел палиндромом.
     */
    public static void palinromArray(int[] tempArray) {
        System.out.println("Задание №4. Является ли массив чисел палиндромом.");
        int revID = tempArray.length - 1;
        boolean result = true;
        for (int i = 0; i < tempArray.length; i++) {
            if (revID < i) {
                break;
            } else if (tempArray[i] == tempArray[revID]) {
                    revID--;
                } else {
                    result = false;
                    break;
                }

        }
        if (result) System.out.println("Массив палиндром");
        else System.out.println("Не палиндром");
    }

}
