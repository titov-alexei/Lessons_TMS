package Lesson8.Homework8;

abstract class Products implements Product{
    protected String name;
    protected double price;

    Products(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
