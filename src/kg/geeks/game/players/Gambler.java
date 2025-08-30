package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Gambler extends Hero {
    private Dice diceOne = new Dice(6);
    private Dice diceTwo = new Dice(6);

    public Gambler(String name, int health) {
        super(name, health, 0, SuperAbility.Luck);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int resultFirstDice = diceOne.rotate();
        int resultSecondDice = diceTwo.rotate();
        int result = resultFirstDice + resultSecondDice;
        System.out.println("Лудоман бросает кости... 🎲🎲 "
                + resultFirstDice + " и " + resultSecondDice + " Итого: " + result);
        if (resultFirstDice == resultSecondDice) {
            boss.setHealth(boss.getHealth() - result);
            System.out.println("Лудоман  нанес " + result + ".единиц  урона Боссу " + boss.getName() + " !");


        } else {
            int counter = 0;
            while (counter < heroes.length) {
                counter++;
                Hero hero = heroes[RPG_Game.random.nextInt(heroes.length)];
                if (hero.getHealth() > 0 && hero != this) {
                    hero.setHealth(hero.getHealth() - result);
                    System.out.println("Лудоман  нанес " + result + ".единиц урона герою " + hero.getName() + "!");

                    break;
                }
            }


        }
    }

    @Override
    public String toString() {
        return "🎲 " + this.getName() + " health: " + this.getHealth() + " damage: " + this.getDamage();
    }
}

class Dice {
    private int sides;

    public Dice(int sides) {
        this.sides = sides;
    }

    public int rotate() {
        return RPG_Game.random.nextInt(this.sides) + 1;
    }
}


