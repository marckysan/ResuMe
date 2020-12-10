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
            Scanner s1 = new Scanner(System.in);
            System.out.println("Name:");
            String name = s1.nextLine();
            System.out.println("description:");
            String description = s1.nextLine();
            backend.addPersonalProject(name, description);
            System.out.println("Personal project added.");
            s1.close();
            break;

        case "removeAchievement":
            Scanner s2 = new Scanner(System.in);
            System.out.println("Index to remove:");
            String index = s2.nextLine();
            backend.removeAchievement(Integer.valueOf(index));
            System.out.println("Achievement removed.");
            s2.close();
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
