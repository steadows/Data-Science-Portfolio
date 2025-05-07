import java.util.*;

class Parent {
    private String name;
    private List<String> boyNames;
    private List<String> girlNames;

    public Parent(String name) {
        this.name = name;
        this.boyNames = new ArrayList<>();
        this.girlNames = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getBoyNames() {
        return boyNames;
    }

    public void addBoyName(String babyName) {
        boyNames.add(babyName);
    }

    public List<String> getGirlNames() {
        return girlNames;
    }

    public void addGirlName(String babyName) {
        girlNames.add(babyName);
    }
}

public class BabyNamePicker {
    private static final String MALE = "boy";
    private static final String FEMALE = "girl";
    private static final int COUNT = 5;
    public static void main(String[] args) throws InterruptedException {
        String father = "";
        String mother = "";

        Scanner scanner = new Scanner(System.in);
        List<String> top100BoyNames = getTop100BoyNames(); // List of the top 100 baby names
        List<String> top100GirlNames = getTop100GirlNames(); 

        System.out.println("Welcome to the Baby Name Picker!");

        Thread.sleep(2000); // Pause for 2 seconds

        System.out.println("What is the father's name?: ");
        father = scanner.nextLine();
        String capFather = father.substring(0, 1).toUpperCase() + father.substring(1);

        Parent dad = new Parent(capFather);

        Thread.sleep(1000); // Pause for 2 seconds


        System.out.println("Thanks! Now what's the mother's name?: ");
        mother = scanner.nextLine();
        String capMother = mother.substring(0, 1).toUpperCase() + mother.substring(1);

        Parent mom = new Parent(capMother);


        Thread.sleep(1000);

        System.out.println("Brilliant! Let's get started, shall we?");

        Thread.sleep(2000);
        System.out.println(mom.getName() + ", you're up first!");

        Thread.sleep(1000);

        System.out.println("Please enter 5 baby names for each gender.");

        Thread.sleep(1000);

        List<String> namesMaleMom = getNamesFromUser(scanner, "male", COUNT, mom);
        List<String> namesFemaleMom = getNamesFromUser(scanner, "female", COUNT, mom);

        clearTerminal();

        System.out.println("Awesome! " + dad.getName() + ", now it's your turn!");

        Thread.sleep(1000);

        List<String> namesMaleDad = getNamesFromUser(scanner, "male", COUNT, dad);
        List<String> namesFemaleDad = getNamesFromUser(scanner, "female", COUNT, dad);

        List<String> additionalMaleNames = getRandomNames(top100BoyNames, COUNT);
        List<String> additionalFemaleNames = getRandomNames(top100GirlNames, COUNT);

        List<String> combinedBoyNames = new ArrayList<>(namesMaleMom);
        combinedBoyNames.addAll(namesMaleDad);
        combinedBoyNames.addAll(additionalMaleNames);
        Collections.shuffle(combinedBoyNames);

        List<String> combinedGirlNames = new ArrayList<>(namesFemaleMom);
        combinedGirlNames.addAll(namesFemaleDad);
        combinedGirlNames.addAll(additionalFemaleNames);
        Collections.shuffle(combinedGirlNames);

        Thread.sleep(500);

        clearTerminal();

        System.out.println("Excellent. All names are in.");
        Thread.sleep(2000);

        System.out.println("Let's start rating these names.");
        Thread.sleep(2000);

        System.out.println(dad.getName() + ", you're up first!");
        Thread.sleep(2000);

        System.out.println("Rate each name from 1 - 10. Whole numbers only.");
        Thread.sleep(2000);

        System.out.println("Here we go!");

        Thread.sleep(2000);

        Map<String, Integer> ratingsMomMale = rateNames(scanner, combinedBoyNames, "boy");
        Map<String, Integer> ratingsMomFemale = rateNames(scanner, combinedGirlNames, "girl");

        clearTerminal();

        System.out.println("Thanks!");

        Thread.sleep(2000);

        System.out.println("Now it's " + mom.getName() + "'s turn!");

        Thread.sleep(2000);

        Map<String, Integer> ratingsDadMale = rateNames(scanner, combinedBoyNames, "boy");
        Map<String, Integer> ratingsDadFemale = rateNames(scanner, combinedGirlNames, "girl");

        Thread.sleep(1000);

        clearTerminal();

        System.out.println("Brilliant! Let's check out the results.");

        Thread.sleep(2000);

        // clearTerminal();


        Set<String> intersectedMaleNames = NameRatingIntersection.getIntersectedNames(ratingsMomMale, ratingsDadMale);
        Set<String> intersectedFemaleNames = NameRatingIntersection.getIntersectedNames(ratingsMomFemale, ratingsDadFemale);

        System.out.println("\nHere's where you two agreed. You rated these names with a 5 or higher.");

        Thread.sleep(2000);

        NameRatingIntersection.printIntersectedNames(intersectedMaleNames, ratingsMomMale, ratingsDadMale, MALE);
        NameRatingIntersection.printIntersectedNames(intersectedFemaleNames, ratingsMomFemale, ratingsDadFemale, FEMALE);

        Thread.sleep(2000);

        
        System.out.println("Drum roll please. These are the names with the highest rating.");

        List<String> topMaleName = NameRatingIntersection.getTopNames(intersectedMaleNames, ratingsMomMale, ratingsDadMale);
        List<String> topFemaleName = NameRatingIntersection.getTopNames(intersectedFemaleNames, ratingsMomFemale, ratingsDadFemale);

        NameRatingIntersection.printTopNames(topMaleName,ratingsMomMale,ratingsDadMale, MALE);
        NameRatingIntersection.printTopNames(topFemaleName,ratingsMomFemale,ratingsDadFemale, FEMALE);
    }

