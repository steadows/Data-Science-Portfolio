
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
import java.util.*;


public class getWorkout {

    static boolean check(Integer[] arr, Integer toCheckValue) {
        boolean test = Arrays.asList(arr).contains(toCheckValue);
        return test;
    }

    static void getUpperBodyWorkout(String cycle) {
        ArrayList<exercise> compoundPushList = new ArrayList<exercise>();
        ArrayList<exercise> compoundPullList = new ArrayList<exercise>();
        ArrayList<exercise> secondaryList = new ArrayList<exercise>();
        ArrayList<exercise> tertiaryList = new ArrayList<exercise>();

        //compound movements

        exercise floorPress = new exercise("Floor Press", 10,12,15,8);
        exercise shoulderPress = new exercise("Push or Strict Press", 8,10,12,6);
        exercise kbPullover = new exercise("Kettlebell Pullover", 10,12,15,8);
        exercise kbRow = new exercise("Single Arm KB Row", 10,12,15,8);
        exercise pullUp = new exercise("Pull-Ups", 5,7,9,5);
        //secondary movements

        exercise latPulldowns = new exercise("Banded Lat Pulldowns", 15,18,20,12);
        exercise lateralRaises = new exercise("Banded Lateral Raises", 10,12,15,8);
        exercise uprightRows = new exercise("Upright Rows", 8,10,12,6);
        exercise dips = new exercise("Dips", 6,8,10,6);
        exercise threesixties = new exercise("Mace 360s", 10,12,15,8);
        exercise primalSwoldierPlex = new exercise("Row to Suitcase DL to Shrug", 5,7,9,5);
        exercise curls = new exercise("KB Curls", 8,10,12,8);
        exercise pushups = new exercise("Push-Ups", 10,12,15,10);
        exercise frontRaises = new exercise("Front Raises", 8,10,12,8);
        exercise kbSkullCrushers = new exercise("Kettlebell Skull Crushers", 8,10,12,8);
        exercise facePulls = new exercise("facePulls", 8,10,12,8);

        //tertiary movements

        exercise bandFacePull = new exercise("Banded Face Pulls", 10, 12, 15, 8);
        exercise bandCurls = new exercise("Banded Curls", 10, 12, 15, 8);
        exercise russianTwist = new exercise("Russian Twist", 8, 10, 12, 8);
        exercise plank = new exercise("Plank", 30, 30, 45, 30);
        exercise sitThroughs = new exercise("Sit Throughs", 5, 7, 9, 5);
        exercise reverseFly = new exercise("Banded Delt Reverse Flyes", 10, 12, 15, 8);
        exercise toeTouches = new exercise("Toe Touches", 8, 10, 12, 8);


        compoundPushList.add(floorPress);
        compoundPushList.add(shoulderPress);
        compoundPullList.add(kbPullover);
        compoundPullList.add(kbRow);
        compoundPullList.add(pullUp);
        secondaryList.add(latPulldowns);
        secondaryList.add(lateralRaises);
        secondaryList.add(uprightRows);
        secondaryList.add(dips);
        secondaryList.add(threesixties);
        secondaryList.add(primalSwoldierPlex);
        secondaryList.add(curls);
        secondaryList.add(pushups);
        secondaryList.add(frontRaises);
        secondaryList.add(kbSkullCrushers);
        secondaryList.add(facePulls);
        tertiaryList.add(bandFacePull);
        tertiaryList.add(bandCurls);
        tertiaryList.add(russianTwist);
        tertiaryList.add(plank);
        tertiaryList.add(sitThroughs);
        tertiaryList.add(reverseFly);
        //tertiaryList.add("Slingshots");
        tertiaryList.add(toeTouches);

        if ( cycle.equals("1") ) {
            long startTime = System.currentTimeMillis();
            System.out.println("Cycle 1:");
            System.out.println();//                                                            Set 1


            System.out.println("Set 1 X 3: ");

            //Print Slot 1

            Random ran = new Random();
            int nxt = ran.nextInt(compoundPushList.size());
            System.out.println(compoundPushList.get(nxt).getName() + " X " + compoundPushList.get(nxt).getCycleOneRepCount());
            compoundPushList.remove(nxt);

            //Print Slot 2

            Random ranSec = new Random();
            int secNxt = ranSec.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt).getName() + " X " + secondaryList.get(secNxt).getCycleOneRepCount());
            secondaryList.remove(secNxt);

            //Print Slot 3

