package encryptdecrypt;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String message = "";
        int key = 0;
        boolean stdInputFlag = false;
        boolean encryptionMode = false;
        boolean useUnicode = false;
        String outputFile = "";

        boolean running = true;

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-mode":
                    encryptionMode = args[i + 1].equals("enc");
                    break;

                case "-alg":
                    useUnicode = args[i + 1].equals("unicode");
                    break;

                case "-key":
                    key = Integer.parseInt(args[i + 1]);
                    break;

                case "-data":
                    message = args[i + 1];
                    stdInputFlag = true;
                    break;

                case "-out":
                    outputFile = args[i + 1];
                    break;

                case "-in":
                    message = stdInputFlag ? message : args[i + 1];
                    break;
            }
        }

        File inputFile = new File(message);

        if (!message.isEmpty() || inputFile.exists()) {

            if (!stdInputFlag) {
                try {
                    Scanner scanner = new Scanner(inputFile);
                    message = scanner.nextLine();
                    scanner.close();
                } catch (FileNotFoundException e) {
                    System.out.println("Error: File Not Found");
                    running = false;
                }

                if (running && !message.isEmpty()) {
                    Algorithm algorithm = useUnicode ? new UnicodeAlgorithm(key) : new ShiftAlgorithm(key);

                    if (encryptionMode) {
                        message = algorithm.encryptMessage(message);
                    } else {
                        message = algorithm.decryptMessage(message);
                    }

                    if (outputFile.isEmpty()) {
                        System.out.println(message);
                    } else {
                        try (FileWriter writer = new FileWriter(outputFile)) {
                            writer.write(message + "\n");
                        } catch (IOException e) {
                            System.out.println("There was an error writing to the file: " + e.getMessage());
                        }
                    }
                }
            } else {
                System.out.println("Error: Input is empty");
            }
        }
    }

}
