package Lesson11.homework11;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Homework11 {
    public static void main(String[] args) {
        circleLastElement(); //Задача 1: Последний оставшийся элемент (LinkedList)
        sortTwoLinkedList(); //Задача 2: Слияние двух отсортированных LinkedList в один (без Set, Map)
    }

    public static LinkedList<Integer> addLinkedList(int count) {
        LinkedList<Integer> linkList = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            linkList.add(random.nextInt(0 , 20));
        }
        System.out.println(linkList);
        return linkList;
    }
    /*
    Задача 1: Последний оставшийся элемент (LinkedList)
    В круге из n человек каждый 2-й выбывает, пока не останется один. Используйте
    LinkedList для моделирования.
     */
    public static void circleLastElement() {
        System.out.println("Задача 1: Последний оставшийся элемент (LinkedList)\nВведите кол-во человек в круге:");
        Scanner scanner = new Scanner(System.in);
        int count = 1;
        try {
            count = scanner.nextInt();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
        LinkedList<Integer> link = addLinkedList(count);
        System.out.println(deleteFromCircle(link));
    }

    public static LinkedList<Integer> deleteFromCircle(LinkedList<Integer> tempLink) {
        Random random = new Random();
        while (tempLink.size() > 1){
            for (int i = 0; i < tempLink.size() - 1; i++) {
                int x = random.nextInt(i,i + 2);
                System.out.println("Rand=" + x + " i=" + i + " i+1=" + (i + 1));
                tempLink.remove(x);
                System.out.println(tempLink);
            }
        }
        return tempLink;
    }

    /*
    Задача 2: Слияние двух отсортированных LinkedList в один (без Set, Map)
    Даны два отсортированных LinkedList, нужно слить их в один отсортированный список
     */

    public static void sortTwoLinkedList() {
        System.out.println("Задача 2: Слияние двух отсортированных LinkedList в один (без Set, Map)\nВведите размер LinkedList:");
        Scanner scanner = new Scanner(System.in);
        int count;

        try {
            count = scanner.nextInt();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }

        //Сортируем 2 LinkedList с помощью метода sortLinked
        LinkedList<Integer> linkedFirst = addLinkedList(count);
        linkedFirst = sortLinked(linkedFirst);
        System.out.println("Sort linkedFirst: " + linkedFirst);
        LinkedList<Integer> linkedSecond = addLinkedList(count);
        linkedSecond = sortLinked(linkedSecond);
        System.out.println("Sort linkedSecond: " + linkedSecond);

        //Объединение LinkedList
        int x = 0;
        for (int i = 0; i < linkedFirst.size() - 1; i++) {
            for (int j = x; j < linkedSecond.size(); j++) {
                if (linkedSecond.get(j) > linkedFirst.getLast()) {
                    linkedFirst.addLast(linkedSecond.get(j));
                    linkedSecond.remove(j);
                } else if (linkedSecond.get(j) <= linkedFirst.get(i)) {
                    linkedFirst.add(i, linkedSecond.get(j));
                        i++;
                        x++;
                    } else if (linkedSecond.get(j) > linkedFirst.get(i) && linkedSecond.get(j) <= linkedFirst.get(i + 1)) {
                    linkedFirst.add(i + 1, linkedSecond.get(j));
                            i++;
                            x++;
                        }
            }
        }

        System.out.println("Merged LinkedList " + linkedFirst);
    }

    //Сортировка LinkedList и дальнейшее его возвращение
    public static LinkedList<Integer> sortLinked(LinkedList<Integer> tempLinked) {
        int buff;
        for (int i = 0; i < tempLinked.size(); i++) {
            for (int j = i + 1; j < tempLinked.size(); j++) {
                if (tempLinked.get(i) > tempLinked.get(j)) {
                    buff = tempLinked.get(i);
                    tempLinked.set(i, tempLinked.get(j));
                    tempLinked.set(j, buff);
                }
            }
        }
        return tempLinked;
    }
}
