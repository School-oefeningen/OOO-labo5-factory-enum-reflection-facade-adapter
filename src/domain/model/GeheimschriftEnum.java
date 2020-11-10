package domain.model;

public enum GeheimschriftEnum {
    Caesar ("domain.model.CaesarEncryptie"),
    Spiegeling ("domain.model.SpiegelingEncryptie"),
    RandomKarakter ("domain.model.RandomKaraktersEncryptie");

    private final String className;

    GeheimschriftEnum(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }
}
