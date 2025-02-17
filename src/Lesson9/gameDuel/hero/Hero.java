package Lesson9.gameDuel.hero;

import Lesson9.gameDuel.armor.Armor;
import Lesson9.gameDuel.weapon.Weapon;

import java.util.Random;

public abstract class Hero {
    private String name;
    private int hp;
    private Armor armor;
    private Weapon weapon;
    private Random random = new Random();
    public int countCritHero = 2; //Добавление счетчика крит урона

    Hero(String name, int hp, Armor armor, Weapon weapon) {
        this.name = name;
        this.hp = hp;
        this.armor = armor;
        this.weapon = weapon;
    }

    public int attack(int diceResult) {
        return weapon.getDamage() + diceResult;
    }

    public int critAttack() {
        return weapon.getDamage() + random.nextInt(2, 4);
    }

    public void getDamage(int damage) {
        int finalDamage = armor.getDamage(damage);
        hp -= finalDamage;
        System.out.printf("Герой %s урон получил %d, hp осталось: %d\n", name, finalDamage, hp);
    }

    public boolean isLife() {
        return hp > 0;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }
}
