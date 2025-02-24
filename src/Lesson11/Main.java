package Lesson11;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        deleteDuplicates(); //Задача 1: Удаление дубликатов из ArrayList
        reverseLinkList(addLinkList()); //Задача 2: Разворот LinkedList
        iteratorAndDelete(); //Задача 3: Итератор и удаление по условию
        queueTasks(); //Задача №4. Очередь задач (ArrayDeque)
        balanceBrackets(); //Задача 5: Проверка сбалансированности скобок (Stack)
        sortArrayBubbles(); //Задача 6: Сортировка ArrayList без Collections.sort()
        reverseWord(); //Задача 7: Обратный порядок слов (Stack)
    }

    /*
    Задача 1: Удаление дубликатов из ArrayList
    Дан ArrayList<Integer>, содержащий дубликаты.
    Удалите все дубликаты, сохраняя порядок элементов.
     */
    public static void deleteDuplicates() {
        ArrayList<Integer> arrayList = addElement();
        System.out.println(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = i + 1; j < arrayList.size(); j++) {
                if(arrayList.get(i).equals(arrayList.get(j))){
                    arrayList.remove(j);
                    j--;
                }
            }
        }
        System.out.println(arrayList);
    }

    public static ArrayList<Integer> addElement() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            arrayList.add(rand.nextInt(0 , 10));
        }
        return arrayList;
    }

    /*
    Задача 2: Разворот LinkedList
    Разверните LinkedList без использования Collections.reverse().
     */
    public static LinkedList<Integer> addLinkList() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            linkedList.add(rand.nextInt(0, 10));
        }
        System.out.println(linkedList);
        return linkedList;
    }

    public static void reverseLinkList(LinkedList<Integer> linkList) {
        System.out.println("Изначальны linked " + linkList);
        int buff = 0;
        for(int i = 0; i < linkList.size() / 2; i++) {
            for (int j = linkList.size() - 1; j > i; j-- ) {
                //System.out.println("Link i = " + linkList.get(i) + " Lin j = " + linkList.get(j) + " i=" + i + " j=" + j);
                buff = linkList.get(i);
                linkList.set(i, linkList.get(j));
                linkList.set(j, buff);
                i++;
                //System.out.println(linkList);
            }
        }
        System.out.println("Конечный массив " + linkList);
    }

    public static LinkedList<Integer> reverseLinkedListVanilla(LinkedList<Integer> list) {
        for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
            Integer temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
        return list;
    }


    /*
    Задача 3: Итератор и удаление по условию
    Дан ArrayList<Integer>. Используйте Iterator, чтобы удалить все числа, кратные 3.
     */
    public static void iteratorAndDelete() {
        System.out.println("Задача 3: Итератор и удаление по условию");
        ArrayList<Integer> arrayList = addElement();
        System.out.println("Начальный массив " + arrayList);
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            int x = iterator.next();
            if ((x % 3) == 0 && x > 0) {
                    iterator.remove();
            }
        }
        System.out.println("Массив без чисел, которые делятся на 3: " + arrayList);
    }

    /*
    Задача 4: Очередь задач (ArrayDeque)
    Реализуйте систему обработки задач с приоритетом на ArrayDeque.
    • addTask(String task) — добавляет задачу в конец
    • addUrgentTask(String task) — добавляет задачу в начало
    • processTask() — удаляет и возвращает первую задачу
     */
    public static void queueTasks() {
        System.out.println("Задача №4. Очередь задач (ArrayDeque)");
        TasksDeque arrayDeque = new TasksDeque();
        arrayDeque.addTasks("Первая задача");
        arrayDeque.addTasks("Вторая задача");
        arrayDeque.addTasks("Третья задача");
        arrayDeque.addUrgentTask("Четвертая задача");
        arrayDeque.showTasks();
        arrayDeque.processTask();
        arrayDeque.processTask();
        arrayDeque.showTasks();
    }

    /*
    Задача 5: Проверка сбалансированности скобок (Stack)
    Реализуйте метод, который проверяет, правильно ли расставлены скобки ()[]{} в строке.
     */
    public static void balanceBrackets() {
        System.out.println("Задача 5: Проверка сбалансированности скобок (Stack)");
        String str1 = "()[]{}";
        String str2 = "([{}])";
        String str3 = "([}{])";
        System.out.println(checkBrackets(str1));
        System.out.println(checkBrackets(str2));
        System.out.println(checkBrackets(str3));
    }

    public static boolean checkBrackets(String strTemp) {
        Stack<Character> stack = new Stack<>();
        for (char c : strTemp.toCharArray()){
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }

                char temp = stack.pop();
                if(!checkSymbol(temp,c)) return false;

            }
        }
        return stack.isEmpty();
    }

    public static boolean checkSymbol(char start, char end) {
        return (start == '(' && end == ')') ||
                (start == '[' && end == ']') ||
                (start == '{' && end == '}');
    }

    /*
    Задача 6: Сортировка ArrayList без Collections.sort()
    Напишите метод, который сортирует ArrayList<Integer> пузырьковой сортировкой.
     */
    public static void sortArrayBubbles() {
        System.out.println("Задача 6: Сортировка ArrayList без Collections.sort()");
        ArrayList<Integer> arrayBubbles = addElement();
        System.out.println("First array: " + arrayBubbles);
        int buff;
        for (int i = 0; i < arrayBubbles.size() - 1; i++) {
            for (int j = i + 1; j < arrayBubbles.size(); j++) {
                if (arrayBubbles.get(i) > arrayBubbles.get(j)) {
                    buff = arrayBubbles.get(i);
                    arrayBubbles.set(i, arrayBubbles.get(j));
                    arrayBubbles.set(j, buff);
                }
            }
        }
        System.out.println("Sort array: " + arrayBubbles);
    }

    /*
    Задача 7: Обратный порядок слов (Stack)
    Дана строка "Hello world Java". Используйте Stack, чтобы перевернуть порядок слов.
     */
    public static void reverseWord() {
        System.out.println("Задача 7: Обратный порядок слов (Stack)");
        String str = "Hello world Java";
        System.out.println("Дана строка: " + str);
        String[] split = str.split(" ");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < split.length; i++) {
            stack.push(split[i]);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
