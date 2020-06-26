package encryptdecrypt;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] message = "we found a treasure!".toCharArray();

        char[] letters = {'A', 'B', 'C', 'D', 'E',
                'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O',
                'P', 'Q', 'R', 'S', 'T', 'U',
                'V', 'W', 'X', 'Y', 'Z'};

        char[] reverseLetters = {'Z', 'Y', 'X', 'W', 'V',
                'U', 'T', 'S', 'R', 'Q',
                'P', 'O', 'N', 'M', 'L',
                'K', 'J', 'I', 'H', 'G', 'F',
                'E', 'D', 'C', 'B', 'A'};


        for (int j = 0; j < message.length; j++) {
            if (Character.toString(message[j]).matches("[a-z]")) {
                for (int i = 0; i < 26; i++) {
                    if (Character.toUpperCase(message[j]) == letters[i]) {
                        message[j] = Character.toLowerCase(reverseLetters[i]);
                        break;
                    }
                }
            } else if (Character.toString(message[j]).matches("[A-Z]")) {
                for (int i = 0; i < 26; i++) {
                    if (message[j] == letters[i]) {
                        message[j] = reverseLetters[i];
                        break;
                    }
                }
            }
        }

        System.out.println(String.valueOf(message));
    }
}
