package Leeson7;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //private доступ только нутри класса
    //public доступен извне
    public int getAge() {
        return age;
    }
}
