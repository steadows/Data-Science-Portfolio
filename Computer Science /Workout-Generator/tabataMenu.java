import java.util.Scanner;
public class tabataMenu {

    public static void prompt () {
        boolean keepGoing = false;
        getWorkout.getTabataWorkout();
       
        String toggle;
        Scanner scnr = new Scanner(System.in);
        do {
            System.out.println();
            System.out.println("Don't like this one? Press 'N' for new workout, Press 'M' for main menu, Or Press 'Q' to quit");
            toggle = scnr.next();
            if (toggle.equals("n") || toggle.equals("N")) {
                keepGoing = false;
                getWorkout.getTabataWorkout();
            }
            else if (toggle.equals("q") || toggle.equals("Q")) {
                keepGoing = true;
                break;
            }
            else if (toggle.equals("m") || toggle.equals("M")){
                keepGoing = true;
                mainMenu.prompt();
            }
            else {
                keepGoing = false;
                System.out.println("Invalid Entry.");
            }
        } while (!(keepGoing));

        scnr.close();
    }
    
}