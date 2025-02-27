package Lesson8.Homework8;

public class Clothing extends Products implements Product{
    //Имеент скидку в 15%
    Clothing (String name, double price) {
        super(name, price);
    }

    @Override
    public double getFinalPrice() {
        return price * 0.85;
    }
}
