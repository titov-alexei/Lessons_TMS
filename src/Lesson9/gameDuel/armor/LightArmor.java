package Lesson9.gameDuel.armor;

import java.util.Random;

public class LightArmor extends Armor{
    private Random rand;

    public LightArmor(int armorRating, int durability) {
        super(armorRating, durability);
        rand = new Random();
    }

    @Override
    public int getDamage(int damage) {
        return super.getDamage(damage) - rand.nextInt(0 ,2);
    }
}
