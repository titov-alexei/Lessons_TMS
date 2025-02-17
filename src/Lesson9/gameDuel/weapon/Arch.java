package Lesson9.gameDuel.weapon;

import java.util.Random;

public class Arch extends Weapon{
    public Arch(int damage, Random rand) {
        super(damage, rand);
    }

    @Override
    public int getDamage() {
        int crit = getRandom().nextInt(0, 1);
        return super.getDamage() + crit;
    }
}
