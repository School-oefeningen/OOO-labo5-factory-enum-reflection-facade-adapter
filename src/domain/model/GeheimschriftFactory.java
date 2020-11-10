package domain.model;

public class GeheimschriftFactory {

    public static GeheimschriftBehavior createGeheimschrift(String geheimschriftType) {
        GeheimschriftEnum geheimschriftEnum = GeheimschriftEnum.valueOf(geheimschriftType);
        String className = geheimschriftEnum.getClassName();
        GeheimschriftBehavior geheimschriftBehavior = null;

        try {
            Class newClass = Class.forName(className);
            Object newObject = newClass.newInstance();
            geheimschriftBehavior = (GeheimschriftBehavior) newObject;
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return geheimschriftBehavior;
    }
}
