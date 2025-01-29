import java.util.Arrays;
import java.util.Random;

public class Lesson6 {

    public static void main(String[] args) {
        Random random = new Random();
        int[] arrayR = new int[10];
        for (int i = 0; i < arrayR.length; i++) {
            arrayR[i] = random.nextInt(10);
        }
        //System.out.println("Начальный массив " + Arrays.toString(arrayR));
        int[] arrayM = new int[]{2, 4, 11, 5, 35, 9, 0};
        bubbleSort(arrayR); //Урок 6. Сортировка пузырьком
        sortUpDown(arrayR, true); //Задача №3. Сортировака по возрастанию и убыванию
        sortAndDelete(arrayR); //Задача №4. Сортировка и удаление дубликатов.
    }

    /*
    Сортировка пузырьком
     */
    public static void bubbleSort(int[] arrayTemp) {

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

    /*
    Задача №3. Сортировка по возрастанию и убыванию.
     */
    public static void sortUpDown(int[] tempArray, boolean sort) {
        System.out.println("Задача №3. Сортировка по возрастанию и убыванию");

        boolean swapped = true;
        int buff;

        while (swapped) {
            swapped = false;
            if (sort) {
                for (int i = 0; i < tempArray.length - 1; i++) {
                    if (tempArray[i] > tempArray[i + 1]) {
                        buff = tempArray[i];
                        tempArray[i] = tempArray[i + 1];
                        tempArray[i + 1] = buff;
                        swapped = true;
                    }
                }
            } else {
                for (int i = 0; i < tempArray.length - 1; i++) {
                    if (tempArray[i] < tempArray[i + 1]) {
                        buff = tempArray[i];
                        tempArray[i] = tempArray[i + 1];
                        tempArray[i + 1] = buff;
                        swapped = true;
                    }
                }

            }
        }

        System.out.println("Отсортированный массив " + Arrays.toString(tempArray) + ((sort) ? " По возрастанию" : " По убыванию"));

    }

    /*
   Задача №4. Удаление дубликатов с сортировкой.
    */
    public static void sortAndDelete(int[] tempArray) {
        System.out.println("Задача №4. Удаление дубликатов с сортировкой.");
        System.out.println("Начальный массив " + Arrays.toString(tempArray));

        boolean swapped;
        int count = 0;

        for (int i = 0; i < tempArray.length - 1; i++) {
            swapped = false;
            count = 0;
            for (int j = 0; j < tempArray.length - 1; j++) {
                if (tempArray[j] > tempArray[j + 1]) {
                    int buff;
                    buff = tempArray[j];
                    tempArray[j] = tempArray[j + 1];
                    tempArray[j + 1] = buff;
                    swapped = true;
                } else if (tempArray[j] == tempArray[j + 1]) {
                    count++;
                }
            }
            if (!swapped) {
                break;
            }
        }

        System.out.println("Отсортированный массив циклом for " + Arrays.toString(tempArray));
        System.out.println("Количество повторных чисел " + count);

        int[] resultArray = new int[tempArray.length - count];
        int rID = 1;
        int tempNumber = tempArray[0];
        resultArray[0] = tempArray[0];

        for(int i = 1; i < tempArray.length; i++) {
            if (tempArray[i] != tempNumber) {
                tempNumber = tempArray[i];
                resultArray[rID] = tempNumber;
                rID++;
            }
        }
        System.out.println("Массив без повторяющихся элементов " + Arrays.toString(resultArray));

    }
}
