package Lesson8.Homework8;

public class Food extends Products implements Product{
    //Нет скидок
    Food(String name, double price){
        super(name, price);
    }

    @Override
    public double getFinalPrice() {
        return price;
    }
}
