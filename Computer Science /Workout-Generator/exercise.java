
public class exercise {
    private String name;
    private int cycleOneRepCount;
    private int cycleTwoRepCount;
    private int cycleThreeRepCount;
    private int cycleFourRepCount;

    public exercise(String name, int cycleOneRepCount, int cycleTwoRepCount, int cycleThreeRepCount, int cycleFourRepCount) {
        this.name = name;
        this.cycleOneRepCount = cycleOneRepCount;
        this.cycleTwoRepCount = cycleTwoRepCount;
        this.cycleThreeRepCount = cycleThreeRepCount;
        this.cycleFourRepCount = cycleFourRepCount;
        

    }

    public String getName() {
        return name;
    }

    public int getCycleOneRepCount() {
        return cycleOneRepCount;
    }

    public int getCycleTwoRepCount() {
        return cycleTwoRepCount;
    }

    public int getCycleThreeRepCount() {
        return cycleThreeRepCount;
    }

    public int getCycleFourRepCount() {
        return cycleFourRepCount;
    }
}