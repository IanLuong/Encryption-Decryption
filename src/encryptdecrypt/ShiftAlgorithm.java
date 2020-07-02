package encryptdecrypt;

public class ShiftAlgorithm extends Algorithm {

    final char[] letters = {'A', 'B', 'C', 'D', 'E',
            'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O',
            'P', 'Q', 'R', 'S', 'T', 'U',
            'V', 'W', 'X', 'Y', 'Z'};

    public ShiftAlgorithm(int key) {
        super(key);
    }

    @Override
    public String encryptMessage(String message) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < message.length(); i++) {
            stringBuilder.append(encryptCharacter(message.charAt(i)));
        }
        return stringBuilder.toString();
    }

    private char encryptCharacter(char character) {
        int charIndex = 0;
        boolean isLetter = Character.toString(character).matches("[a-zA-Z]");
        boolean isLowerCase = Character.toString(character).matches("[a-z]");

        if (isLetter) {
            for (int i = 0; i < 26; i++) {
                if (letters[i] == Character.toUpperCase(character)) {
                    charIndex = i;
                    break;
                }
            }
            char returnVal = letters[(charIndex + key) % 26];
            return isLowerCase ? Character.toLowerCase(returnVal) : returnVal;
        }
        else {
            return character;
        }
    }

    @Override
    public String decryptMessage(String message) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < message.length(); i++) {
            stringBuilder.append(decryptCharacter(message.charAt(i)));
        }
        return stringBuilder.toString();
    }

    private char decryptCharacter(char character) {
        int charIndex = 0;
        boolean isLetter = Character.toString(character).matches("[a-zA-Z]");
        boolean isLowerCase = Character.toString(character).matches("[a-z]");

        if (isLetter) {
            for (int i = 0; i < 26; i++) {
                if (letters[i] == Character.toUpperCase(character)) {
                    charIndex = i;
                    break;
                }
            }
            char returnVal = letters[(charIndex - key + 26) % 26];
            return isLowerCase ? Character.toLowerCase(returnVal) : returnVal;
        }
        else {
            return character;
        }
    }
}
