package pl.kamis83.spy2.input;

import java.util.Scanner;

public class UserInputManager {
    Scanner scanner = new Scanner(System.in);

    public UserInputCommand nextCommand() {
        return new UserInputCommand(scanner.nextLine());
    }

}
