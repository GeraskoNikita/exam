package kg.geeks.game.logic;

import kg.geeks.game.players.*;

import java.util.Random;

public class RPG_Game {

    public static Random random = new Random();
    private static int roundNumber;

    public static void startGame() {
        Boss boss = new Boss("Goblin", 1000, 50);
        Gambler gambler = new Gambler("Loki", 300);
        Warrior warrior1 = new Warrior(
                "Heracles", 280, 15);
        Warrior warrior2 = new Warrior(
                "Achilles", 270, 20);
        Magic magic = new Magic("Vedmak", 290, 10);
        Berserk berserk = new Berserk("Guts", 260, 10);
        Medic doc = new Medic("Lekar", 250, 5, 15);
        Medic assistant = new Medic("Chilchak", 300, 5, 5);

        Hero[] heroes = {gambler,warrior1, doc, magic, warrior2, berserk, assistant};

        printStatistics(boss, heroes);
        while (!isGameOver(boss, heroes)) {
            playRound(boss, heroes);
        }
    }

    private static void playRound(Boss boss, Hero[] heroes) {
        roundNumber++;
        boss.chooseDefence();
        boss.attack(heroes);
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0 && boss.getHealth() > 0
                    && hero.getAbility() != boss.getDefence()) {
                hero.attack(boss);
                hero.applySuperPower(boss, heroes);
            }
        }
        printStatistics(boss, heroes);
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("ROUND " + roundNumber + " ------------------");
        System.out.println(boss);
        for (Hero hero : heroes) {
            System.out.println(hero);
        }
    }

    private static boolean isGameOver(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
            return true;
        }
        return false;
    }


}
