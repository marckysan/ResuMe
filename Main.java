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
            String removeIndex = s2.nextLine();
            backend.removeAchievement(Integer.parseInt(removeIndex));
            System.out.println("Achievement removed.");
            s2.close();
            break;

        case "selectAchievement":
            Scanner s3 = new Scanner(System.in);
            System.out.println("Index to select:");
            String selectIndex = s3.nextLine();
            backend.selectAchievement(Integer.parseInt(selectIndex));
            System.out.println("Achievement selected.");
            s3.close();
            break;

        case "deselectAchievement":
            Scanner s4 = new Scanner(System.in);
            System.out.println("Index to deselect:");
            String deselectIndex = s4.nextLine();
            backend.deselectAchievement(Integer.parseInt(deselectIndex));
            System.out.println("Achievement deselected.");
            s4.close();
            break;

        case "generateAndAddResume":
            Scanner s5 = new Scanner(System.in);
            System.out.println("Name of resume:");
            String resumeName = s5.nextLine();
            backend.generateAndAddResume(resumeName);
            System.out.println("New resume generated from recent achievement selection.");
            break;

        case "removeResume":
            Scanner s6 = new Scanner(System.in);
            System.out.println("Index to remove:");
            String removeResumeIndex = s6.nextLine();
            backend.removeResume(Integer.parseInt(removeResumeIndex));
            System.out.println("Resume removed.");
            s6.close();
            break;

        case "saveAsPdf":
            Scanner s7 = new Scanner(System.in);
            System.out.println("Index to save as PDF:");
            String saveIndex = s7.nextLine();
            backend.saveAsPdf(Integer.parseInt(saveIndex));
            System.out.println("PDF saved.");
            s7.close();
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