            Random ranSec2 = new Random();
            int secNxt2 = ranSec2.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt2).getName() + " X " + secondaryList.get(secNxt2).getCycleOneRepCount());
            secondaryList.remove(secNxt2);

            System.out.println();//                                                            Set 2


            System.out.println("Set 2 X 3: ");

            //Print Slot 1

            Random ran2 = new Random();
            int nxt2 = ran2.nextInt(compoundPullList.size());
            System.out.println(compoundPullList.get(nxt2).getName() + " X " + compoundPullList.get(nxt2).getCycleOneRepCount());
            compoundPullList.remove(nxt2);

            //Print Slot 2

            Random ranSec3 = new Random();
            int secNxt3 = ranSec3.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt3).getName() + " X " + secondaryList.get(secNxt3).getCycleOneRepCount());
            secondaryList.remove(secNxt3);

            //Print Slot 3

            Random ranSec4 = new Random();
            int secNxt4 = ranSec4.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt4).getName() + " X " + secondaryList.get(secNxt4).getCycleOneRepCount());
            secondaryList.remove(secNxt4);

            System.out.println();//                                                            Set 3

            System.out.println("Set 3 X 3: ");

            Random ran3 = new Random();
            int nxt3 = ran3.nextInt(compoundPushList.size());
            System.out.println(compoundPushList.get(nxt3).getName() + " X " + compoundPushList.get(nxt3).getCycleOneRepCount());
            compoundPushList.remove(nxt3);

            //Print Slot 2

            Random ranSec5 = new Random();
            int secNxt5 = ranSec5.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt5).getName() + " X " + secondaryList.get(secNxt5).getCycleOneRepCount());
            secondaryList.remove(secNxt5);

            //Print Slot 3

            Random ranSec6 = new Random();
            int secNxt6 = ranSec6.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt6).getName() + " X " + secondaryList.get(secNxt6).getCycleOneRepCount());
            secondaryList.remove(secNxt6);
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            System.out.println();
            System.out.println(runTime + " ms");
        }

        //                               for cycle 2 - two teritaries - 4 sets
        else if ( cycle.equals("2") ){

            //                                                                         Set 1
            System.out.println("Cycle 2:");
            System.out.println();


            System.out.println("Set 1 X 4: ");

            //Print Slot 1

            Random ran = new Random();
            int nxt = ran.nextInt(compoundPushList.size());
            System.out.println(compoundPushList.get(nxt).getName() + " X " + compoundPushList.get(nxt).getCycleTwoRepCount());
            compoundPushList.remove(nxt);

            //Print Slot 2

            Random ranSec = new Random();
            int secNxt = ranSec.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt).getName() + " X " + secondaryList.get(secNxt).getCycleTwoRepCount());
            secondaryList.remove(secNxt);

            //Print Slot 3

            Random ranSec2 = new Random();
            int secNxt2 = ranSec2.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt2).getName() + " X " + secondaryList.get(secNxt2).getCycleTwoRepCount());
            secondaryList.remove(secNxt2);

            System.out.println(); //                                                  Set 2


            System.out.println("Set 2 X 4: ");

            //Print Slot 1

            Random ran2 = new Random();
            int nxt2 = ran2.nextInt(compoundPullList.size());
            System.out.println(compoundPullList.get(nxt2).getName() + " X " + compoundPullList.get(nxt2).getCycleTwoRepCount());
            compoundPullList.remove(nxt2);

            //Print Slot 2

            Random ranSec3 = new Random();
            int secNxt3 = ranSec3.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt3).getName() + " X " + secondaryList.get(secNxt3).getCycleTwoRepCount());
            secondaryList.remove(secNxt3);

            //Print Slot 3

            Random ranSec4 = new Random();
            int secNxt4 = ranSec4.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt4).getName() + " X " + secondaryList.get(secNxt4).getCycleTwoRepCount());
            secondaryList.remove(secNxt4);

            //Print Slot 4

            Random ranSec7 = new Random();
            int secNxt7 = ranSec7.nextInt(tertiaryList.size());
            System.out.println(tertiaryList.get(secNxt7).getName() + " X " + tertiaryList.get(secNxt7).getCycleTwoRepCount());
            tertiaryList.remove(secNxt7);

            System.out.println(); //                                                  Set 3

            System.out.println("Set 3 X 4: ");

            //Print Slot 1

            Random ran3 = new Random();
            int nxt3 = ran3.nextInt(compoundPushList.size());
            System.out.println(compoundPushList.get(nxt3).getName() + " X " + compoundPushList.get(nxt3).getCycleTwoRepCount());
            compoundPushList.remove(nxt3);

            //Print Slot 2

            Random ranSec5 = new Random();
            int secNxt5 = ranSec5.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt5).getName() + " X " + secondaryList.get(secNxt5).getCycleTwoRepCount());
            secondaryList.remove(secNxt5);

            //Print Slot 3

            Random ranSec6 = new Random();
            int secNxt6 = ranSec6.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt6).getName() + " X " + secondaryList.get(secNxt6).getCycleTwoRepCount());
            secondaryList.remove(secNxt6);

            //Print Slot 4

            Random ranSec8 = new Random();
            int secNxt8 = ranSec8.nextInt(tertiaryList.size());
            System.out.println(tertiaryList.get(secNxt8).getName() + " X " + tertiaryList.get(secNxt8).getCycleTwoRepCount());
            tertiaryList.remove(secNxt8);

            System.out.println(); //                                                  Set 4

            System.out.println("Set 4 X 4: ");

            //Print Slot 1

            Random ran4 = new Random();
            int nxt4 = ran4.nextInt(compoundPullList.size());
            System.out.println(compoundPullList.get(nxt4).getName() + " X " + compoundPullList.get(nxt4).getCycleTwoRepCount());
            compoundPullList.remove(nxt4);

            //Print Slot 2

            Random ranSec9 = new Random();
            int secNxt9 = ranSec9.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt9).getName() + " X " + secondaryList.get(secNxt9).getCycleTwoRepCount());
            secondaryList.remove(secNxt9);

            //Print Slot 3

            Random ranSec10 = new Random();
            int secNxt10 = ranSec10.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt10).getName() + " X " + secondaryList.get(secNxt10).getCycleTwoRepCount());
            secondaryList.remove(secNxt10);


        }
        //                               for cycle 3 - two teritaries - 5 sets
        else if ( cycle.equals("3")) {

            //                                                                         Set 1
            System.out.println("Cycle 3:");
            System.out.println();


            System.out.println("Set 1 X 5: ");

            //Print Slot 1

            Random ran = new Random();
            int nxt = ran.nextInt(compoundPushList.size());
            System.out.println(compoundPushList.get(nxt).getName() + " X " + compoundPushList.get(nxt).getCycleThreeRepCount());
            compoundPushList.remove(nxt);

            //Print Slot 2

            Random ranSec = new Random();
            int secNxt = ranSec.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt).getName() + " X " + secondaryList.get(secNxt).getCycleThreeRepCount());
            secondaryList.remove(secNxt);

            //Print Slot 3

            Random ranSec2 = new Random();
            int secNxt2 = ranSec2.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt2).getName() + " X " + secondaryList.get(secNxt2).getCycleThreeRepCount());
            secondaryList.remove(secNxt2);

            System.out.println(); //                                                  Set 2


            System.out.println("Set 2 X 5: ");

            //Print Slot 1

            Random ran2 = new Random();
            int nxt2 = ran2.nextInt(compoundPullList.size());
            System.out.println(compoundPullList.get(nxt2).getName() + " X " + compoundPullList.get(nxt2).getCycleThreeRepCount());
            compoundPullList.remove(nxt2);

            //Print Slot 2

            Random ranSec3 = new Random();
            int secNxt3 = ranSec3.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt3).getName() + " X " + secondaryList.get(secNxt3).getCycleThreeRepCount());
            secondaryList.remove(secNxt3);

            //Print Slot 3

            Random ranSec4 = new Random();
            int secNxt4 = ranSec4.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt4).getName() + " X " + secondaryList.get(secNxt4).getCycleThreeRepCount());
            secondaryList.remove(secNxt4);

            //Print Slot 4

            Random ranSec7 = new Random();
            int secNxt7 = ranSec7.nextInt(tertiaryList.size());
            System.out.println(tertiaryList.get(secNxt7).getName() + " X " + tertiaryList.get(secNxt7).getCycleThreeRepCount());
            tertiaryList.remove(secNxt7);

            System.out.println(); //                                                  Set 3

            System.out.println("Set 3 X 5: ");

            //Print Slot 1

            Random ran3 = new Random();
            int nxt3 = ran3.nextInt(compoundPushList.size());
            System.out.println(compoundPushList.get(nxt3).getName() + " X " + compoundPushList.get(nxt3).getCycleThreeRepCount());
            compoundPushList.remove(nxt3);

            //Print Slot 2

            Random ranSec5 = new Random();
            int secNxt5 = ranSec5.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt5).getName() + " X " + secondaryList.get(secNxt5).getCycleThreeRepCount());
            secondaryList.remove(secNxt5);

            //Print Slot 3

            Random ranSec6 = new Random();
            int secNxt6 = ranSec6.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt6).getName() + " X " + secondaryList.get(secNxt6).getCycleThreeRepCount());
            secondaryList.remove(secNxt6);

            //Print Slot 4

            Random ranSec8 = new Random();
            int secNxt8 = ranSec8.nextInt(tertiaryList.size());
            System.out.println(tertiaryList.get(secNxt8).getName() + " X " + tertiaryList.get(secNxt8).getCycleThreeRepCount());
            tertiaryList.remove(secNxt8);

            System.out.println(); //                                                  Set 4

            System.out.println("Set 4 X 5: ");

            //Print Slot 1

            Random ran4 = new Random();
            int nxt4 = ran4.nextInt(compoundPullList.size());
            System.out.println(compoundPullList.get(nxt4).getName() + " X " + compoundPullList.get(nxt4).getCycleThreeRepCount());
            compoundPullList.remove(nxt4);

            //Print Slot 2

            Random ranSec9 = new Random();
            int secNxt9 = ranSec9.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt9).getName() + " X " + secondaryList.get(secNxt9).getCycleThreeRepCount());
            secondaryList.remove(secNxt9);

            //Print Slot 3

            Random ranSec10 = new Random();
            int secNxt10 = ranSec10.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt10).getName() + " X " + secondaryList.get(secNxt10).getCycleThreeRepCount());
            secondaryList.remove(secNxt10);
        }

        //                                          Cycle 4 - Deload
        else if ( cycle.equals("4") ) {            //                                         Set 1

            System.out.println("Cycle 4: Deload");
            System.out.println(" ");


            System.out.println("Set 1 X 3: ");

            //Print Slot 1

            Random ran = new Random();
            int nxt = ran.nextInt(compoundPushList.size());
            System.out.println(compoundPushList.get(nxt).getName() + " X " + compoundPushList.get(nxt).getCycleFourRepCount());
            compoundPushList.remove(nxt);

            //Print Slot 2

            Random ranSec = new Random();
            int secNxt = ranSec.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt).getName() + " X " + secondaryList.get(secNxt).getCycleFourRepCount());
            secondaryList.remove(secNxt);

            //Print Slot 3

            Random ranSec2 = new Random();
            int secNxt2 = ranSec2.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt2).getName() + " X " + secondaryList.get(secNxt2).getCycleFourRepCount());
            secondaryList.remove(secNxt2);

            System.out.println();


            System.out.println("Set 2 X 3: ");//                                         Set 2

            //Print Slot 1

            Random ran2 = new Random();
            int nxt2 = ran2.nextInt(compoundPullList.size());
            System.out.println(compoundPullList.get(nxt2).getName() + " X " + compoundPullList.get(nxt2).getCycleFourRepCount());
            compoundPullList.remove(nxt2);

            //Print Slot 2

            Random ranSec3 = new Random();
            int secNxt3 = ranSec3.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt3).getName() + " X " + secondaryList.get(secNxt3).getCycleFourRepCount());
            secondaryList.remove(secNxt3);

            //Print Slot 3

            Random ranSec4 = new Random();
            int secNxt4 = ranSec4.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt4).getName() + " X " + secondaryList.get(secNxt4).getCycleFourRepCount());
            secondaryList.remove(secNxt4);

            System.out.println();//                                         Set 3


            System.out.println("Set 3 X 3: ");

            Random ran3 = new Random();
            int nxt3 = ran3.nextInt(compoundPushList.size());
            System.out.println(compoundPushList.get(nxt3).getName() + " X " + compoundPushList.get(nxt3).getCycleFourRepCount());
            compoundPushList.remove(nxt3);

            //Print Slot 2

            Random ranSec5 = new Random();
            int secNxt5 = ranSec5.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt5).getName() + " X " + secondaryList.get(secNxt5).getCycleFourRepCount());
            secondaryList.remove(secNxt5);

            //Print Slot 3

            Random ranSec6 = new Random();
            int secNxt6 = ranSec6.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt6).getName() + " X " + secondaryList.get(secNxt6).getCycleFourRepCount());
            secondaryList.remove(secNxt6);
        }
    }

    static void getLowerBodyWorkout(String cycle) {
        ArrayList<exercise> compundAlphaList = new ArrayList<exercise>();
        ArrayList<exercise> compundBetaList = new ArrayList<exercise>();
        ArrayList<exercise> compundGammaList = new ArrayList<exercise>();
        ArrayList<exercise> secondaryList = new ArrayList<exercise>();
        ArrayList<exercise> tertiaryList = new ArrayList<exercise>();

        //compound alpha's

        exercise kickstandFrontSquat = new exercise("Double Kettlebell Front Squat", 8,10,12,6);
        exercise gobletSquat = new exercise("Goblet Squat",8,10,12,6);

        //compound beta's

        exercise kickstandDead = new exercise("Double Kettlebell Deadlift",8,10,12,6);
        exercise gobletRDL = new exercise("Goblet RDL",10,12,15,8);

        //compound gamma's

        exercise kbClean = new exercise("KB Clean",6,8,10,5);
        exercise kbsnatch = new exercise("KB Snatch",8,10,12,6);
        exercise splitSquat = new exercise("Bulgarian Split Squat",8,10,12,8);

        //secondaries

        exercise latLunge = new exercise("Lateral Lunge",5,7,9,5);
        exercise hikeClean = new exercise("Hike Clean",5,7,9,5);
        exercise swings = new exercise("KB Swings",12,15,20,10);
        exercise warriorLunge = new exercise("Warrior Lunge",10,12,12,10);
        exercise warriorSquat = new exercise("Warrior Squat",10,12,12,10);
        exercise getUps = new exercise("Kneeling Get-Ups",5,7,9,5);
        exercise deckSquat = new exercise("Deck Squat",6,8,10,6);
        exercise goodMornings = new exercise("KB Good Mornings",10,12,15,8);
        exercise clubSquats = new exercise("Steel Club Switch Squats", 5, 7, 9, 5);


        //tertiaries

        exercise slingshots = new exercise("Slingshots",10,12,15,10);
        exercise plank = new exercise("Plank",30,30,45,30);
        exercise sitThrough = new exercise("Sit-Throughs",5,7,9,5);

        compundAlphaList.add(kickstandFrontSquat);
        compundAlphaList.add(gobletSquat);
        compundBetaList.add(kickstandDead);
        compundBetaList.add(gobletRDL);
        compundGammaList.add(kbClean);
        compundGammaList.add(kbsnatch);
        compundGammaList.add(splitSquat);


        secondaryList.add(latLunge);
        secondaryList.add(hikeClean);
        secondaryList.add(swings);
        secondaryList.add(warriorLunge);
        secondaryList.add(warriorSquat);
        secondaryList.add(getUps);
        secondaryList.add(deckSquat);
        secondaryList.add(goodMornings);
        secondaryList.add(clubSquats);

        //secondaryList.add("Sandbag RDL's");
        //secondaryList.add("Glute Bridge");
        //secondaryList.add("Sandbag Clean");
        //secondaryList.add("Sandbag Squat");

        tertiaryList.add(slingshots);
        tertiaryList.add(plank);
        tertiaryList.add(sitThrough);

        if ( cycle.equals("1") ) { //                                                   Cycle 1
            long startTime = System.currentTimeMillis();
            System.out.println("Cycle 1:");
            System.out.println();//                                                            Set 1


            System.out.println("Set 1 X 3: ");

            //Print Slot 1

            Random ran = new Random();
            int nxt = ran.nextInt(compundAlphaList.size());
            System.out.println(compundAlphaList.get(nxt).getName() + " X " + compundAlphaList.get(nxt).getCycleOneRepCount());
            compundAlphaList.remove(nxt);

            //Print Slot 2

            Random ranSec = new Random();
            int secNxt = ranSec.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt).getName() + " X " + secondaryList.get(secNxt).getCycleOneRepCount());
            secondaryList.remove(secNxt);

            //Print Slot 3

            Random ranSec2 = new Random();
            int secNxt2 = ranSec2.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt2).getName() + " X " + secondaryList.get(secNxt2).getCycleOneRepCount());
            secondaryList.remove(secNxt2);

            System.out.println();//                                                            Set 2


            System.out.println("Set 2 X 3: ");

            //Print Slot 1

            Random ran2 = new Random();
            int nxt2 = ran2.nextInt(compundBetaList.size());
            System.out.println(compundBetaList.get(nxt2).getName() + " X " + compundBetaList.get(nxt2).getCycleOneRepCount());
            compundBetaList.remove(nxt2);

            //Print Slot 2

            Random ranSec3 = new Random();
            int secNxt3 = ranSec3.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt3).getName() + " X " + secondaryList.get(secNxt3).getCycleOneRepCount());
            secondaryList.remove(secNxt3);

            //Print Slot 3

            Random ranSec4 = new Random();
            int secNxt4 = ranSec4.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt4).getName() + " X " + secondaryList.get(secNxt4).getCycleOneRepCount());
            secondaryList.remove(secNxt4);

            System.out.println();//                                                            Set 3

            System.out.println("Set 3 X 3: ");

            //Print Slot 1

            Random ran3 = new Random();
            int nxt3 = ran3.nextInt(compundGammaList.size());
            System.out.println(compundGammaList.get(nxt3).getName() + " X " + compundGammaList.get(nxt3).getCycleOneRepCount());
            compundGammaList.remove(nxt3);

            //Print Slot 2

            Random ranSec5 = new Random();
            int secNxt5 = ranSec5.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt5).getName() + " X " + secondaryList.get(secNxt5).getCycleOneRepCount());
            secondaryList.remove(secNxt5);

            //Print Slot 3

            Random ranSec6 = new Random();
            int secNxt6 = ranSec6.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt6).getName() + " X " + secondaryList.get(secNxt6).getCycleOneRepCount());
            secondaryList.remove(secNxt6);
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            System.out.println();
            System.out.println(runTime + " ms");

        }
        //                                              for cycle 2 - two teritaries - 4 sets
        else if ( cycle.equals("2") ) {

            //                                                                         Set 1
            System.out.println("Cycle 2:");
            System.out.println();


            System.out.println("Set 1 X 4: ");

            //Print Slot 1

            Random ran = new Random();
            int nxt = ran.nextInt(compundAlphaList.size());
            System.out.println(compundAlphaList.get(nxt).getName() + " X " + compundAlphaList.get(nxt).getCycleTwoRepCount());
            compundAlphaList.remove(nxt);

            //Print Slot 2

            Random ranSec = new Random();
            int secNxt = ranSec.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt).getName() + " X " + secondaryList.get(secNxt).getCycleTwoRepCount());
            secondaryList.remove(secNxt);

            //Print Slot 3

            Random ranSec2 = new Random();
            int secNxt2 = ranSec2.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt2).getName() + " X " + secondaryList.get(secNxt2).getCycleTwoRepCount());
            secondaryList.remove(secNxt2);


            System.out.println();//                                                            Set 2


            System.out.println("Set 2 X 4: ");

            //Print Slot 1

            Random ran2 = new Random();
            int nxt2 = ran2.nextInt(compundBetaList.size());
            System.out.println(compundBetaList.get(nxt2).getName() + " X " + compundBetaList.get(nxt2).getCycleTwoRepCount());
            compundBetaList.remove(nxt2);

            //Print Slot 2

            Random ranSec3 = new Random();
            int secNxt3 = ranSec3.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt3).getName() + " X " + secondaryList.get(secNxt3).getCycleTwoRepCount());
            secondaryList.remove(secNxt3);

            //Print Slot 3

            Random ranSec4 = new Random();
            int secNxt4 = ranSec4.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt4).getName() + " X " + secondaryList.get(secNxt4).getCycleTwoRepCount());
            secondaryList.remove(secNxt4);

            //Print Slot 4

            Random ranSec10 = new Random();
            int secNxt10 = ranSec10.nextInt(tertiaryList.size());
            System.out.println(tertiaryList.get(secNxt10).getName() + " X " + tertiaryList.get(secNxt10).getCycleTwoRepCount());
            tertiaryList.remove(secNxt10);

            System.out.println();//                                                            Set 3

            System.out.println("Set 3 X 4: ");

            //Print Slot 1

            Random ran3 = new Random();
            int nxt3 = ran3.nextInt(compundGammaList.size());
            System.out.println(compundGammaList.get(nxt3).getName() + " X " + compundGammaList.get(nxt3).getCycleTwoRepCount());
            compundGammaList.remove(nxt3);

            //Print Slot 2

            Random ranSec5 = new Random();
            int secNxt5 = ranSec5.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt5).getName() + " X " + secondaryList.get(secNxt5).getCycleTwoRepCount());
            secondaryList.remove(secNxt5);

            //Print Slot 3

            Random ranSec6 = new Random();
            int secNxt6 = ranSec6.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt6).getName() + " X " + secondaryList.get(secNxt6).getCycleTwoRepCount());
            secondaryList.remove(secNxt6);

            //Print Slot 4

            Random ranSec7 = new Random();
            int secNxt7 = ranSec7.nextInt(tertiaryList.size());
            System.out.println(tertiaryList.get(secNxt7).getName() + " X " + tertiaryList.get(secNxt7).getCycleTwoRepCount());
            tertiaryList.remove(secNxt7);

            System.out.println();//                                                            Set 4

            System.out.println("Set 4 X 4: ");

            //Print Slot 1

            Random ran4 = new Random();
            int nxt4 = ran4.nextInt(compundGammaList.size());
            System.out.println(compundGammaList.get(nxt4).getName() + " X " + compundGammaList.get(nxt4).getCycleTwoRepCount());
            compundGammaList.remove(nxt4);

            //Print Slot 2

            Random ranSec9 = new Random();
            int secNxt9 = ranSec9.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt9).getName() + " X " + secondaryList.get(secNxt9).getCycleTwoRepCount());
            secondaryList.remove(secNxt9);

            //Print Slot 3

            Random ranSec8 = new Random();
            int secNxt8 = ranSec8.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt8).getName() + " X " + secondaryList.get(secNxt8).getCycleTwoRepCount());
            secondaryList.remove(secNxt8);
        }
        //                                              for cycle 3 - two teritaries - 4 sets
        else if ( cycle.equals("3") ) {

            //                                                                         Set 1
            System.out.println("Cycle 3:");
            System.out.println();


            System.out.println("Set 1 X 5: ");

            //Print Slot 1

            Random ran = new Random();
            int nxt = ran.nextInt(compundAlphaList.size());
            System.out.println(compundAlphaList.get(nxt).getName() + " X " + compundAlphaList.get(nxt).getCycleThreeRepCount());
            compundAlphaList.remove(nxt);

            //Print Slot 2

            Random ranSec = new Random();
            int secNxt = ranSec.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt).getName() + " X " + secondaryList.get(secNxt).getCycleThreeRepCount());
            secondaryList.remove(secNxt);

            //Print Slot 3

            Random ranSec2 = new Random();
            int secNxt2 = ranSec2.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt2).getName() + " X " + secondaryList.get(secNxt2).getCycleThreeRepCount());
            secondaryList.remove(secNxt2);


            System.out.println();//                                                            Set 2


            System.out.println("Set 2 X 5: ");

            //Print Slot 1

            Random ran2 = new Random();
            int nxt2 = ran2.nextInt(compundBetaList.size());
            System.out.println(compundBetaList.get(nxt2).getName() + " X " + compundBetaList.get(nxt2).getCycleThreeRepCount());
            compundBetaList.remove(nxt2);

            //Print Slot 2

            Random ranSec3 = new Random();
            int secNxt3 = ranSec3.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt3).getName() + " X " + secondaryList.get(secNxt3).getCycleThreeRepCount());
            secondaryList.remove(secNxt3);

            //Print Slot 3

            Random ranSec4 = new Random();
            int secNxt4 = ranSec4.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt4).getName() + " X " + secondaryList.get(secNxt4).getCycleThreeRepCount());
            secondaryList.remove(secNxt4);

            //Print Slot 4

            Random ranSec10 = new Random();
            int secNxt10 = ranSec10.nextInt(tertiaryList.size());
            System.out.println(tertiaryList.get(secNxt10).getName() + " X " + tertiaryList.get(secNxt10).getCycleThreeRepCount());
            tertiaryList.remove(secNxt10);

            System.out.println();//                                                            Set 3

            System.out.println("Set 3 X 5: ");

            //Print Slot 1

            Random ran3 = new Random();
            int nxt3 = ran3.nextInt(compundGammaList.size());
            System.out.println(compundGammaList.get(nxt3).getName() + " X " + compundGammaList.get(nxt3).getCycleThreeRepCount());
            compundGammaList.remove(nxt3);

            //Print Slot 2

            Random ranSec5 = new Random();
            int secNxt5 = ranSec5.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt5).getName() + " X " + secondaryList.get(secNxt5).getCycleThreeRepCount());
            secondaryList.remove(secNxt5);

            //Print Slot 3

            Random ranSec6 = new Random();
            int secNxt6 = ranSec6.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt6).getName() + " X " + secondaryList.get(secNxt6).getCycleThreeRepCount());
            secondaryList.remove(secNxt6);

            //Print Slot 4

            Random ranSec7 = new Random();
            int secNxt7 = ranSec7.nextInt(tertiaryList.size());
            System.out.println(tertiaryList.get(secNxt7).getName() + " X " + tertiaryList.get(secNxt7).getCycleThreeRepCount());
            tertiaryList.remove(secNxt7);

            System.out.println();//                                                            Set 4

            System.out.println("Set 4 X 5: ");

            //Print Slot 1

            Random ran4 = new Random();
            int nxt4 = ran4.nextInt(compundGammaList.size());
            System.out.println(compundGammaList.get(nxt4).getName() + " X " + compundGammaList.get(nxt4).getCycleThreeRepCount());
            compundGammaList.remove(nxt4);

            //Print Slot 2

            Random ranSec9 = new Random();
            int secNxt9 = ranSec9.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt9).getName() + " X " + secondaryList.get(secNxt9).getCycleThreeRepCount());
            secondaryList.remove(secNxt9);

            //Print Slot 3

            Random ranSec8 = new Random();
            int secNxt8 = ranSec8.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt8).getName() + " X " + secondaryList.get(secNxt8).getCycleThreeRepCount());
            secondaryList.remove(secNxt8);
        }
        else if ( cycle.equals("4") ) { //                                                   Cycle 4

            System.out.println("Cycle 4: Deload");
            System.out.println();//                                                            Set 1


            System.out.println("Set 1 X 3: ");

            //Print Slot 1

            Random ran = new Random();
            int nxt = ran.nextInt(compundAlphaList.size());
            System.out.println(compundAlphaList.get(nxt).getName() + " X " + compundAlphaList.get(nxt).getCycleFourRepCount());
            compundAlphaList.remove(nxt);

            //Print Slot 2

            Random ranSec = new Random();
            int secNxt = ranSec.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt).getName() + " X " + secondaryList.get(secNxt).getCycleFourRepCount());
            secondaryList.remove(secNxt);

            //Print Slot 3

            Random ranSec2 = new Random();
            int secNxt2 = ranSec2.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt2).getName() + " X " + secondaryList.get(secNxt2).getCycleFourRepCount());
            secondaryList.remove(secNxt2);

            System.out.println();//                                                            Set 2


            System.out.println("Set 2 X 3: ");

            //Print Slot 1

            Random ran2 = new Random();
            int nxt2 = ran2.nextInt(compundBetaList.size());
            System.out.println(compundBetaList.get(nxt2).getName() + " X " + compundBetaList.get(nxt2).getCycleFourRepCount());
            compundBetaList.remove(nxt2);

            //Print Slot 2

            Random ranSec3 = new Random();
            int secNxt3 = ranSec3.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt3).getName() + " X " + secondaryList.get(secNxt3).getCycleFourRepCount());
            secondaryList.remove(secNxt3);

            //Print Slot 3

            Random ranSec4 = new Random();
            int secNxt4 = ranSec4.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt4).getName() + " X " + secondaryList.get(secNxt4).getCycleFourRepCount());
            secondaryList.remove(secNxt4);

            System.out.println();//                                                            Set 3

            System.out.println("Set 3 X 3: ");

            //Print Slot 1

            Random ran3 = new Random();
            int nxt3 = ran3.nextInt(compundGammaList.size());
            System.out.println(compundGammaList.get(nxt3).getName() + " X " + compundGammaList.get(nxt3).getCycleFourRepCount());
            compundGammaList.remove(nxt3);

            //Print Slot 2

            Random ranSec5 = new Random();
            int secNxt5 = ranSec5.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt5).getName() + " X " + secondaryList.get(secNxt5).getCycleFourRepCount());
            secondaryList.remove(secNxt5);

            //Print Slot 3

            Random ranSec6 = new Random();
            int secNxt6 = ranSec6.nextInt(secondaryList.size());
            System.out.println(secondaryList.get(secNxt6).getName() + " X " + secondaryList.get(secNxt6).getCycleFourRepCount());
            secondaryList.remove(secNxt6);
        }
    }

    static ArrayList<String> pluck(ArrayList<String> array, String exr){
        array.remove(exr);
        return array;
    }

    static ArrayList<String> swap(ArrayList<String> choices, ArrayList<String> currentEmom, int indexFrom, int indexTo){
        currentEmom.remove(indexFrom-1);
        currentEmom.add(indexFrom-1, choices.get(indexTo-1));
        Iterator<String> iter = currentEmom.iterator();
        int count = 1;
        System.out.println();
        while (iter.hasNext()) {
            System.out.print(count + ". " + iter.next() + " ");
            System.out.println();
            ++count;
        }
        return currentEmom;
    }
    
    static void getEmomWorkout(){

        ArrayList<String> emomList = new ArrayList<String>();

        emomList.add("12 cal Airbike");
        emomList.add("Payloads");
        emomList.add("Figure 8 to Cleans");
        emomList.add("Deadlifts");
        emomList.add("Double Clean + Press");
        emomList.add("Sandbag Cleans");
        emomList.add("KB Snatch");
        emomList.add("Thrusters");
        emomList.add("360's");
        emomList.add("Single Kettlebell Clean + Press + Overhead Lunge");
        emomList.add("Barbell Hang Cleans");
        emomList.add("Barbell Front Squats");
        emomList.add("Double Indian Club Clean to Squat");
        emomList.add("Double Kettlebell Dragonflies");
        emomList.add("Rope Slams");
        emomList.add("Sled Face Pulls -> Pushes");
        emomList.add("Sled Pushes");
        emomList.add("Rotational Bag Slams");
        emomList.add("Single Kettlebell Row + Dead Clean + Strict Press");
        emomList.add("Figure 8 to Tactical Snatch");
        emomList.add("Single Indian Club Swing Clean to Pullover");

        Integer[] numbers = new Integer[5]; 
        Integer[] obj = new Integer[5];

        //Generates 5 Random Numbers in the range of the emomList
        System.out.println();
        for(int i = 0; i < numbers.length; i++) {

            obj[i] = (int)(Math.random() * emomList.size());
            Integer toCheckValue = obj[i];
            boolean verification = check(numbers, toCheckValue);

            if (verification == true) {
                do {
                    obj[i] = (int)(Math.random() * emomList.size());
                    toCheckValue = obj[i];
                    verification = check(numbers, toCheckValue);
                } while (verification);
            }
            numbers[i] = obj[i];            
            System.out.println((i+1) + ". " + emomList.get(numbers[i]));
        }
        
        // System.out.println();
        ArrayList<String> myStrings = new ArrayList<String>();
        for (int i = 0; i < 5; i++){
            myStrings.add(emomList.get(numbers[i]));
        }


        for (int i = 0; i < 5; i++){
            emomList = pluck(emomList, myStrings.get(i));
        }

        boolean keepGoing = false;
       
        String toggle;
        int oneToSwap;
        int replacement;
        Scanner scnr = new Scanner(System.in);
        do {
            System.out.println();
            System.out.println("Would you like to swap one exercise? Enter 'y' for yes, or 'n' for no");
            toggle = scnr.next();
            if (toggle.equals("n") || toggle.equals("N")) {
                keepGoing = true;
            }
            else if (toggle.equals("y") || toggle.equals("Y")){
                if (emomList.size() != 0){
                keepGoing = false;
                System.out.println("Which exercise would you like to change? Enter Number: ");
                Iterator<String> iter = myStrings.iterator();

                int count = 1;

                while (iter.hasNext()) {
                    System.out.print(count + ". " + iter.next() + " ");
                    System.out.println();
                    ++count;
                }

                count = 1;

                oneToSwap = scnr.nextInt();
                Iterator<String> iter1 = emomList.iterator();
                System.out.println("\nSelect which one you'd like to substitute: ");
                System.out.println();

                
                while (iter1.hasNext()) {
                    System.out.print(count + ". " + iter1.next() + " ");
                    System.out.println();
                    ++count;
                }

                replacement = scnr.nextInt();
                myStrings = swap(emomList, myStrings, oneToSwap, replacement);
                emomList = pluck(emomList, myStrings.get(oneToSwap-1));
                }
                else{
                    System.out.println("No more choices. Quit being a bitch and get to work!");
                    break;
                }
            }
            else {
                keepGoing = false;
                System.out.println("Invalid Entry.");
            }
        } while (!keepGoing);  
        scnr.close();    
    }


    static void getTabataWorkout() {
        System.out.println("Hey, you've now reached the Tabata Side.");
    }
}
