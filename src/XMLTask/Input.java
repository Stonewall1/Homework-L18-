package XMLTask;

import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    private static String inputPathToFolder() {
        System.out.println("Input path to folder");
        return scanner.nextLine();
    }

    public static String getInputPathToFolder() {
        return inputPathToFolder();
    }

    private static int choice(){
        System.out.println("Enter 1 , 2 or 3");
        return scanner.nextInt();
    }
    public static int getChoice(){
        return choice();
    }
}
