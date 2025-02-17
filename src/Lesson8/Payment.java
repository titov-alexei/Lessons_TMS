package Lesson8;
/*
Создай абстрактный класс Payment с методом processPayment().
Затем реализуй два подкласса: CreditCardPayment и PayPalPayment.

Требования:

Класс Payment должен содержать общие поля (amount, currency) и абстрактный метод processPayment().
CreditCardPayment должен обрабатывать оплату картой.
PayPalPayment должен обрабатывать оплату через PayPal.
В main() создай список платежей и обработай их.
 */
abstract class Payment {
    public double amount;
    public String currency;

    Payment(double amount, String currency){
        this.amount = amount;
        this.currency = currency;
    }

    abstract void processPayment();
}

class CreditCardPayment extends Payment {

    CreditCardPayment(double amount, String currency) {
        super(amount, currency);
    }

    @Override
    void processPayment() {
        System.out.println("Оплата " + amount + " Валюта " + currency + " CreditCard");
    }
}

class PayPalPayment extends Payment {

    PayPalPayment(double amount, String currency) {
        super(amount, currency);
    }

    @Override
    void processPayment() {
        System.out.println("Оплата " + amount + " Валюта " + currency + " PayPalPayment");
    }
}

class Main {
    public static void main(String[] args) {
        Payment[] array = new Payment[2];
        CreditCardPayment credit1 = new CreditCardPayment(2.0, "EUR");
        PayPalPayment pp1 = new PayPalPayment(10,"USD");
        array[0] = credit1;
        array[1] = pp1;
        for (int i = 0; i < array.length; i++) {
            array[i].processPayment();
        }
    }
}
