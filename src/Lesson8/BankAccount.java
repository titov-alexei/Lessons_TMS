package Lesson8;

import java.util.Scanner;

public class BankAccount {
    private double balance;
    private String accountNumber;

    BankAccount(double balance, String accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    void deposit(double amount) {
        balance += amount;
    }

    void withdraw(double amount) {
        if (amount > balance) System.out.println("У вас недостаточно средств");
        else {
            balance -= amount;
            //System.out.println("Ваш баланс теперь равен " + balance);
        }
    }

    double getBalance() {
        return balance;
    }

}

class MainBank {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount(0, "12345A");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Первоначальный счет: " + acc1.getBalance());
        System.out.println("Введите сумму депозита:");
        double cashIn = scanner.nextDouble();
        acc1.deposit(cashIn);
        System.out.println("После депозита " + acc1.getBalance() + "\nВведите сумму для снятия:");
        double cashOut = scanner.nextDouble();
        acc1.withdraw(cashOut);
        System.out.println("После снятия " + acc1.getBalance());

    }
}
