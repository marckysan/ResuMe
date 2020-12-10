import backend.Backend;
import backend.BackendImpl;
import backend.exception.BackendException;

import java.util.Scanner;

public class Main {

    public Backend backend = BackendImpl.getBackend();

    public Main() {}

    private void execute(String command) {

        switch (command) {

        case "getPerson":
            System.out.println(backend.getPerson());
            break;

        case "getAchievements":
            System.out.println(backend.getAchievements());
            break;

        case "getResumes":
            System.out.println(backend.getResumes());
            break;

        case "getNumAchievements":
            System.out.println(backend.getNumAchievements());
            break;

        case "addPersonalProject":
            Scanner scanner = new Scanner(System.in);
            System.out.println("Name:");
            String name = scanner.nextLine();
            System.out.println("description:");
            String description = scanner.nextLine();
            backend.addPersonalProject(name, description);
            System.out.println("Personal project added.");
            break;
        }

    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            try {
                main.execute(command);
            } catch (BackendException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

}
