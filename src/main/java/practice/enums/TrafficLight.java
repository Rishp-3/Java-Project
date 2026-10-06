package practice.enums;

/** Problem 2: enum as a tiny state machine - each constant knows its own duration and successor. */
public enum TrafficLight {
    RED(30) { @Override public TrafficLight next() { return GREEN; } },
    GREEN(25) { @Override public TrafficLight next() { return YELLOW; } },
    YELLOW(5) { @Override public TrafficLight next() { return RED; } };

    private final int seconds;

    TrafficLight(int seconds) { this.seconds = seconds; }

    public int seconds() { return seconds; }

    public abstract TrafficLight next();

    /** Total time of one full cycle. */
    public static int cycleSeconds() {
        int total = 0;
        for (TrafficLight l : values()) total += l.seconds;
        return total;
    }
}
