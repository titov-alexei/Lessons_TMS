package Lesson12;

import java.util.*;

public class Lesson12 {
    public static void main(String[] args) {
        findWord();  //Задача 1. Подсчет количества слов в тексте
        findFirstSymbol(); //Задача 2. Найти первый неповторяющийся символ в строке
        checkIsAnagramm(); //Задача 3. Проверка анаграмм
        uniteTwoMap(); //Задача 4. Объединение двух Map с суммированием значений
        checkList(); //Задача 5. Проверка на уникальность элементов списка
        searchInTwoList(); //Задача 6. Найти пересечение двух списков
        twoSets(); //Задача 7. Найти разницу между двумя множества
        checkTwoSets(); //Задача 8. Проверка, является ли одно множество подмножеством другого
        searchDuplicateList();  //Задача 9. Найти дубликаты в списке и их количество
        countSymbolInString(); //Задача 10. Подсчет частоты символов в строке (без регистра)
    }

    /*
    Задача 1: Подсчет количества слов в тексте
    Подсчитать количество вхождений каждого слова в тексте.
     */
    public static void findWord() {
        System.out.println("Задача 1. Подсчет количества слов в тексте");
        String string = "Привет пока привет";
        String[] array = string.toLowerCase().split(" ");
        Map<String, Integer> counter = new HashMap<>();
        for (String element : array) {
            int value = counter.getOrDefault(element, 0) + 1;
            counter.put(element, value);
        }
        System.out.println(counter);
    }

