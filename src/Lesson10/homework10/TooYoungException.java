package Lesson10.homework10;

public class TooYoungException extends Exception {
    private int age;

    TooYoungException(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Возраст " + age + " меньше 18";
    }
}
