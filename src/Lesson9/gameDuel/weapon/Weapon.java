package Lesson9.gameDuel.weapon;

import java.util.Random;

public abstract class Weapon {
    private int damage;
    private Random rand;

    Weapon(int damage, Random rand) {
        this.damage = damage;
        this.rand = rand;
    }

    public int getDamage(){
        return rand.nextInt(0 , damage);
    }

    public Random getRandom() {
        return rand;
    }


}
