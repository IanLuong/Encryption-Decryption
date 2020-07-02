package encryptdecrypt;

public class UnicodeAlgorithm extends Algorithm {

    public UnicodeAlgorithm(int key) {
        super(key);
    }

    @Override
    public String encryptMessage(String message) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            int characterValue = (int) message.charAt(i) + key;
            stringBuilder.append((char) characterValue);
        }
        return stringBuilder.toString();
    }
    @Override
    public String decryptMessage(String message) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            int characterValue = (int) message.charAt(i) - key;
            stringBuilder.append((char) characterValue);
        }
        return stringBuilder.toString();
    }


}
