package encryptdecrypt;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String message = "";
        int key = 0;
        boolean encryptionMode = false;

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-mode":
                    switch (args[i + 1]) {
                        case "enc":
                            encryptionMode = true;
                            break;
                        case "dec":
                            encryptionMode = false;
                            break;
                    }
                    break;
                case "-key":
                    key = Integer.parseInt(args[i + 1]);
                    break;

                case "-data":
                    message = args[i + 1];
                    break;
            }
        }

        message = processMessage(message, key, encryptionMode);

        System.out.println(message);
    }

    public static String processMessage(String inputMessage, int key, boolean isEncrypt) {
        char[] message = inputMessage.toCharArray();

        if (isEncrypt) {
            for (int i = 0; i < message.length; i++) {
                message[i] = encryptCharacter(message[i], key);
            }
        } else {
            for (int i = 0; i < message.length; i++) {
                message[i] = decryptCharacter(message[i], key);
            }
        }

        return String.valueOf(message);
    }

    private static char encryptCharacter(char character, int key) {

        /* final char[] letters = {'A', 'B', 'C', 'D', 'E',
                'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O',
                'P', 'Q', 'R', 'S', 'T', 'U',
                'V', 'W', 'X', 'Y', 'Z'};
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
        } */

        int characterValue = (int) character + key;
        return (char) characterValue;
    }

    private static char decryptCharacter(char character, int key) {
       /* final char[] letters = {'A', 'B', 'C', 'D', 'E',
                'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O',
                'P', 'Q', 'R', 'S', 'T', 'U',
                'V', 'W', 'X', 'Y', 'Z'};
        int charIndex = 0;
        boolean isLetter = Character.toString(character).matches("[a-zA-Z]");
        boolean isLowerCase = Character.toString(character).matches("[a-z]");

        //char returnVal = letters[(((charIndex - key) % 26) + 26) % 26];
        return isLowerCase ? Character.toLowerCase(returnVal) : returnVal;
        */

        int characterValue = (int) character - key;
        return (char) characterValue;
    }


}
