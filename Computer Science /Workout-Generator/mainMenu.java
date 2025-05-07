
import java.util.Scanner;

public class mainMenu {

    public static void prompt() {
        boolean gotSelection = false;
        String input;
        Scanner scnr = new Scanner(System.in);

        System.out.println("Main Menu:");
        System.out.println("1. Get Strength Training Workout");
        System.out.println("2. Get Tabata Workout");
        System.out.println("3. Get EMOM Workout");
        System.out.println("4. Quit");


        do {
            input = scnr.next();

            if (input.equals("1")) {
                gotSelection = true;
                strengthMenu.prompt();
            }
            else if (input.equals("2")) {
                gotSelection = true;
                tabataMenu.prompt();
            }
            else if (input.equals("3")) {
                gotSelection = true;
                emomMenu.prompt();
            }
            else if (input.equals("4")) {
                gotSelection = true;
            }
            else {
                gotSelection = false;
                System.out.println("Invalid Entry");
                System.out.println("Select Number 1-4: ");
            }
        } while (!gotSelection);
        scnr.close();
    }
}
