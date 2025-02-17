import java.util.Arrays;
import java.util.Random;

public class Homework6 {

    public static void main(String[] args) {
        Random random = new Random();
        int[] arrayR = new int[10];
        for (int i = 0; i < arrayR.length; i++) {
            arrayR[i] = random.nextInt(10);
        }
        System.out.println("Начальный рандомный массив " + Arrays.toString(arrayR));
        int[] arrayM = new int[] {4, -3, 2, -1, 0, -5};
        //System.out.println("Начальный ручной массив " + Arrays.toString(arrayM));

        sortMinus(arrayM); //Сортировка массива с отрицательными числами
        sortFrequency(arrayR); //Частотная сортировка
    }

    public static void sortMinus (int[] arrayTemp) {
        System.out.println("Homework №1. Сортировка массива с отрицательными числами");
        boolean swapped = true;
        int buff;

        while (swapped) {
            swapped = false;
            for (int i = 0; i < arrayTemp.length - 1; i++) {
                if (arrayTemp[i] > arrayTemp[i + 1]) {
                    buff = arrayTemp[i];
                    arrayTemp[i] = arrayTemp[i + 1];
                    arrayTemp[i + 1] = buff;
                    swapped = true;
                }
            }
        }

        System.out.println("Отсортированный массив " + Arrays.toString(arrayTemp));
    }

    public static void sortFrequency(int[] arrayTemp) {
        System.out.println("Частотная сортировка:");
        // Проверяем сколько раз каждый элемент повторяется в массиве arr
        //Т.к. у нас рандом цифр от 0 до 10, то массив делаем со значением 10,
        // чтобы не выйти за рамки массива.
        int[] frequency = new int[arrayTemp.length];
        for (int num : arrayTemp) {
            frequency[num]++;
        }
        System.out.println("Массив frequency " + Arrays.toString(frequency));

        // Сортируем массив по частоте и значению
        for (int i = 0; i < arrayTemp.length; i++) {
            for (int j = i + 1; j < arrayTemp.length; j++) {
                if (frequency[arrayTemp[i]] < frequency[arrayTemp[j]] ||
                        (frequency[arrayTemp[i]] == frequency[arrayTemp[j]] && arrayTemp[i] > arrayTemp[j])) {
                    // Меняем местами элементы
                    int temp = arrayTemp[i];
                    arrayTemp[i] = arrayTemp[j];
                    arrayTemp[j] = temp;
                }
            }
        }

        System.out.println("Отсортированный массив" + Arrays.toString(arrayTemp));
    }



}
