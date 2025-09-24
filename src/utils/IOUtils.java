package utils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class IOUtils {
    public static void println(String message){
        System.out.println(message);
    }

    public static int scanInt(Scanner scanner){
        while (true) {
            try {
                var input = scanner.nextInt();
                scanner.nextLine();
                return input;
            } catch (InputMismatchException e) {
                println("Opção inválida! Digite um número.");
                scanner.nextLine();
            }
        }
    }

    public static boolean validateLocalDte(String date){
        try{
            var localDate = LocalDate.parse(date);
            return true;
        }
        catch (DateTimeParseException e){
            System.out.println("Data inválida! Digite no formato YYYY-MM-DD");
            return false;
        }
    }
}

