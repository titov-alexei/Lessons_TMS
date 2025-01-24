import java.util.Scanner;

public class Lesson4 {

    public static void main(String[] args) {
        changeString();
    }

    /* Исправление
    Напишите программу, которая принимает строку и переставляет слова в обратном
    порядке, используя только методы String и StringBuilder.
    */
    public static void changeString () {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        StringBuilder sb = new StringBuilder();
        StringBuilder sbResult = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
            if (str.charAt(i) == ' ') {
                sbResult.append(sb.reverse());
                sb.setLength(0);
            }
        }
        sbResult.append(' ').append(sb.reverse());
        System.out.println(sbResult.toString().trim());
    }
}
