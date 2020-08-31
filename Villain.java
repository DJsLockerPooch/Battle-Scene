package battlescene;

public class Villain {

    static int getTotalDamage() {
        return totalVillainHitPointsLost;
    }

    private String name;
    private int hitPoints;
    private int strength;
    private int agility;

    private static int totalVillainHitPointsLost;

    public Villain(String villainName, int villainAgility) {
        this.name = villainName;
        this.agility = villainAgility;
        hitPoints = 20;
    }

    public String getName() {
        return name;
    }

    public int getHP() {
        return hitPoints;
    }

    public boolean isKOd() {
        boolean kod = false;
        if (getHP() <= 0) {
            kod = true;
            return kod;
        } else {
            return kod;
        }

    }

    public void getHit(Hero hero) {
        int heroStrength = hero.getStrength();

        int didDodge = (int) (Math.random() * 100) + 1;
        if (didDodge <= agility) {
            System.out.println(name + " dodged " + hero.getName() + "'s attack and took no damage!");
        } else if (didDodge >= 100 - agility) {
            System.out.println("Oh no! " + name + " has been critically hit!");
            hitPoints -= 2 * heroStrength;
            totalVillainHitPointsLost += 2 * heroStrength;
            System.out.print(name + " was hit by " + hero.getName() + " for " + 2 * heroStrength + " damage! "
                    + name + " has " + hitPoints + " HP left!\n");
        } else {
            hitPoints -= heroStrength;
            System.out.println(name + " was hit by " + hero.getName() + " for " + heroStrength + " damage! "
                    + name + " has " + hitPoints + " HP left!");
            totalVillainHitPointsLost += heroStrength;

        }
    }

}
