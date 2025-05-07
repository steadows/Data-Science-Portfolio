import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NameRatingIntersection {

    static Set<String> getIntersectedNames(Map<String, Integer> ratingsMom, Map<String, Integer> ratingsDad) {
        // ... (same as your previous getIntersectedNames function)
        Set<String> intersectedNames = new HashSet<>();

        for (Map.Entry<String, Integer> entry : ratingsMom.entrySet()) {
            String name = entry.getKey();
            float momRating = entry.getValue();
            float dadRating = ratingsDad.getOrDefault(name, 0); // Default to 0 if not present
            if (momRating >= 5 && dadRating >= 5) { 
                intersectedNames.add(name);
            }
            System.out.println();
        }
        return intersectedNames;
    }

    static List<String> getTopNames(Set<String> intersectedNames, Map<String, Integer> ratingsMom, Map<String, Integer> ratingsDad) {
        List<String> topNames = new ArrayList<>();
        float highestAverage = 0;

        for (String name : intersectedNames) {
            int momRating = ratingsMom.get(name);
            int dadRating = ratingsDad.get(name);
            float currentAverage = (momRating + dadRating) / 2.0f;

            if (currentAverage > highestAverage) {
                highestAverage = currentAverage;
                topNames.clear(); // Clear the list of previous top names
                topNames.add(name); // Add the new top name to the list
            } else if (currentAverage == highestAverage) {
                topNames.add(name); // Add the tied name to the list
            }
        }
        return topNames;
    }

    static void printIntersectedNames(Set<String> intersectedNames, Map<String, Integer> ratingsMom, Map<String, Integer> ratingsDad, String gender) {
        if (intersectedNames.isEmpty()) {
            System.out.println("Sorry, there are no names with the highest ratings.");
        } else {
            System.out.println("Here's where you two agreed. You rated these names with a 5 or higher.");
            System.out.println("The " + gender + " names with the highest ratings are:");
            System.out.println("Name\t\tMom's Rating\tDad's Rating");

            for (String name : intersectedNames) {
                int momRating = ratingsMom.getOrDefault(name, 0);
                int dadRating = ratingsDad.getOrDefault(name, 0);
                System.out.printf("%-16s %-16s %-16s\n", name, momRating, dadRating);
            }
            System.out.println();
        }
    }

    static void printTopNames(List<String> topNames, Map<String, Integer> ratingsMom, Map<String, Integer> ratingsDad, String gender) {
        if (topNames.isEmpty()) {
            System.out.println("Sorry, there are no names with the highest ratings for " + gender + "s.");
        } else {
            System.out.println("Drum roll please. These are the names with the highest rating.");
            System.out.println("The top " + gender + " name(s) with the highest rating is:");
            System.out.println("Name\t\tAverage Rating");

            for (String name : topNames) {
                int momRating = ratingsMom.get(name);
                int dadRating = ratingsDad.get(name);
                float average = (momRating + dadRating) / 2.0f;
                System.out.printf("%-16s %-16s\n", name, average);
            }
            System.out.println();
        }
    }
}

