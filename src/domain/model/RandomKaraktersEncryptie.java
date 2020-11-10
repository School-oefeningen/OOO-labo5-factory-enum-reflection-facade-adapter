package domain.model;

import domain.RandomCypher;

public class RandomKaraktersEncryptie implements GeheimschriftBehavior {
    private RandomCypher randomCypher = new RandomCypher();

    public RandomKaraktersEncryptie() {}

    @Override
    public String decodeer(String s) {
        char[] chars = randomCypher.decypher(s.toCharArray());
        return new String(chars);
    }

    @Override
    public String codeer(String s) {
        char[] chars = randomCypher.encypher(s.toCharArray());
        return new String(chars);
    }
}