    private static List<String> getTop100BoyNames() {
        // Return a list of the top 100 baby names
        List<String> top100NamesMale = new ArrayList<>(Arrays.asList(
            "Liam", "Noah", "William", "James", "Oliver", "Benjamin", "Elijah", "Lucas", "Mason", "Logan",
            "Alexander", "Ethan", "Jacob", "Michael", "Daniel", "Henry", "Jackson", "Sebastian", "Aiden",
            "Matthew", "Samuel", "David", "Joseph", "Carter", "Owen", "Wyatt", "John", "Jack", "Luke",
            "Jayden", "Dylan", "Grayson", "Levi", "Isaac", "Gabriel", "Julian", "Mateo", "Anthony", "Jaxon",
            "Lincoln", "Joshua", "Christopher", "Andrew", "Theodore", "Caleb", "Ryan", "Asher", "Nathan",
            "Thomas", "Leo", "Isaiah", "Charles", "Josiah", "Hudson", "Christian", "Hunter", "Connor", "Eli",
            "Ezra", "Aaron", "Landon", "Adrian", "Jonathan", "Nolan", "Jeremiah", "Easton", "Elias", "Colton",
            "Cameron", "Carson", "Robert", "Angel", "Maverick", "Nicholas", "Dominic", "Jaxson", "Greyson",
            "Adam", "Ian", "Austin", "Santiago", "Jordan", "Cooper", "Brayden", "Roman", "Evan", "Ezekiel",
            "Xavier", "Jose", "Jace", "Jameson", "Leonardo", "Bryson", "Axel", "Everett", "Parker", "Kayden",
            "Miles", "Sawyer", "Jason"
        ));

        return top100NamesMale;
    }

    private static List<String> getTop100GirlNames() {
        // Return a list of the top 100 baby names
        List<String> top100NamesFemale = new ArrayList<>(Arrays.asList(
            "Emma", "Olivia", "Ava", "Isabella", "Sophia", "Charlotte", "Mia", "Amelia", "Harper", "Evelyn",
            "Abigail", "Emily", "Elizabeth", "Mila", "Ella", "Avery", "Sofia", "Camila", "Aria", "Scarlett",
            "Victoria", "Madison", "Luna", "Grace", "Chloe", "Penelope", "Layla", "Riley", "Zoey", "Nora",
            "Lily", "Eleanor", "Hannah", "Lillian", "Addison", "Aubrey", "Ellie", "Stella", "Natalie", "Zoe",
            "Leah", "Hazel", "Violet", "Aurora", "Savannah", "Audrey", "Brooklyn", "Bella", "Claire", "Skylar",
            "Lucy", "Paisley", "Everly", "Anna", "Caroline", "Nova", "Genesis", "Emilia", "Kennedy", "Samantha",
            "Maya", "Willow", "Kinsley", "Naomi", "Aaliyah", "Elena", "Sarah", "Ariana", "Allison", "Gabriella",
            "Alice", "Madelyn", "Cora", "Ruby", "Eva", "Serenity", "Autumn", "Adeline", "Hailey", "Gianna",
            "Valentina", "Isla", "Eliana", "Quinn", "Nevaeh", "Ivy", "Sadie", "Piper", "Lydia", "Alexa",
            "Josephine", "Emery", "Julia", "Delilah", "Arianna", "Vivian", "Kaylee", "Sophie", "Brielle",
            "Madeline"
        ));
        return top100NamesFemale;
    }

    private static List<String> getNamesFromUser(Scanner scanner, String gender, int count, Parent parent) {
        if ( gender == "male") {
            System.out.println("Enter " + count + " " + gender + " names:");
            for (int i = 0; i < count; i++) {
                String name = scanner.nextLine();
                String capitalizedName = name.substring(0, 1).toUpperCase() + name.substring(1);
                parent.addBoyName(capitalizedName);
            }
            return parent.getBoyNames();
        }
        else {
            System.out.println("Enter " + count + " " + gender + " names:");
            for (int i = 0; i < count; i++) {
                String name = scanner.nextLine();
                String capitalizedName = name.substring(0, 1).toUpperCase() + name.substring(1);
                parent.addGirlName(capitalizedName);
            }
        }
        return parent.getGirlNames();
    }

    private static List<String> getRandomNames(List<String> sourceList, int count) {
        List<String> randomNames = new ArrayList<>();
        Collections.shuffle(sourceList);
        for (int i = 0; i < count; i++) {
            randomNames.add(sourceList.get(i));
        }
        return randomNames;
    }

    private static Map<String, Integer> rateNames(Scanner scanner, List<String> names, String gender) {
        Map<String, Integer> ratings = new HashMap<>();
        System.out.println("Rate the following " + gender + " baby names (1 - 10):");
        for (String name : names) {
            int rating = 0;
            boolean validInput = false;
            while (!validInput) {
                System.out.print(name + ": ");
                try {
                    rating = Integer.parseInt(scanner.nextLine());
                    if (rating >= 1 && rating <= 10) {
                        validInput = true;
                    } else {
                        System.out.println("Invalid rating. Please enter a number between 1 and 10.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number between 1 and 10.");
                }
            }
            ratings.put(name, rating);
        }
        return ratings;
    }
    
    private static void clearTerminal() {
        if (System.getProperty("os.name").contains("Windows")) {
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }
}