    /*
    Задание №2.
    Найти первый неповторяющийся символ в строке
    Найти первый уникальный символ.
     */
    public static void findFirstSymbol() {
        System.out.println("Задача №2. Найти первый неповторяющийся символ в строке\nВведите строку");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().toLowerCase();
        if (str.isBlank()) return;
        System.out.println(str);

        Map<Character, Integer> mapSymbol = new LinkedHashMap<>();
        for (char strChar : str.toCharArray()) {
            int value = mapSymbol.getOrDefault(strChar, 0) + 1;
            mapSymbol.put(strChar, value);
        }

        for (Map.Entry<Character, Integer> entry : mapSymbol.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println("Symbol " + entry.getKey());
                break;
            }
        }

    }

    /*
    Задача 3: Проверка анаграмм
    Определить, являются ли две строки анаграммами.
     */
    public static void checkIsAnagramm() {
        System.out.println("Задача 3. Проверка анаграмм");
        String str1 = "Локомотив";
        String str2 = "Молоковит";
        System.out.println("Строка 1 = " + str1 + "\nСтрока 2 = " + str2);
        boolean result = true;
        Map<Character, Integer> mapSymbol = new HashMap<>();
        if (str1.length() != str2.length()) {
            result = false;
        } else {
            for (char strChar : str1.toLowerCase().toCharArray()) {
                int value = mapSymbol.getOrDefault(strChar, 0) + 1;
                mapSymbol.put(strChar, value);
            }

            for (char strChar : str2.toLowerCase().toCharArray()) {
                int value = mapSymbol.getOrDefault(strChar, 0) - 1;
                mapSymbol.put(strChar, value);
                if (mapSymbol.get(strChar) < 0) {
                    result = false;
                    break;
                }
            }
        }
        System.out.println(result? "Анаграмма" : "Не анаграмма");
    }

    /*
    Задача 4: Объединение двух Map с суммированием значений
    Объединить Map<String, Int>, суммируя повторяющиеся ключи.
     */
    public static void uniteTwoMap() {
        System.out.println("Задача 4. Объединение двух Map с суммированием значений");
        Map<String, Integer> mapFirst = addMap();
        Map<String, Integer> mapSecond = addMap();
        System.out.println("FirstMap: " + mapFirst);
        System.out.println("SecondMap: " + mapSecond);

        mapFirst.forEach((key, value) -> {
                if (mapSecond.containsKey(key)) {
                    value += mapSecond.get(key);
                    mapSecond.replace(key, value);
                }
                });
        System.out.println("Unit: " + mapSecond);
    }

    public static Map<String, Integer> addMap() { //Метод рандомного создания Map
        Random random = new Random();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            int value = map.getOrDefault("str", 0) + random.nextInt(0, 10);
            String str = "str" + (i + 1);
            map.put(str, value);
        }
        return map;
    }

    /*
    Задача 5: Проверка на уникальность элементов списка
    Проверить, содержит ли List<Int> только уникальные элементы.
     */
    public static void checkList() {
        System.out.println("Задача 5. Проверка на уникальность элементов списка");
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            list.add(random.nextInt(0,100));
        }
        System.out.println("List: " + list);

        Map<Integer, Integer> map = new HashMap<>();
        boolean result = true;
        for (Integer num : list) {
            if (!map.containsKey(num)) {
                map.put(num, num);
            } else result = false;
        }
        System.out.println(result?"Все элементы уникальны" : "Элементы не уникальны");
     }

    /*
    Задача 6: Найти пересечение двух списков
    Найти общие элементы двух List<Int>.
     */
    public static void searchInTwoList() {
        System.out.println("Задача 6. Найти пересечение двух списков");
        List<Integer> firstList = addList();
        List<Integer> secondList = addList();
        System.out.println("First list: " + firstList + "\nSecond List: " + secondList);

        Map<Integer, Integer> map = new HashMap<>();

        for (Integer number : firstList) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (Integer num : secondList) {
            if (map.containsKey(num) && map.get(num) > 0) {
                list.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        System.out.println("Общие элементы " + list);
    }

    public static List<Integer> addList() {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(0, 10));
        }
        return list;
    }

    /*
    Задача 7: Найти разницу между двумя множества
    Найти элементы, которые есть в первом множестве, но отсутствуют во втором.
     */
    public static void twoSets() {
        System.out.println("Задача 7. Найти разницу между двумя множествами");
        Map<String, Integer> firstMap = addMap();
        Map<String, Integer> secondMap = addMap();
        System.out.println("FirstMap: " + firstMap);
        System.out.println("SecondMap: " + secondMap);

        List<Integer> list = new ArrayList<>();
        firstMap.forEach((key,value) -> {
            if (!secondMap.containsValue(value)) {
                list.add(value);
            }
                }
                );

        System.out.println("Эти элементы есть в первом множестве, но отсутствуют во втором: " + list);
    }

    /*
    Задача 8: Проверка, является ли одно множество подмножеством другого
    Проверить, является ли set1 подмножеством set2.
     */
    public static void checkTwoSets() {
        System.out.println("Задача 8. Проверка, является ли одно множество подмножеством другого");
        Map<String, Integer> set1 = new HashMap<>();
        Map<String, Integer> set2 = new HashMap<>();

        set1.put("first", 4);
        set1.put("second", 1);
        set1.put("third", 5);

        set2.put("first", 1);
        set2.put("second", 2);
        set2.put("third", 5);
        set2.put("fourth", 4);


        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);

        List<Integer> result = new ArrayList<>();
        set2.forEach((key, value) -> {
                    if (set1.containsValue(value)) {
                        result.add(value);
                        set2.replace(key, -1);
                    }
                }
                );

        System.out.println((result.size() == set1.size()) ? "Set1 является подмножеством set2" : "Set1 не является подмножеством set2");
    }

    /*
    Задача 9: Найти дубликаты в списке и их количество
    Найти дубликаты и их количество.
     */
    public static void searchDuplicateList() {
        System.out.println("Задача 9. Найти дубликаты в списке и их количество");
        List<Integer> list = addList(); //Заполняем лист из метода задания №6
        System.out.println("Список: " + list);

        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : list) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        map.forEach((key, value) -> {
            if(value > 1) {
                System.out.println("Элемент " + key + " повторяется " + value + " раз");
            }
                }
                );
    }

    /*
    Задача 10: Подсчет частоты символов в строке (без регистра)
    Подсчитать частоту символов в строке.
     */
    public static void countSymbolInString() {
        System.out.println("Задача 10. Подсчет частоты символов в строке (без регистра)\nВведите строку");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().toLowerCase();
        if (str.isBlank()) return;

        Map<Character, Integer> mapSymbol = new HashMap<>();
        for (char strChar : str.toCharArray()) {
            int value = mapSymbol.getOrDefault(strChar, 0) + 1;
            mapSymbol.put(strChar, value);
        }
        mapSymbol.forEach((key, value) -> {
                        System.out.println("Символ " + key + " повторяется " + value + " раз");
                }
        );
    }
}
