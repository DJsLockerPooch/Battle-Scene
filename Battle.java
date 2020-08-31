package battlescene;

import java.util.ArrayList;

public class Battle {

    // Creation of arrays
    private ArrayList<Hero> heroList;
    private ArrayList<Villain> villainList;

    //Variables used throughout program
    int heroCount;
    int villainCount;
    int heroSize;
    int villainSize;

    public Battle() {
        heroList = new ArrayList<>();
        villainList = new ArrayList<>();
    }

    public void addHero(Hero h) {
        //Sometimes it seems that the array.size() doesn't have the correct integer
        //so I created a variable to determine the size of the array
        heroList.add(h);
        heroCount++;
        heroSize++;
    }

    public void addVillain(Villain v) {
        villainList.add(v);
        villainCount++;
        villainSize++;
    }

    public int getHeroCount() {
        return heroCount;
    }

    public int getVillainCount() {
        return villainCount;
    }

    public Hero getHero(int i) {
        Hero hero = heroList.get(i);
        return hero;
    }

    public Villain getVillain(int i) {
        Villain villain = villainList.get(i);
        return villain;
    }

    public void doBattle() {
        //Using the size variable from earlier to simplify while statement
        while (!(heroSize == 0 || villainSize == 0)) {
            int heroIndex = (int) (Math.random() * heroSize);
            int villainIndex = (int) (Math.random() * villainSize);
            Hero hero = heroList.get(heroIndex);
            Villain villain = villainList.get(villainIndex);
            hero.getHit(villain);
            if (hero.isKOd() == true) {
                System.out.println(hero.getName() + " has been knocked out!");
                heroList.remove(hero);
                heroSize--;
                heroIndex = (int) (Math.random() * heroSize);
                hero = heroList.get(heroIndex);
            }
            villain.getHit(hero);
            if (villain.isKOd() == true) {
                System.out.println(villain.getName() + " has been knocked out!");
                villainList.remove(villain);
                villainSize--;
            }
        }

        //Using the size variables to make an else-if statement that will determine which team(s) won
        if (heroSize == 0) {
            System.out.println("\nGAME OVER! The villains have won!\n");
            System.out.println("The heroes did " + Villain.getTotalDamage() + " damage to the villains.");
            System.out.println("The villains did " + Hero.getTotalDamage() + " damage to the heroes.");
        } else if (villainSize == 0) {
            System.out.println("\nGAME OVER! The heroes have won!\n");
            System.out.println("The heroes did " + Villain.getTotalDamage() + " damage to the villains.");
            System.out.println("The villains did " + Hero.getTotalDamage() + " damage to the heroes.");
        } else if (villainSize == 0 && heroSize == 0) {
            System.out.println("\nGAME OVER! The game ended in a draw!\n");
            System.out.println("The heroes did " + Villain.getTotalDamage() + " damage to the villains.");
            System.out.println("The villains did " + Hero.getTotalDamage() + " damage to the heroes.");
        }
    }

}
