package battlescene;

public class Main {

    public static void main(String[] args) {
        Battle b = new Battle();
        b.addHero(new Hero("Superman", 8, 15));
        b.addHero(new Hero("Batman", 5, 10));
        b.addHero(new Hero("Spider-man", 6, 15));
        b.addVillain(new Villain("The Joker", 10));
        b.addVillain(new Villain("Lex Luthor", 5));
        b.addVillain(new Villain("The Penguin", 20));
        b.addVillain(new Villain("Two-Face", 10));
        b.addVillain(new Villain("Catwoman", 15));
        b.addVillain(new Villain("The Riddler", 10));
        b.doBattle();

    }
}
