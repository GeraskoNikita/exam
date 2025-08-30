package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Warrior extends Hero {
    public Warrior(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.CRITICAL_DAMAGE);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int crit = (RPG_Game.random.nextInt(4) + 2) * this.getDamage(); // 2,3,4,5
        boss.setHealth(boss.getHealth() - crit);
        System.out.println("Warrior " + this.getName()
                + " hit critically " + crit);
    }

    @Override
    public String toString() {
        return "⚔️" +this.getName() + " health: " + this.getHealth() + " damage: " + this.getDamage();
    }
}

