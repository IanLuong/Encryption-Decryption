package encryptdecrypt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] message = scanner.nextLine().toCharArray();
        int key = scanner.nextInt();

        for (int i = 0; i < message.length; i++) {
            message[i] = encryptCharacter(message[i], key);
        }


        System.out.println(String.valueOf(message));
    }
    
    private static char encryptCharacter(char character, int key) {
        final char[] letters = {'A', 'B', 'C', 'D', 'E',
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
            return isLowerCase ? Character.toLowerCase(letters[(charIndex + key) % 26]) : letters[(charIndex + key) % 26];
        }
        else {
            return character;
        }

    }

}
