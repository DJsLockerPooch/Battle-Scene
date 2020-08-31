package battlescene;

public class Hero {

    static int getTotalDamage() {
        return totalHeroHitPointsLost;
    }

    private String name;
    private int hitPoints;
    private int strength;
    private int agility;

    public static int totalHeroHitPointsLost;

    public Hero(String heroName, int heroStrength, int HeroAgility) {
        this.name = heroName;
        this.strength = heroStrength;
        this.agility = HeroAgility;
        hitPoints = 20;
    }

    public String getName() {
        return name;
    }

    public int getHP() {
        return hitPoints;
    }

    public int getStrength() {
        return strength;
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

    public void getHit(Villain villain) {
        if (hitPoints >= 0) {
            int didDodge = (int) (Math.random() * 100) + 1;
            if (didDodge <= agility) {
                System.out.println("\n" + name + " dodged " + villain.getName() + "'s attack and took no damage! "
                        + didDodge + " " + agility);
            } else if (didDodge >= 100 - agility) {
                System.out.print("\nOh no! " + name + " has been critically hit!");
                hitPoints -= 4;
                totalHeroHitPointsLost += 4;
                System.out.println("\n" + villain.getName() + " hit " + name + "! " + name
                        + " has " + hitPoints + " HP left.");
            } else {
                hitPoints -= 2;
                System.out.println("\n" + villain.getName() + " hit " + name + "! " + name
                        + " has " + hitPoints + " HP left.");
                totalHeroHitPointsLost += 2;

            }
        }
        isKOd();
    }

}
