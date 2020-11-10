package domain.model;

public class CaesarEncryptie implements GeheimschriftBehavior {
    private int offset;
    private char[] alfabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public CaesarEncryptie() {}

    public void setStart(int offset) {
        this.offset = offset;
    }

    @Override
    public String decodeer(String s) {
        String result="";
        for (int i = 0; i < s.length(); i++) {
            result += Character.toString((char) ((((int)s.charAt(i)-offset-97+26)%26)+97));
        }
        return result;
    }

    @Override
    public String codeer(String s) {
        String result="";
        for (int i = 0; i < s.length(); i++) {
            result += Character.toString((char) ((((int)s.charAt(i)+offset-97+26)%26)+97));
        }
        return result;
    }
}
