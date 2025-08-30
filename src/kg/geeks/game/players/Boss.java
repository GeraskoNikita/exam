package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Boss extends GameEntity {
    private SuperAbility defence;

    public Boss(String name, int health, int damage) {
        super(name, health, damage);
    }

    public void chooseDefence() {
        SuperAbility[] variants = SuperAbility.values();
        // [CRITICAL_DAMAGE, BOOST, BLOCK_REVERT, HEAL]
        int randomIndex = RPG_Game.random.nextInt(variants.length);
        this.defence = variants[randomIndex];
    }

    public void attack(Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                if (heroes[i] instanceof Berserk &&
                        this.defence != SuperAbility.BLOCK_REVERT) {
                    int block = (RPG_Game.random.nextInt(2) + 1) * 5; // 5, 10
                    ((Berserk) heroes[i]).setBlockedDamage(block);
                    heroes[i].setHealth(heroes[i].getHealth()
                            - (this.getDamage() - block));
                } else {
                    heroes[i].setHealth(heroes[i].getHealth() - this.getDamage());
                }
            }
        }
    }

    public SuperAbility getDefence() {
        return defence;
    }

    @Override
    public String toString() {
        return "👹 " +"BOSS " + super.toString() + " defence: " + this.defence;
    }
}
