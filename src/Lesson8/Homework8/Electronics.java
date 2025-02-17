package Lesson8.Homework8;

public class Electronics extends Products implements Product {
    //Имеет скидку в 10%
    Electronics(String name, double price) {
        super(name, price);
    }

    @Override
    public double getFinalPrice() {
        return price * 0.9;
    }
}
