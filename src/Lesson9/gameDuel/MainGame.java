package Lesson9.gameDuel;

import Lesson9.gameDuel.armor.*;
import Lesson9.gameDuel.hero.*;
import Lesson9.gameDuel.weapon.*;
import java.util.Random;
import java.util.Scanner;

/*
Задача 1: Игра дуэль
Напишите консольную игру, где игроки сражаются, по очереди бросая кубик. Всего в игре может быть 3
класса (паладин, разбойник и лучник). У каждого класса должно быть здоровье, броня и оружие. Оружие
должно иметь собственный параметр атаки. Броня имеет защиту, которая блокирует урон, но ее прочность
снижается после каждого блока. Игроки могут выбрать класс, за который они хотят играть. Проигрывает
тот, у кого первым кончилось здоровье.

Добавьте игровое поле, которое само будет содержать кубик и само регулировать ход игры.
Добавьте возможность нанести критический урон, критический промах и полное блокирование
урона (сделать это таким образом, чтобы пользователь мог сам выбирать критический урон, но
сделать ограниченное кол-во таких атак)
 */

public class MainGame {
    public static void main(String[] args) {
        Random random = new Random();
        Hero player1 = chooceYourHero(random); //Выбор персонажа1 и ввод имени
        Hero player2 = chooceYourHero(random); //Выбор персонажа2 и ввод имени
        Dice dice1 = new Dice(random);
        Dice dice2 = new Dice(random);
        Field field = new Field(player1, player2, dice1, dice2); //Создание поля и передача в него игроков с кубиками
        field.startGame(); //Начало игры.

    }

    public static Hero chooceYourHero(Random rand) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя персонажа:");
        String nameHero = scanner.nextLine();
        System.out.println("Введите число от 1 до 3, где 1 - Паладин, 2 - Разбойник, 3 - Лучник");
        int result = scanner.nextInt();
        switch (result) {
            case 1 :
                return new Paladin(nameHero, 40, new HardArmor(20, 5), new Sword(5, rand));
            case 2 :
                return new Rogue(nameHero, 30, new MediumArmor(10, 5), new Dagger(10, rand));
            case 3 :
                return new Archer(nameHero, 20, new LightArmor(5, 10), new Arch(20, rand));
            default:
                return null;
        }
    }
}
