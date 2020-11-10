package domain.model;

import java.util.ArrayList;
import java.util.List;

public class GeheimschriftFacade {
    Geheimschrift geheimschrift = new Geheimschrift();

    public GeheimschriftFacade() {
    }

    public String encryptString(String input) {
        return geheimschrift.encryptString(input);
    }

    public String decryptString(String input) {
        return geheimschrift.decryptString(input);
    }

    public void setGeheimschriftBehaviour(String encryptieType, String caesarGetal) {
        GeheimschriftBehavior geheimschriftBehavior = GeheimschriftFactory.createGeheimschrift(encryptieType);

        if (geheimschriftBehavior instanceof CaesarEncryptie) {
            try {
                ((CaesarEncryptie) geheimschriftBehavior).setStart(Integer.parseInt(caesarGetal));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        geheimschrift.setGeheimschriftBehavior(geheimschriftBehavior);
    }

    public List<String> getAllEncryptionTypes() {
        List<String> allGeheimschrift = new ArrayList<>();
        for (GeheimschriftEnum geheimschriftEnum: GeheimschriftEnum.values()) {
            allGeheimschrift.add(geheimschriftEnum.toString());
        }
        return allGeheimschrift;
    }
}
