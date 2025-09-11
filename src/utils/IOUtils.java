package utils;

import java.util.Scanner;

public class IOUtils {
    public static void println(String message){
        System.out.println(message);
    }

    public static int scanInt(Scanner scanner){
        var input = scanner.nextInt();
        scanner.nextLine();
        return input;

    }
}
