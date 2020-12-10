import backend.Backend;
import backend.BackendImpl;

import java.util.Scanner;

public class CLIDemonstrator {

    public Backend backend = BackendImpl.getBackend();

    public CLIDemonstrator() {}

    private void execute(String command, Scanner scanner) {

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

        case "addPersonalProject":
            System.out.println("Name:");
            String name = scanner.nextLine();
            System.out.println("Description:");
            String description = scanner.nextLine();
            backend.addPersonalProject(name, description);
            System.out.println("Personal project added.");
            break;

        case "removeAchievement":
            System.out.println("Index to remove:");
            String removeIndex = scanner.nextLine();
            backend.removeAchievement(Integer.parseInt(removeIndex));
            System.out.println("Achievement removed.");
            break;

        case "selectAchievement":
            System.out.println("Index to select:");
            String selectIndex = scanner.nextLine();
            backend.selectAchievement(Integer.parseInt(selectIndex));
            System.out.println("Achievement selected.");
            break;

        case "deselectAchievement":
            System.out.println("Index to deselect:");
            String deselectIndex = scanner.nextLine();
            backend.deselectAchievement(Integer.parseInt(deselectIndex));
            System.out.println("Achievement deselected.");
            break;

        case "generateAndAddResume":
            System.out.println("Name of resume:");
            String resumeName = scanner.nextLine();
            backend.generateAndAddResume(resumeName);
            System.out.println("New resume generated from recent achievement selection.");
            break;

        case "removeResume":
            System.out.println("Index to remove:");
            String removeResumeIndex = scanner.nextLine();
            backend.removeResume(Integer.parseInt(removeResumeIndex));
            System.out.println("Resume removed.");
            break;

        case "saveAsPdf":
            System.out.println("Index to save as PDF:");
            String saveIndex = scanner.nextLine();
            backend.saveAsPdf(Integer.parseInt(saveIndex));
            System.out.println("PDF saved.");
            break;
        }

    }

    public static void main(String[] args) {
        CLIDemonstrator main = new CLIDemonstrator();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                String command = scanner.nextLine();
                main.execute(command, scanner);
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

}
