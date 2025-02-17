package Leeson7.Homework7.Java;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArraysHomework {

    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
        }
        System.out.println("Первоначальный массив" + Arrays.toString(array));

        searchTargetSum(array); //Задание №1 по массивам. Найти все пары с заданной суммой.
        zeroEnd(array); //Задание №2 по массивам. Перестановка нулей в конец
        anagramArray(); //Задание №3 по массивам. Проверка на перестановку (анаграмма массива)
        maxSum(array, 4); //Задание №4 по массивам. Максимальная сумма подмассива фиксированной длины
    }

    public static void searchTargetSum(int[] tempArray) {
        System.out.println("Задание №1 по массивам. Найти все пары с заданной суммой.");

        Scanner scanner = new Scanner(System.in);
        int targetSum = scanner.nextInt();
        int count = 0;

        for (int i = 0; i < tempArray.length; i++) {
            for (int j = i + 1; j < tempArray.length; j++) {
                if (tempArray[i] + tempArray[j] == targetSum) {
                    System.out.println("(" + tempArray[i] + " , " + tempArray[j] + ")");
                    count++;
                }
            }
        }
        System.out.println("Количество пар чисел сумма которых равна " + targetSum + ": " + count);
    }

    public static void zeroEnd(int[] tempArray) {
        System.out.println("Задание №2 по массивам. Перестановка нулей в конец.");

        int buffer = 0;
        for (int i = 0; i < tempArray.length - 1; i++) {
            for (int j = i + 1; j < tempArray.length; j++) {
                if (tempArray[i] == 0) {
                    buffer = tempArray[j];
                    tempArray[j] = tempArray[i];
                    tempArray[i] = buffer;
                }
            }
        }

        System.out.println("Массив с нулями в конце " + Arrays.toString(tempArray));
    }

    public static void anagramArray() {
        System.out.println("Задание №3 по массивам. Проверка на перестановку (анаграмма массива).");

        int[] array1 = new int[] {5, 3, 0, 3, 1};
        int[] array2 = new int[] {3, 1, 3, 0, 5};
        int[] countArray1 = new int[array1.length + 1];
        int[] countArray2 = new int[array2.length + 1];
        boolean result = true;

        for (int i = 0; i < array1.length; i++) {
            countArray1[array1[i]]++; //Считаем сколько раз число повторялось в массиве1
            countArray2[array2[i]]++; //Считаем сколько раз число повторялось в массиве2
        }

        for (int i = 0; i < countArray1.length; i++) {
            if (countArray1[i] != countArray2[i]) result = false;
        }

        System.out.println("Повторений чисел в массиве array1: " + Arrays.toString(countArray1));
        System.out.println("Повторений чисел в массиве array2: " + Arrays.toString(countArray2));
        System.out.println("Результат: " + (result?"Анаграмма":"Не анаграмма"));
    }

    public static void maxSum(int[] tempArray, int k){
        System.out.println("Задание №4 по массивам. Максимальная сумма подмассива фиксированной длины");

        if (tempArray.length < k) {
            System.out.println("Некорректно введены данные");
        } else {
            int sumK = 0;
            for (int i = 0; i < k; i++) {
                sumK += tempArray[i];
            }
            System.out.println("Сумма первых " + k + " чисел равна " + sumK);
            int maxSumK = sumK;
            for (int i = k; i < tempArray.length; i++) {
                sumK += tempArray[i] - tempArray[i - k];
                if (sumK > maxSumK) maxSumK = sumK;
            }

            System.out.println("Самая большая сумма подмассива размером " + k + " равна " + maxSumK);
        }

    }

}
