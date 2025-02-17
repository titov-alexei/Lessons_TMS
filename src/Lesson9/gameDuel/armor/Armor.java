package Lesson9.gameDuel.armor;

public abstract class Armor {
    private int armorRating;
    private int durability;

    Armor(int armorRating, int durability) {
        this.armorRating = armorRating;
        this.durability = durability;
    }

    public int getDamage(int damage) {
        System.out.println("Прочность щита была: " + durability);
        if (durability <= 0) return damage;
        durability -= 1;
        System.out.println("Осталось прочности " + durability + " ArmorRating = " + armorRating);
        return Math.max(damage - armorRating, 0);
    }
}
