package kg.geeks.game.players;

public class Medic extends Hero {
    private final int healPoints;

    public Medic(String name, int health, int damage, int healPoints) {
        super(name, health, damage, SuperAbility.HEAL);
        this.healPoints = healPoints;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0 && hero != this) {
                hero.setHealth(hero.getHealth() + healPoints);
            }
        }
    }

    @Override
    public String toString() {
        return "💊 " +this.getName() + " health: " + this.getHealth() + " damage: " + this.getDamage();
    }
}
