package Lesson12;

import java.util.*;

public class Homework12 {
    public static void main(String[] args) {
        groupAnagramm(); //Задача 1: Группировка анаграмм
        findFirstNumber(); //Задача 2: Поиск первого повторяющегося числа
        searchAllPairsNumber(); //Задача 3*: Поиск всех пар чисел, сумма которых равна заданному числу
    }

    /*
    Задача 1: Группировка анаграмм
    Дан список слов. Нужно сгруппировать слова, которые являются анаграммами.
    {"listen", "silent", "enlist", "java", "avaj", "world"}
     */
    public static void groupAnagramm() {
        System.out.println("Дан список слов. Нужно сгруппировать слова, которые являются анаграммами.");
        List<String> listString = new ArrayList<>();
        listString.add("listen");
        listString.add("silent");
        listString.add("avaj");
        listString.add("java");
        listString.add("enlist");
        listString.add("world");
        System.out.println("List: " + listString);

        Map<Integer, String> map = new HashMap();
        for (int i = 0; i < listString.size(); i++) {
            map.put(i, listString.get(i));
        }
        System.out.println("Map: " + map);

        List<String> temp = new ArrayList<>();

        for (String str : listString) {
            map.forEach((key,value) -> {
                if (isAnagramm(str, value)) {
                    temp.add(value);
                    map.replace(key, "isNull");
                }
            });
            if (!temp.isEmpty()) System.out.println(temp);
            temp.clear();
        }

    }

    public static boolean isAnagramm(String str1, String str2) {
        Map<Character, Integer> mapSymbol = new HashMap<>();
        if (str1.length() != str2.length()) {
            return false;
        } else {
            for (char strChar : str1.toLowerCase().toCharArray()) {
                int value = mapSymbol.getOrDefault(strChar, 0) + 1;
                mapSymbol.put(strChar, value);
            }

            for (char strChar : str2.toLowerCase().toCharArray()) {
                int value = mapSymbol.getOrDefault(strChar, 0) - 1;
                mapSymbol.put(strChar, value);
                if (mapSymbol.get(strChar) < 0) {
                    return false;
                }
            }
        }
        return true;
    }


    /*
    Задача 2: Поиск первого повторяющегося числа
    Дан список чисел, нужно найти первое число, которое повторяется.
     */
    public static void findFirstNumber() {
        System.out.println("Задача 2: Поиск первого повторяющегося числа");
        List<Integer> list = addList();
        System.out.println("List: " + list);

        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (Integer num : list) {
            int value = map.getOrDefault(num, 0) + 1;
            map.put(num, value);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("First duplicate number " + entry.getKey());
                break;
            }
        }

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
    Задача 3*: Поиск всех пар чисел, сумма которых равна заданному числу
    Дан массив чисел и целевое значение target. Нужно найти все пары чисел, сумма
    которых равна target.
     */
    public static void searchAllPairsNumber() {
        System.out.println("Задача 3*: Поиск всех пар чисел, сумма которых равна заданному числу. Введите число:");
        Scanner scanner = new Scanner(System.in);
        int target = 0;
        try {
            target = scanner.nextInt();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Random random = new Random();
        int[] arrayInt = new int[10];
        for (int i = 0; i < arrayInt.length; i++) {
            arrayInt[i] = random.nextInt(0, 10);
        }
        System.out.println("Массив чисел: " + Arrays.toString(arrayInt));

        List<int[]> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int num : arrayInt) {
            int rem = target - num;
            if (set.contains(rem)) {
                result.add(new int[]{num, rem});
            }
            set.add(num);
        }

        if (result.isEmpty()) {
            System.out.println("Нет пар");
        } else {
            for (int[] number : result) {
                System.out.println("[" + number[0] + ", " + number[1] + "]");
            }
        }

    }
}
