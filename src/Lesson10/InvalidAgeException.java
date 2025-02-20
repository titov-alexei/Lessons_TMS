package Lesson10;

public class InvalidAgeException extends Exception {
    private int age;

    InvalidAgeException(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Возраст " + age + " не является реальным!";
    }
}
