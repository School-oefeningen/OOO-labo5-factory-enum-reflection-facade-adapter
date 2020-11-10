package domain.model;

import util.Checker;

public class Geheimschrift {
    GeheimschriftBehavior geheimschriftBehavior;

    public Geheimschrift(){
    }

    public void setGeheimschriftBehavior(GeheimschriftBehavior geheimschriftBehavior) {
        if (geheimschriftBehavior == null) throw new IllegalArgumentException("geheimschriftBehavior mag niet null zijn");
        this.geheimschriftBehavior = geheimschriftBehavior;
    }

    public String decryptString(String s) {
        if (Checker.isEmptyString(s)) throw new IllegalArgumentException("String mag niet leeg of null zijn");
        return geheimschriftBehavior.decodeer(s);
    }

    public String encryptString(String s) {
        if (Checker.isEmptyString(s)) throw new IllegalArgumentException("String mag niet leeg of null zijn");
        return geheimschriftBehavior.codeer(s);
    }
}
