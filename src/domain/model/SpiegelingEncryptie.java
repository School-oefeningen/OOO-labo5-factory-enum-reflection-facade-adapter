package domain.model;

public class SpiegelingEncryptie implements GeheimschriftBehavior {

    @Override
    public String decodeer(String s) {
        return codeer(s);
    }

    @Override
    public String codeer(String s) {
        StringBuilder mirror = new StringBuilder();
        return mirror.append(s).reverse().toString();
    }
}
