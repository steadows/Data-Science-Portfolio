
import java.util.Scanner;

public class strengthMenu {

    public static void prompt () {
        Scanner scnr = new Scanner(System.in);
        String input;
        boolean isValid = false;
        boolean keepGoing = false;
        boolean cycleIsValid = false;
        String cycle = " ";

        System.out.println("Are you Doing Upper Body or Lower Body Today?");
        System.out.println("Type 'U' for Upper Body and 'L' for Lower Body");

        do {
            input = scnr.next();

            if (input.equals("u") || input.equals("U")) {
                System.out.println("What cycle are you on?");
                System.out.println("Enter Number 1-4: ");
                do {
                    cycle = scnr.next();
                    if ( cycle.equals("1") || cycle.equals("2") || cycle.equals("3") || cycle.equals("4")) {
                        cycleIsValid = true;
                        isValid = true;
                        getWorkout.getUpperBodyWorkout(cycle);
                    }
                    else {
                        System.out.println("Invalid Entry");
                        System.out.println("Enter Number 1-4");
                        cycleIsValid = false;
                    }
                } while (!cycleIsValid);

            }
            else if (input.equals("l") || input.equals("L")) {                    //if lower body, load arraylist with lowerbody exercises
                System.out.println("What cycle are you on?");
                System.out.println("Enter Number 1-4: ");
                do {
                    cycle = scnr.next();
                    if ( cycle.equals("1") || cycle.equals("2") || cycle.equals("3") || cycle.equals("4")) {
                        cycleIsValid = true;
                        isValid = true;
                        getWorkout.getLowerBodyWorkout(cycle);
                    }
                    else {
                        System.out.println("Invalid Entry");
                        System.out.println("Enter Number 1-4");
                        cycleIsValid = false;
                    }
                } while (!cycleIsValid);
            }
            else {
                System.out.println("Invalid Entry. Enter U or L");
                isValid = false;
            }
        } while (!(isValid)) ;
        System.out.println();

        String toggle;

        do {
            System.out.println();
            System.out.println("Don't like this one? Press 'N' for new workout, Press 'M' for main menu, Or Press 'Q' to quit");
            toggle = scnr.next();
            if (toggle.equals("n") || toggle.equals("N")) {
                keepGoing = false;
                if (input.equals("u") || input.equals("U")) {
                    getWorkout.getUpperBodyWorkout(cycle);
                }
                else if (input.equals("l") || input.equals("L")) {
                    getWorkout.getLowerBodyWorkout(cycle);
                }
            }
            else if (toggle.equals("q") || toggle.equals("Q")) {
                keepGoing = true;
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
