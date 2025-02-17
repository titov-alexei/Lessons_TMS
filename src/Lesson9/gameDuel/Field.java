package Lesson9.gameDuel;

import Lesson9.gameDuel.hero.Hero;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

//Добавление поля с передачей героев и для каждого свой кубик.
public class Field {
    private Hero hero1;
    private Hero hero2;
    private Dice diceHero1;
    private Dice diceHero2;
    private Scanner scanner = new Scanner(System.in);

    Field(Hero hero1, Hero hero2, Dice diceHero1, Dice diceHero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
        this.diceHero1 = diceHero1;
        this.diceHero2 = diceHero2;
    }

    public void startGame() {
        List<Hero> heroList = new ArrayList<>();
        System.out.println("----------Начало игры-----------");
        System.out.print("Нажмите Enter чтобы начать");
        scanner.nextLine();

        //Определение кто ходит первый
        if (diceHero2.roll() > diceHero1.roll()) {
            System.out.println("Первый ход за " + hero2.getName());
            heroList = List.of(hero2, hero1);
        }
        else {
            System.out.println("Первый ход за " + hero1.getName());
            heroList = List.of(hero1, hero2);
        }

        //Начало хода
        while (hero1.isLife() && hero2.isLife()) {

            takeTurn(heroList);
            if (!hero2.isLife()) {
                System.out.println("Герой " + hero2.getName() + " погиб");
                break;
            }

            takeTurn(heroList.reversed());
            if (!hero1.isLife()) {
                System.out.println("Герой " + hero1.getName() + " погиб");
                break;
            }
        }

        System.out.println("\nИгра окончена!");
        if (hero1.isLife()) {
            System.out.println(hero1.getName() + " победил!");
        } else {
            System.out.println(hero2.getName() + " победил!");
        }
    }

    public void takeTurn(List<Hero> list) {
        System.out.println("Ход " + list.getFirst().getName());
        int count = list.getFirst().countCritHero;
        int critDamage;
        int damage = 0;
        int selected;
        //Если есть шансы на крит, то у пользователя будет выбор
        if (count > 0) {
            System.out.println("У героя " + list.getFirst().getName() + " есть " + count + " крита. Используем? (Введите 1 - ДА, 2 - НЕТ)");
            selected = scanner.nextInt();
            switch (selected) {
                case 1 : {
                    critDamage = list.getFirst().critAttack();
                    list.getFirst().countCritHero--;
                    damage = list.getFirst().attack(new Dice(new Random()).roll()) + critDamage;
                    break;
                }
                case 2 : {
                    damage = list.getFirst().attack(new Dice(new Random()).roll());
                    break;
                }
                default: {
                    System.out.println("Вы ввели неверное значение!");
                }
            }
        } else {
            System.out.println("Крит урона не осталось");
            damage = list.getFirst().attack(new Dice(new Random()).roll());
        }

        System.out.println("Урон = " + damage);
        list.getLast().getDamage(damage);
        System.out.println("-----------------------------------");
    }




}
