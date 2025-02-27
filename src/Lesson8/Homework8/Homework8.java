package Lesson8.Homework8;

public class Homework8 {

    public static void main(String[] args) {
        System.out.println("Домашнее задание №8");
        Product[] arrayProduct = new Product[3];

        Electronics phone1 = new Electronics("Телефон", 100.13);
        Food food1 = new Food("Хлеб", 13.4);
        Clothing dress1 = new Clothing("Платье", 55);

        Products[] arrayProducts = new Products[3];
        arrayProducts[0] = phone1;
        arrayProducts[1] = food1;
        arrayProducts[2] = dress1;
        for (Products product : arrayProducts) {
            System.out.println("Товар: " + product.name + " Цена: " + product.price + " / Конечная цена: " + product.getFinalPrice());
        }
    }

}
