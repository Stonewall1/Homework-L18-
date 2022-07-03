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

    public static String numberInput(){
        return scanner.nextLine();
    }
}
